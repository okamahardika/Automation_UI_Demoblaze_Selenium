package app.binar.handler;

import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class Action {

    WebDriver webDriver;

    public Action(WebDriver driver) {
        this.webDriver = driver;
    }

    public void validateElementIsVisibleAndEnabled(WebElement webElement) {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(webElement));

        if (!webElement.isDisplayed() || !webElement.isEnabled()) {
            System.out.println("element not visible or enabled");
            throw new ElementNotInteractableException(webElement.toString());
        }
    }

    public void waitElementToBeDisplayed(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void alertHandler(boolean isApproved) {
        try {
            if (isApproved) {
                Thread.sleep(3000);
                webDriver.switchTo().alert().accept();
            } else {
                Thread.sleep(3000);
                new WebDriverWait(webDriver, Duration.ofSeconds(5));
                webDriver.switchTo().alert().dismiss();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public String getAlertMessage() {
        String message ="";
        try {
            Thread.sleep(3000);
            message =  webDriver.switchTo().alert().getText();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return message;
    }
}
