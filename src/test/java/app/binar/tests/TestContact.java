package app.binar.tests;

import app.binar.handler.Action;
import app.binar.handler.TestDataProvider;
import app.binar.pages.ContactPage;
import app.binar.pages.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestContact {
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
            System.out.println("Chrome Driver Closed");
        }
    }

    @Test(description = "user should be able to send message on contact page")
    public void userShouldBeAbleToSendMessageOnContactPage() {
        HomePage homePage = new HomePage(webDriver);
        homePage.tapNavLinkContact();

        String email = TestDataProvider.getRandomEmail();
        String name = TestDataProvider.getRandomUserName();
        String message = "Halo komplain nih.......";
        System.out.println(email);

        ContactPage contactPage = new ContactPage(webDriver);
        contactPage.sendMessageContact(email, name, message);

        //assertion for pop up without element
        Assert.assertEquals(new Action(webDriver).getAlertMessage(),"Thanks for the message!!");
        new Action(webDriver).alertHandler(true);

    }
}
