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
public class LoginPage {

    protected WebDriver webDriver;
    protected Action action;

    public LoginPage(WebDriver driver) {
        this.webDriver = driver;
        this.action = new Action(this.webDriver);
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(id = "loginusername")
    private WebElement userNameField;

    @FindBy(id = "loginpassword")
    private WebElement passwordField;

    @FindBy(xpath = "//button[text()='Log in']")
    private WebElement btnLogin;

    @FindBy(xpath = "//*[@id='logInModal']/div/div/div[3]/button[1]")
    private WebElement btnClose;

    @FindBy(xpath = "//*[@id='logInModal']/div/div/div[1]/button")
    private WebElement btnX;

    public void userLogin(String userName, String password) {
        enterUserName(userName);
        enterPassword(password);
        tapLogin();
    }

    public void enterUserName(String userName) {
        action.waitElementToBeDisplayed(userNameField, 3);
        userNameField.sendKeys(userName);
    }

    public void enterPassword(String password) {
        action.waitElementToBeDisplayed(passwordField, 3);
        passwordField.sendKeys(password);
    }

    public void tapLogin() {
        action.waitElementToBeDisplayed(btnLogin, 3);
        btnLogin.click();
    }

    public void tapClose() {
        action.waitElementToBeDisplayed(btnClose, 3);
        btnClose.click();
    }

    public void tapCloseX() {
        action.waitElementToBeDisplayed(btnX, 3);
        btnX.click();
    }
}
