package app.binar.tests.demoblaze;

import app.binar.handler.Action;
import app.binar.handler.TestDataProvider;
import app.binar.pages.demoblaze.HomePage;
import app.binar.pages.demoblaze.LoginPage;
import app.binar.pages.demoblaze.SignUpPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;


public class TestSignUp {

    WebDriver webDriver;

    @BeforeMethod(alwaysRun = true)
    public void launchChrome() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        webDriver = new ChromeDriver(options);
        webDriver.get("https://www.demoblaze.com/");
        webDriver.manage().window().fullscreen();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @AfterMethod
    public void closeDriver() {
        if (webDriver!=null) {
            webDriver.close();
        }
    }

    @Test(groups = {"positive", "signup"},
            description = "user should be able to signup using new credential")
    public void userShouldEnableToSignUpUsingNewCredential() {
        // navigate to signup page
        HomePage homePage = new HomePage(webDriver);
        homePage.tapNavLinkSignUp();

        // get new credential
        String userName = TestDataProvider.getRandomUserName();
        String password = TestDataProvider.getRandomPasswordNumber();

        // register new user
        SignUpPage signUpPage = new SignUpPage(webDriver);
        signUpPage.registerNewUser(userName, password);

        // handle alert
        new Action(webDriver).alertHandler(true);

        // navigate to login page
        homePage.tapNavLinkLogin();

        // new user login
        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.userLogin(userName, password);

        // assert login page
        Assert.assertTrue(homePage.getNameOfUser().contains(userName));
    }
}
