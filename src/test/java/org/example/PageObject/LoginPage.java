package org.example.PageObject;

import org.example.Resources.Locators;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    public WebDriver driver;
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    public LoginPage fillEmailField(String email) {
        driver.findElement(Locators.LoginPageLocators.emailField).sendKeys(email);
        return this;
    }
    public LoginPage fillPasswordField(String password) {
        driver.findElement(Locators.LoginPageLocators.passwordField).sendKeys(password);
        return this;
    }
    public LoginPage clickLogInButton() {
        driver.findElement(Locators.LoginPageLocators.logInButton).click();
        return this;
    }
}
