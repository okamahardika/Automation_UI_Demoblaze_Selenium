package app.binar.tests;

import app.binar.pages.HomePage;
import app.binar.pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

/**
 * @author regiewby on 20/11/22
 * @project web-automation-learning
 */
public class TestLogin {

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

    @Test(groups = {"positive", "login"},
            description = "user should be able to login using valid credential")
    public void userShouldBeAbleToLoginUsingValidCredential() {
        // navigate to login page
        HomePage homePage = new HomePage(webDriver);
        homePage.tapNavLinkLogin();

        // user login
        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.userLogin("regiewby", "password");

        // assert login page
        Assert.assertTrue(homePage.getNameOfUser().contains("regiewby"));
    }
}
