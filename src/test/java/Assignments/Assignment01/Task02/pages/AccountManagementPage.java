package Assignments.Assignment01.Task02.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utilities.Driver;

public class AccountManagementPage {
    public AccountManagementPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "userSelect")
    public WebElement customerDropdown;

    @FindBy(id = "currency")
    public WebElement currencyDropdown;

    @FindBy(xpath = "//button[text()='Process']")
    public WebElement processBtn;

   //openAccount
    public void openAccount(String customerName, String currency){
        Select selectCustomer = new Select(customerDropdown);
        selectCustomer.selectByVisibleText(customerName);

        Select selectCurrency = new Select(currencyDropdown);
        selectCurrency.selectByVisibleText(currency);

        processBtn.click();
    }
}