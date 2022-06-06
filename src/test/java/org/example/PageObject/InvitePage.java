package org.example.PageObject;

import org.example.FileGenerator.Employee;
import org.openqa.selenium.WebDriver;
import org.junit.Assert;
import java.util.ArrayList;
import java.util.Date;
import org.example.Resources.*;
import static org.example.Resources.Constants.*;

public class InvitePage {
    public WebDriver driver;
    public InvitePage(WebDriver driver) {
        this.driver = driver;
    }
    public InvitePage clickImportEmployeesButton() {
        driver.findElement(Locators.InvitePageLocators.importEmployeesButton).click();
        return this;
    }
    public InvitePage clickImportButton() {
        driver.findElement(Locators.InvitePageLocators.importButton).click();
        return this;
    }
    public InvitePage clickSendInviteButton() {
        driver.findElement(Locators.InvitePageLocators.sendInviteButton).click();
        return this;
    }
    public InvitePage selectFile() {
        driver.findElement(Locators.InvitePageLocators.selectFileButton).sendKeys(Constants.Generator.PathToCSV);
        return this;
    }
    public InvitePage clickDeleteInviteButton(int row) {
        driver.findElement(Locators.InvitePageLocators.deleteInviteButton(row)).click();
        return this;
    }
    public InvitePage clickDeleteButtonInModalWindow() {
        driver.findElement(Locators.InvitePageLocators.deleteButtonInModalWindow).click();
        return this;
    }
    public InvitePage clickCopyDownloadLinkButton(int row) {
        driver.findElement(Locators.InvitePageLocators.copyDownloadLinkButton(row)).click();
        return this;
    }
    public InvitePage clickSearchButton() {
        driver.findElement(Locators.InvitePageLocators.searchButton).click();
        return this;
    }
    public InvitePage fillSearchField(String seachName) {
        driver.findElement(Locators.InvitePageLocators.searchField).sendKeys(seachName);
        return this;
    }
    public InvitePage clickOkSearchButton() {
        driver.findElement(Locators.InvitePageLocators.okSearchButton).click();
        return this;
    }
    public InvitePage deleteInvitation(int row) {
        clickDeleteInviteButton(row);
        clickDeleteButtonInModalWindow();
        return this;
    }
    public InvitePage verifyCorrectImportedData(ArrayList<Employee> employees) throws InterruptedException {
        Thread.sleep(5000);
        var actual = new ArrayList<String>();
        for(int i = 1; i <= employees.size(); i++){
            actual.add(driver.findElement(Locators.InvitePageLocators.tableData(i, 1)).getText()
            + " " + driver.findElement(Locators.InvitePageLocators.tableData(i, 2)).getText());
        }
        var expected = new ArrayList<String>();
        for(int i = 0; i < employees.size(); i++){
            expected.add(employees.get(i).getFullName() + " " + employees.get(i).getEmail());
        }
        int coincidence = 0;
        for(var employeeActual: actual)
            for(var employeeExpected: expected)
                if (employeeActual.equals(employeeExpected))
                    coincidence++;
        Assert.assertEquals(employees.size(), coincidence);
        return this;
    }
    public InvitePage verifyCorrectInviteDate(int count) {
        int coincidence = 0;
        var currentDate = dateFormat.format(new Date());
        for(int i = 1; i <= count; i++){
            var expectedDate = driver.findElement(Locators.InvitePageLocators.tableData(i, 3)).getText();
            if(currentDate.equals(expectedDate.substring(0, expectedDate.length() - 3)))
                coincidence++;
        }
        Assert.assertEquals(count, coincidence);
        return this;
    }
    public InvitePage verifySuccessPopUp() throws InterruptedException {
        Thread.sleep(5000);
        var actual = driver.findElement(Locators.InvitePageLocators.successPopUp).getText();
        Assert.assertEquals(successPopUpText, actual);
        return this;
    }
    public InvitePage verifyListCopyDownloadLink() {
        ArrayList<String> expectedList = new ArrayList<String>();
        expectedList.add(windowsText);
        expectedList.add(linuxText);
        expectedList.add(macosText);
        ArrayList<String> actualList = new ArrayList<String>();
        actualList.add(driver.findElement(Locators.InvitePageLocators.windowsDownloadButton).getText());
        actualList.add(driver.findElement(Locators.InvitePageLocators.linuxDownloadButton).getText());
        actualList.add(driver.findElement(Locators.InvitePageLocators.macosDownloadButton).getText());
        Assert.assertEquals(expectedList, actualList);
        return this;
    }
    public InvitePage verifyDeleteInvitation(int row) {
        var employeeName = driver.findElement(Locators.InvitePageLocators.tableData(row, 1)).getText();
        deleteInvitation(row);
        clickSearchButton();
        fillSearchField(employeeName);
        clickOkSearchButton();
        var actual = driver.findElement(Locators.InvitePageLocators.noDataLabel).getText();
        Assert.assertEquals(noDataText, actual);
        return this;
    }
}
