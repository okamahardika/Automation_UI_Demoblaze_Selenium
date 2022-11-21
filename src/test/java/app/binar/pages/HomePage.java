package app.binar.pages;

import app.binar.handler.Action;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

/**
 * @author regiewby on 16/11/22
 * @project web-automation-learning
 */
public class HomePage {

    protected WebDriver webDriver;
    protected Action action;

    public HomePage(WebDriver driver) {
        this.webDriver = driver;
        this.action = new Action(this.webDriver);
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(id = "login2")
    private WebElement navLinkLogin;

    @FindBy(id = "signin2")
    private WebElement navLinkSignUp;

    @FindBy(id = "nameofuser")
    private WebElement navLinkNameOfUser;


    public void tapNavLinkLogin() {
        action.waitElementToBeDisplayed(navLinkLogin, 3);
        navLinkLogin.click();
    }

    public void tapNavLinkSignUp() {
        action.waitElementToBeDisplayed(navLinkSignUp, 3);
        navLinkSignUp.click();
    }

    public String getNameOfUser() {
        action.waitElementToBeDisplayed(navLinkNameOfUser, 3);
        action.validateElementIsVisibleAndEnabled(navLinkNameOfUser);
        return navLinkNameOfUser.getText();
    }
}
