package org.example.PageObject;

import org.example.Resources.Locators;
import org.openqa.selenium.WebDriver;

public class MainPage {
    public WebDriver driver;
    public MainPage(WebDriver driver) {
        this.driver = driver;
    }
    public MainPage clickAddEmployeeButton() {
        driver.findElement(Locators.MainPageLocators.addEmployeeButton).click();
        return this;
    }
}
