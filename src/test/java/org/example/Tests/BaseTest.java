package org.example.Tests;

import org.example.Resources.Constants;
import org.example.PageObject.*;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    public static WebDriver driver;

    @BeforeClass
    public static void setup() {
        System.setProperty(Constants.webdriverProperty, Constants.chromeDriverPath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(Constants.websiteURL);
        new LoginPage(driver)
                .fillEmailField(Constants.emailUser)
                .fillPasswordField(Constants.passwordUser)
                .clickLogInButton();
        new MainPage(driver).clickAddEmployeeButton();
    }

    @AfterClass
    public static void tearDown() throws InterruptedException {
        driver.navigate().refresh();
        for (int i = 1; i <= 9; i++) {
            new InvitePage(driver)
                    .clickDeleteInviteButton(1)
                    .clickDeleteButtonInModalWindow();
            Thread.sleep(3000);
        }
        driver.quit();
    }
}
