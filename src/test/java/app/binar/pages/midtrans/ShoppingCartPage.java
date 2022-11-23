package app.binar.pages.midtrans;

import app.binar.handler.Action;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class ShoppingCartPage {
    protected WebDriver webDriver;
    protected Action action;

    public ShoppingCartPage(WebDriver driver) {
        this.webDriver = driver;
        this.action = new Action(this.webDriver);
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        PageFactory.initElements(webDriver, this);
    }

    @FindBy (xpath = "//input[@class='text-right']")
    private WebElement txtAmount;

    @FindBy (xpath = "//input[@value='Budi']")
    private WebElement txtName;

    @FindBy (xpath = "//input[@class='text-right']")
    private WebElement txtEmail;

    @FindBy (xpath = "//input[@value='081808466410']")
    private WebElement txtPhone;

    @FindBy (xpath = "//input[@value='Jakarta']")
    private WebElement txtCity;

    @FindBy (xpath = "//textarea[.='MidPlaza 2, 4th Floor Jl.Jend.Sudirman Kav.10-11']")
    private WebElement txtAddress;

    @FindBy (xpath = "//input[@value='10220']")
    private WebElement txtPostalCode;

    @FindBy (xpath = "//div[@class='cart-checkout']")
    private WebElement btnCheckout;

    public void registerNewUser() {
        tapButtonCheckout();
    }

   /* public void enterUserName(String userName) {
        action.waitElementToBeDisplayed(userNameField, 3);
        userNameField.sendKeys(userName);
    }

    public void enterPassword(String password) {
        action.waitElementToBeDisplayed(passwordField, 3);
        passwordField.sendKeys(password);
    }*/

    public void tapButtonCheckout() {
        action.waitElementToBeDisplayed(btnCheckout, 3);
        btnCheckout.click();
    }
}
