package app.binar.pages;

import app.binar.handler.Action;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;


public class ContactPage {
    protected WebDriver webDriver;
    protected Action action;


    public ContactPage(WebDriver driver){
        this.webDriver = driver;
        this.action = new Action(this.webDriver);
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        PageFactory.initElements(webDriver,this);
    }

    @FindBy(xpath = "//input[@id='recipient-email']")
    private WebElement txtEmail;

    @FindBy (xpath = "//input[@id='recipient-name']")
    private WebElement txtName;

    @FindBy (xpath = "//textarea[@id='message-text']")
    private WebElement txtMessage;

    @FindBy (xpath = "//div[@id='exampleModal']//button[@class='btn btn-secondary']")
    private WebElement btnClose;

    @FindBy (xpath = "//button[.='Send message']")
    private WebElement btnSend;

    @FindBy (xpath = "//div[@id='exampleModal']//span[.='×']")
    private WebElement btnX;

    public void sendMessageContact (String email, String name, String message){
        enterEmail(email);
        enterName(name);
        enterMessage(message);
        tapBtnSend();
    }

    public void enterEmail(String email) {
        action.waitElementToBeDisplayed(txtEmail, 3);
        txtEmail.sendKeys(email);
    }

    public void enterName(String name) {
        action.waitElementToBeDisplayed(txtName, 3);
        txtName.sendKeys(name);
    }

    public void enterMessage(String message) {
        action.waitElementToBeDisplayed(txtMessage, 3);
        txtMessage.sendKeys(message);
    }

    public void tapBtnSend() {
        action.waitElementToBeDisplayed(btnSend, 3);
        btnSend.click();
    }

    public void cancelContactWithBtnCancel(){
        action.waitElementToBeDisplayed(btnClose, 3);
        btnClose.click();
    }

    public void cancelContactWithSymbolX(){
        action.waitElementToBeDisplayed(btnX, 3);
        btnX.click();
    }
}
