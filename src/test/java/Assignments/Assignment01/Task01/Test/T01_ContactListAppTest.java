package Assignments.Assignment01.Task01.Test;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import Assignments.Assignment01.Task01.Pages.P01_LoginPage;
import Assignments.Assignment01.Task01.Pages.P02_ContactListPage;
import Assignments.Assignment01.Task01.Pages.P03_AddContactPage;
import utilities.Driver;

import java.time.Duration;
import java.util.UUID;

public class T01_ContactListAppTest {

    @Test
    void contactListAppTest() {

        //1. Navigate to the application
        Driver.getDriver().get("https://thinking-tester-contact-list.herokuapp.com/");

        P01_LoginPage loginPage = new P01_LoginPage();
        P02_ContactListPage contactListPage = new P02_ContactListPage();
        P03_AddContactPage addContactPage = new P03_AddContactPage();

        // 2. Create a new user account
        loginPage.signupBtn.click();
        String uniqueEmail = "test" + UUID.randomUUID() + "@mail.com"; // ايميل فريد
        loginPage.register("Test", "User", uniqueEmail, "password123");

        // - Verify registration success
        Assert.assertTrue(contactListPage.logout.isDisplayed());

       // 3. Login with the created user
        contactListPage.logout.click();
        loginPage.login(uniqueEmail, "password123");

        // Verify login success
        Assert.assertTrue(contactListPage.logout.isDisplayed());



        // 4. Add 5 different contacts
        for (int i = 1; i <= 5; i++) {
            contactListPage.addContactBtn.click();

///<It takes a little time to load between adding each contact>///

            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));
            wait.until(ExpectedConditions.visibilityOf(addContactPage.submit));

            addContactPage = new P03_AddContactPage();

            addContactPage.addContact(
                    "First Name" + i,
                    "Last Name" + i,
                    "2000-02-0" + i ,
                    "FirstName" + i + "@mail.com",
                    "050000000" + i,
                    "street1" + i,
                    "Street2" + i,
                    "City" + i,
                    "State" + i,
                    "123" + i,
                    "Country" + i
            );
            System.out.println("Add Contact '" + i + "' Successfully");
            wait.until(ExpectedConditions.invisibilityOf(addContactPage.submit));
        }


        // 5. Assert that all contacts are properly added and displayed
        Assert.assertEquals(contactListPage.contacts.size(), 5);
        System.out.println("All contacts are added Successfully");

        Driver.closeDriver();
    }
}