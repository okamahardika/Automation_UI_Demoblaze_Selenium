package app.binar.pages;

import app.binar.handler.Action;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class SignUpPage {

    protected WebDriver webDriver;
    protected Action action;

    public SignUpPage(WebDriver driver) {
        this.webDriver = driver;
        this.action = new Action(this.webDriver);
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(id = "sign-username")
    private WebElement userNameField;

    @FindBy(id = "sign-password")
    private WebElement passwordField;

    @FindBy(xpath = "//button[text()='Sign up']")
    private WebElement btnSignUp;

    public void registerNewUser(String userName, String password) {
        enterUserName(userName);
        enterPassword(password);
        tapButtonSignUp();
    }

    public void enterUserName(String userName) {
        action.waitElementToBeDisplayed(userNameField, 3);
        userNameField.sendKeys(userName);
    }

    public void enterPassword(String password) {
        action.waitElementToBeDisplayed(passwordField, 3);
        passwordField.sendKeys(password);
    }

    public void tapButtonSignUp() {
        action.waitElementToBeDisplayed(passwordField, 3);
        btnSignUp.click();
    }
}
