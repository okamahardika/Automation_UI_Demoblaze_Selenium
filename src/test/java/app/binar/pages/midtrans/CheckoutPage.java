package app.binar.pages.midtrans;

import app.binar.handler.Action;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class CheckoutPage {

    protected WebDriver webDriver;
    protected Action action;

    public CheckoutPage(WebDriver driver) {
        this.webDriver = driver;
        this.action = new Action(this.webDriver);
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(xpath = "//img[@alt='VISA']")
    private WebElement btnCreditCardVisa;

    @FindBy (xpath = "//div[@class='card-number-input-container']/input[@class='valid-input-value']")
    private WebElement btnCheckout;
}
