package org.example.Resources;

import org.openqa.selenium.By;

public class Locators {
    public class LoginPageLocators {
        public final static By emailField = By.id("email");
        public final static By passwordField = By.id("password");
        public final static By logInButton = By.id("login-submit");
    }
    public class MainPageLocators {
        public final static By addEmployeeButton = By.xpath("//*[@class = 'dropdown-toggle' and @title = 'Добавить сотрудника']");
    }
    public class InvitePageLocators {
        public final static By importEmployeesButton = By.id("button-1037-btnInnerEl");
        public final static By selectFileButton = By.id("file");
        public final static By importButton = By.id("yaware-modal-button-0");
        public final static By sendInviteButton = By.className("import-users-notifying-label");
        public final static By deleteButtonInModalWindow = By.id("yaware-modal-button-0");
        public final static By successPopUp = By.xpath("//*[@class = 'toast toast-success']/*[@class = 'toast-message']");
        public final static By windowsDownloadButton = By.id("windows-download-link");
        public final static By linuxDownloadButton = By.id("linux-download-link");
        public final static By macosDownloadButton = By.id("macos-download-link");
        public final static By searchButton = By.id("button-1014-btnEl");
        public final static By searchField = By.id("searchFieldinvite-grid-inputEl");
        public final static By okSearchButton = By.id("makeSearchQueryinvite-grid-btnIconEl");
        public final static By noDataLabel = By.className("no_data");
        public static By tableData(int row, int column) {
            return By.xpath(String.format("//*[@id = 'gridview-1034-body']/tr[%d]/td[%d]/div", row, column));
        }
        public static By deleteInviteButton(int row) {
            return By.xpath(String.format("//*[@id = 'gridview-1034-body']/tr[%d]/td[contains(@class, 'x-grid-cell-last')]/descendant::*[contains(@id, 'hidden-invite-grid')]", row));
        }
        public static By copyDownloadLinkButton(int row) {
            return By.xpath(String.format("//*[@id = 'gridview-1034-body']/tr[%d]/td[contains(@class, 'x-grid-cell-last')]/descendant::*[contains(@id, 'copy-link-invite-grid')]", row));
        }
    }
}
