package app.binar.pages.demoblaze;

import app.binar.handler.Action;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;


public class HomePage {

    protected WebDriver webDriver;
    protected Action action;

    public HomePage(WebDriver driver) {
        this.webDriver = driver;
        this.action = new Action(this.webDriver);
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        PageFactory.initElements(webDriver, this);
    }

    @FindBy (xpath = "//a[.='Home (current)']")
    private WebElement navLinkHome;

    @FindBy (xpath = "//a[.='Contact']")
    private WebElement navLinkContact;

    @FindBy (xpath = "//a[.='About us']")
    private WebElement navLinkAboutUs;

    @FindBy (xpath = "//a[.='Cart']")
    private WebElement navLinkCart;

    @FindBy (xpath = "//a[.='Log in']")
    private WebElement navLinkLogin;

    @FindBy (xpath = "//a[.='Sign up']")
    private WebElement navLinkSignUp;

    @FindBy (xpath = "//a[.='Log out']")
    private  WebElement navLinkLogOut;

    @FindBy (xpath = "//a[@id='nameofuser']")
    private WebElement navLinkNameOfUser;

    public void tapNavLinkHome(){
        navLinkHome.click();
    }

    public void tapNavLinkContact(){
        navLinkContact.click();
    }

    public void tapNavLinkAboutUs(){
        navLinkAboutUs.click();
    }

    public void tapNavLinkCart(){
        navLinkCart.click();
    }


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
