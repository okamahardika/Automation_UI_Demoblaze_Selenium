package app.binar.tests.midtrans;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestBuyNow {
    WebDriver webDriver;

    @BeforeMethod(alwaysRun = true)
    public void launchChrome() {
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

    }
}
