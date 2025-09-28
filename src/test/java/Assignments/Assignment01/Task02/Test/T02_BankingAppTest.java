package Assignments.Assignment01.Task02.Test;


import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utilities.Driver;
import org.testng.annotations.Test;
import Assignments.Assignment01.Task02.pages.CustomerLoginPage;
import Assignments.Assignment01.Task02.pages.AccountManagementPage;
import Assignments.Assignment01.Task02.pages.CustomerManagementPage;
import Assignments.Assignment01.Task02.pages.TransactionPage;
import Assignments.Assignment01.Task02.pages.ManagerLoginPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import java.util.List;

public class T02_BankingAppTest {

    @Test
    public void bankingAppTest() throws InterruptedException {

        Driver.getDriver().get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");

        ManagerLoginPage manager = new ManagerLoginPage();
        CustomerManagementPage customerMgmt = new CustomerManagementPage();
        AccountManagementPage accountMgmt = new AccountManagementPage();
        CustomerLoginPage customerLogin = new CustomerLoginPage();
        TransactionPage transactionPage = new TransactionPage();

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));

        // Step 1: Manager Login
        manager.managerLoginBtn.click();

        // Step 2: Add 5 customers
        for (int i = 1; i <= 5; i++) {
            manager.addCustomerBtn.click();
            customerMgmt.firstName.sendKeys("User" + i);
            customerMgmt.lastName.sendKeys("TestNG_pom_MorningClass/Test" + i);
            customerMgmt.postCode.sendKeys("12345");
            customerMgmt.submitAddCustomer.click();

            WebElement successMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//span[@class='error ng-binding']")));
            Assert.assertTrue(successMsg.getText().contains("Customer added successfully"));
            System.out.println("Added: " + successMsg.getText());
        }

        // Step 3: Open accounts for 5 customers
        manager.openAccountBtn.click();
        for (int i = 1; i <= 5; i++) {
            accountMgmt.openAccount("User" + i + "TestNG_pom_MorningClass/Test" + i, "Dollar");

            WebElement accountMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//span[@class='error ng-binding']")));
            Assert.assertTrue(accountMsg.getText().contains("Account created successfully"));
            System.out.println("Account for User" + i + ": " + accountMsg.getText());
        }

        // Step 4: Deposit 100 USD for each customer & Withdraw 100 from customer 3
        manager.homeBtn.click();
        for (int i = 1; i <= 5; i++) {
            customerLogin.customerLoginBtn.click();
            customerLogin.selectCustomer("User" + i + "TestNG_pom_MorningClass/Test" + i);
            customerLogin.loginBtn.click();

            transactionPage.depositTab.click();
            transactionPage.amountInput.sendKeys("100");
            transactionPage.depositBtn.click();

            WebElement depositMsg = wait.until(ExpectedConditions.visibilityOf(transactionPage.message));
            Assert.assertTrue(depositMsg.getText().contains("Deposit Successful"));
            System.out.println("Deposit for User" + i + ": " + depositMsg.getText());

            // Withdraw 100 from 3rd customer
            if (i == 3) {
                transactionPage.withdrawTab.click();
                transactionPage.amountInput.sendKeys("100");
                transactionPage.withdrawBtn.click();

                WebElement withdrawMsg = wait.until(ExpectedConditions.visibilityOf(transactionPage.message));
                Assert.assertTrue(withdrawMsg.getText().contains("Transaction successful"));
                System.out.println("Withdraw for User3: " + withdrawMsg.getText());
            }

            transactionPage.logoutBtn.click();
            customerLogin.homeBtn.click();
        }

        // Step 5: Delete all customers
        manager.managerLoginBtn.click();
        manager.customersBtn.click();

        List<WebElement> deleteButtons = Driver.getDriver().findElements(By.xpath("//button[text()='Delete']"));
        for (WebElement btn : deleteButtons) {
            btn.click();
            Thread.sleep(500);
        }

        System.out.println("All customers deleted successfully!");

        Driver.closeDriver();
    }
}