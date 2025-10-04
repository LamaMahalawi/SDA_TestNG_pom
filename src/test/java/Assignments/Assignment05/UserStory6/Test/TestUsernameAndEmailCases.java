package Assignments.Assignment05.UserStory6.Test;

import Assignments.Assignment05.UserStory6.Page.RegistrationPage;
import com.aventstack.extentreports.Status;
import io.qameta.allure.*;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ExtentReportManager;

@Feature("Username and Email Validation")
@Listeners(utilities.MyTestListener.class)
public class TestUsernameAndEmailCases {

    @Test
    @Description("Verify username (10 cases) and email (10 cases) on the Registration form")
    @Severity(SeverityLevel.CRITICAL)
    public void testUsernameAndEmailCases() {
        String url = "https://claruswaysda.github.io/Registration.html";

        String[] usernames = {
                "",               // empty
                "lama",           // letters only
                "12345",          // digits only
                "lama123",        // mix letters + digits
                "lama_ma",        // underscore
                "lama-ma",        // dash
                "lama@user",      // space
                "LAMA",           // uppercase
                "lamalamalamalamala", // long username
                "lama!"          // special chars
        };

        String[] emails = {
                "plainaddress",            // invalid
                "@no-local.com",           // invalid
                "Lama@",                   // invalid
                "Lama@@domain",            // invalid
                "lama@.com",               // invalid
                "lama@domain..com",        // invalid
                "lama@example.com",        // valid
                "first.last@sub.domain.org", // valid
                "lama+tag@domain.co",      // valid
                "L_123@domain.io"          // valid
        };

        String validEmail = "lama@example.com";
        String validUsername = "lama_2003";


        for (String u : usernames) {
            Driver.getDriver().get(url);
            RegistrationPage regPage = new RegistrationPage().fillAllFields(u, validEmail);
            regPage.clickRegister();

            try {
                String alertText = Driver.getDriver().switchTo().alert().getText();
                Driver.getDriver().switchTo().alert().accept();
                System.out.println("Username: " + u + " --> " + alertText);
                ExtentReportManager.log(Status.INFO, "Username: " + u + " --> " + alertText);
            } catch (Exception ex) {
                JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
                String validationMsg = (String) js.executeScript(
                        "return arguments[0].validationMessage;", regPage.username);
                System.out.println("Username: " + u + " --> " + validationMsg);
                ExtentReportManager.log(Status.INFO, "Username: " + u + " --> " + validationMsg);
            }
        }

        for (String e : emails) {
            Driver.getDriver().get(url);
            RegistrationPage regPage = new RegistrationPage().fillAllFields(validUsername, e);
            regPage.clickRegister();

            try {
                String alertText = Driver.getDriver().switchTo().alert().getText();
                Driver.getDriver().switchTo().alert().accept();
                System.out.println("Email: " + e + " --> " + alertText);
                ExtentReportManager.log(Status.INFO, "Email: " + e + " --> " + alertText);
            } catch (Exception ex) {
                JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
                String validationMsg = (String) js.executeScript(
                        "return arguments[0].validationMessage;", regPage.email);
                System.out.println("Email: " + e + " --> " + validationMsg);
                ExtentReportManager.log(Status.INFO, "Email: " + e + " --> " + validationMsg);
            }
        }

        Driver.closeDriver();
    }
}