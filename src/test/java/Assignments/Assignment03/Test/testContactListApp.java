package Assignments.Assignment03.Test;

import com.aventstack.extentreports.Status;
import com.github.javafaker.Faker;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import Assignments.Assignment03.Pages.LoginPage;
import Assignments.Assignment03.Pages.ContactListPage;
import Assignments.Assignment03.Pages.AddContactPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ExtentReportManager;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Locale;

@Listeners(utilities.MyTestListener.class)
public class testContactListApp {

    @Test
    void contactListReportTest(){

        // ✦ Navigate to the application
        ExtentReportManager.createTest("Contact List ");
        ExtentReportManager.log(Status.INFO, "Navigating to Contact List App");
        Driver.getDriver().get(ConfigReader.getProperty("cl_url"));
        System.out.println("Navigated to Contact List App Successfully");

        // ✦ Create a new user account
        ExtentReportManager.log(Status.INFO, "Creating a new user account");
        System.out.println("Creating a new user account: " + true);


        LoginPage loginPage = new LoginPage();
        Faker faker = new Faker();
        loginPage.signup.click();
        loginPage.signUp(
                faker.name().firstName(),
                faker.name().lastName(),
                faker.internet().emailAddress(),
                faker.internet().password());
        System.out.println("New user signed up successfully");


        ContactListPage contactListPage = new ContactListPage();
        try {
            Assert.assertTrue(contactListPage.logout.isDisplayed());
            ExtentReportManager.log(Status.PASS, "User registration successful");
            System.out.println("User registration successful");
        } catch (AssertionError e) {
            ExtentReportManager.log(Status.FAIL, "User registration failed");
            System.out.println("User registration failed");
            throw e;
        }

        // ✦ Add 5 different contacts
        ExtentReportManager.log(Status.INFO, "Adding 5 contacts");
        System.out.println("Adding 5 contacts");
        for (int i = 0; i < 5; i++) {
            Driver.getDriver().navigate().refresh();

            AddContactPage addContactPage = new AddContactPage();
            contactListPage.addContact.click();
            addContactPage.addContact(
                    faker.name().firstName(),
                    faker.name().lastName(),
                    new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).format(faker.date().birthday()),
                    faker.internet().emailAddress(),
                    faker.phoneNumber().cellPhone().replaceAll("[^0-9]", ""),
                    faker.address().streetAddress(),
                    faker.address().streetAddress(),
                    faker.address().city(),
                    faker.address().state(),
                    faker.address().zipCode(),
                    faker.country().name()
            );
            System.out.println("Contact " + (i+1) + " added successfully");


            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(contactListPage.addContact));
            try {
                Assert.assertTrue(contactListPage.addContact.isDisplayed());
                ExtentReportManager.log(Status.PASS, "Contact " + (i + 1) + " added successfully");
                System.out.println("Contact " + (i+1) + " added with random data");
            } catch (AssertionError e) {
                ExtentReportManager.log(Status.FAIL, "Failed to add contact " + (i + 1));
                System.out.println("Failed to add contact " + (i+1));
                throw e;
            }
        }

        // ✦ Verify total contact count
        int rowCount = contactListPage.dataCount.size();
        try {
            Assert.assertEquals(rowCount, 5);
            ExtentReportManager.log(Status.PASS, "Total 5 contacts displayed");
            System.out.println("Total 5 contacts displayed");
        } catch (AssertionError e) {
            ExtentReportManager.log(Status.FAIL, "Contact count mismatch , Found: " + rowCount);
            System.out.println("Contact count mismatch. Found: " + rowCount);
            throw e;
        }
    }
}