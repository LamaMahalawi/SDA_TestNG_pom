package Assignments.Assignment05.UserStory7.Test;

import io.qameta.allure.*;
import com.aventstack.extentreports.*;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import Assignments.Assignment05.UserStory7.Page.RegistrationPage;
import utilities.Driver;
import utilities.ExtentReportManager;

@Feature("Password Validation")
@Listeners(utilities.MyTestListener.class)
public class PasswordTest {

    @Test
    @Description("Verify different password strengths on the Registration form")
    @Severity(SeverityLevel.CRITICAL)
    public void testPasswordCases() {
        String url = "https://claruswaysda.github.io/Registration.html";

        String[] passwords = {
                "666",
                "12345678",
                "12345678910",
                "1234aaaa",
                "abc123",
                "Lama@1234",
                "",
                "lamamm",
                "AbcdEfghIjKl",
                "aaaaaaaa",
                "@@@@@@",
                "Lama2003#"
        };

        for (String pass : passwords) {
            Driver.getDriver().get(url);

            RegistrationPage regPage = new RegistrationPage().fillAllFields(pass);
            regPage.clickRegister();

            try {
                String alertText = Driver.getDriver().switchTo().alert().getText();
                Driver.getDriver().switchTo().alert().accept();
                System.out.println("Password: " + pass + " --> " + alertText);
                ExtentReportManager.log(Status.INFO, "Password: " + pass + " --> " + alertText);

            } catch (Exception e) {
                JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
                String validationMsg = (String) js.executeScript(
                        "return arguments[0].validationMessage;", regPage.password);
                System.out.println("Password: " + pass + " --> " + validationMsg);
                ExtentReportManager.log(Status.INFO, "Password: " + pass + " --> " + validationMsg);
            }
        }

        Driver.closeDriver();
    }
}