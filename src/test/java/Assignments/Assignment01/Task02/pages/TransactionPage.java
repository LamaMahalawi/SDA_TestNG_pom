package Assignments.Assignment01.Task02.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class TransactionPage {
    public TransactionPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//button[contains(text(),'Deposit')]")
    public WebElement depositBtn;

    @FindBy(xpath = "//button[contains(text(),'Withdrawl')]")
    public WebElement withdrawBtn;

    @FindBy(xpath = "//input[@placeholder='amount']")
    public WebElement amountInput;

    @FindBy(xpath = "//button[text()='Deposit']")
    public WebElement confirmDepositBtn;

    @FindBy(xpath = "//button[text()='Withdrawl']")
    public WebElement withdrawTab;

    @FindBy(xpath = "//strong[2]")
    public WebElement balance;

    @FindBy(xpath = "/html/body/div/div/div[2]/div/div[4]/div/form/button")
    public WebElement confirmwithdrawBtn;



    // Deposit
    public void deposit(int amount){
        depositBtn.click();
        amountInput.sendKeys(String.valueOf(amount));
        confirmDepositBtn.click();
    }

    // Withdraw
    public void withdraw(int amount){
        withdrawBtn.click();
        amountInput.sendKeys(String.valueOf(amount));
        confirmwithdrawBtn.click();
    }
}