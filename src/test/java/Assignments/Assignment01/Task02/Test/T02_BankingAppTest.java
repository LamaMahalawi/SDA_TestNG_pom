package Assignments.Assignment01.Task02.Test;


import org.testng.Assert;
import org.testng.annotations.*;
import pages.*;
import utilities.Driver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import Assignments.Assignment01.Task02.pages.CustomerLoginPage;
import Assignments.Assignment01.Task02.pages.AccountManagementPage;
import Assignments.Assignment01.Task02.pages.CustomerManagementPage;
import Assignments.Assignment01.Task02.pages.TransactionPage;
import Assignments.Assignment01.Task02.pages.ManagerLoginPage;

public class T02_BankingAppTest {

    @Test
    public void bankingAppTest() throws InterruptedException {
        ManagerLoginPage managerPage = new ManagerLoginPage();
        CustomerManagementPage customerPage = new CustomerManagementPage();
        AccountManagementPage accountPage = new AccountManagementPage();
        CustomerLoginPage customerLoginPage = new CustomerLoginPage();
        TransactionPage transactionPage = new TransactionPage();

        Driver.getDriver().get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");

        // Manager login
        managerPage.managerLoginButton.click();

        // Add 5 customers
        for (int i = 1; i <= 5; i++) {
            managerPage.addCustomerButton.click();
            customerPage.firstName.sendKeys("Test" + i);
            customerPage.lastName.sendKeys("User" + i);
            customerPage.postCode.sendKeys("1000" + i);
            customerPage.addCustomerSubmit.click();

            try {
                Alert alert = Driver.getDriver().switchTo().alert();
                Assert.assertTrue(alert.getText().contains("Customer added successfully"));
                alert.accept();
            } catch (Exception e) {
                System.out.println("No alert appeared.");
            }
            Thread.sleep(1000);
        }

        // Back to Home
        managerPage.homeButton.click();

        // Login as Customer
        customerLoginPage.customerLoginButton.click();
        new Select(customerLoginPage.customerDropdown).selectByIndex(1); // First customer
        customerLoginPage.loginButton.click();

        // Deposit 100 USD
        transactionPage.depositTab.click();
        transactionPage.amountInput.sendKeys("100");
        transactionPage.depositButton.click();
        Assert.assertTrue(transactionPage.message.getText().contains("Deposit Successful"));

        // Withdraw 100 USD
        transactionPage.withdrawTab.click();
        transactionPage.amountInput.sendKeys("100");
        transactionPage.withdrawButton.click();
        Assert.assertTrue(transactionPage.message.getText().contains("Transaction successful"));

        // Back to Home
        customerLoginPage.homeButton.click();

        // Manager deletes customers
        managerPage.managerLoginButton.click();
        managerPage.customersButton.click();

        for (int i = 0; i < 5; i++) {
            Driver.getDriver().findElement(org.openqa.selenium.By.xpath("//button[text()='Delete']")).click();
            Thread.sleep(500);
        }

        Driver.closeDriver();
    }
}