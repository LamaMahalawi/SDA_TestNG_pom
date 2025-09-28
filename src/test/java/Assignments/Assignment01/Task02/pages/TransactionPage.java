package Assignments.Assignment01.Task02.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class TransactionPage {
    public TransactionPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//button[contains(text(),'Deposit')]")
    public WebElement depositTab;

    @FindBy(xpath = "//input[@placeholder='amount']")
    public WebElement amountInput;

    @FindBy(xpath = "//button[text()='Deposit']")
    public WebElement depositBtn;

    @FindBy(xpath = "//button[contains(text(),'Withdrawl')]")
    public WebElement withdrawTab;

    @FindBy(xpath = "//button[text()='Withdraw']")
    public WebElement withdrawBtn;

    @FindBy(xpath = "//span[@class='error ng-binding']")
    public WebElement message;

    @FindBy(xpath = "//button[contains(text(),'Logout')]")
    public WebElement logoutBtn;
}