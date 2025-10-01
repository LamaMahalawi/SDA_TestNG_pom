package Assignments.Assignment01.Task02.Test;

import Assignments.Assignment01.Task02.pages.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class T01_BankingAppTest {

    @Test
    void bankingAppTest() {
        Driver.getDriver().get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");

        ManagerLoginPage managerPage = new ManagerLoginPage();
        CustomerManagementPage customerPage = new CustomerManagementPage();
        AccountManagementPage accountPage = new AccountManagementPage();
        CustomerLoginPage customerLoginPage = new CustomerLoginPage();
        TransactionPage transactionPage = new TransactionPage();

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));

        // 1. Open 5 new customer accounts
        managerPage.managerLoginBtn.click();
        managerPage.addCustomerBtn.click();

        List<String> customerNames = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            String fName = "First" + i;
            String lName = "Last" + i;
            String fullName = fName + " " + lName;

            customerNames.add(fullName);
            customerPage.addCustomer(fName, lName, "12345");

            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = Driver.getDriver().switchTo().alert();
            System.out.println(alert.getText());
            alert.accept();
        }

        // -Open account for each customer (Dollar only)
        managerPage.openAccountBtn.click();
        for (String name : customerNames) {
            accountPage.openAccount(name, "Dollar");
            wait.until(ExpectedConditions.alertIsPresent());
            Driver.getDriver().switchTo().alert().accept();
        }

        // 2. Deposit 100 USD to each account
        Driver.getDriver().navigate().to("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
        for (String name : customerNames) {
            customerLoginPage.customerLoginBtn.click();
            customerLoginPage.loginAsCustomer(name);
            transactionPage.deposit(100);

            Assert.assertEquals(transactionPage.balance.getText(), "100");
            customerLoginPage.logoutBtn.click();
            managerPage.homeBtn.click();

            System.out.println("Deposit 100 USD for: " + name );
        }

        // 3. Withdraw 100 USD from any one account
        Random rand = new Random();
        String randomCustomer = customerNames.get(rand.nextInt(customerNames.size()));
        System.out.println("Selected customer for withdrawal: " + randomCustomer);

        customerLoginPage.customerLoginBtn.click();
        customerLoginPage.loginAsCustomer(randomCustomer);
        transactionPage.withdraw(100);

        String currentBalance = transactionPage.balance.getText();
        Assert.assertEquals(currentBalance, "0", "Balance should be 0 after withdrawal");

        System.out.println("Withdrawal successful for: " + randomCustomer);
        customerLoginPage.logoutBtn.click();



        // 4. Delete all created accounts
        Driver.getDriver().navigate().to("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
        managerPage.managerLoginBtn.click();
        managerPage.customersBtn.click();

        while (!customerPage.deleteButtons.isEmpty()) {
            customerPage.deleteButtons.get(0).click();
        }
        System.out.println("Delete all created accounts successfully");

        // 5. Verify account operations
        Assert.assertEquals(customerPage.customerRows.size(), 0);

        Driver.closeDriver();
    }
}