package org.example.Tests;

import org.example.FileGenerator.Employee;
import org.example.PageObject.InvitePage;
import org.junit.Test;
import java.util.ArrayList;
import static org.example.FileGenerator.CSVGenerator.*;

public class VerificationImportedData extends BaseTest {

    @Test
    public void verificationImportedData() throws InterruptedException {
        CSVCoder(10);
        ArrayList<Employee> employees = CSVDecoder();
        new InvitePage(driver)
                .clickImportEmployeesButton()
                .selectFile()
                .clickImportButton()
                .clickSendInviteButton()
                .clickImportButton()
                .verifySuccessPopUp()
                .verifyCorrectImportedData(employees)
                .verifyCorrectInviteDate(employees.size())
                .clickCopyDownloadLinkButton(1)
                .verifyListCopyDownloadLink()
                .verifyDeleteInvitation(1);
    }
}

