package Assignments.Assignment01.Task02.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class CustomerManagementPage {
    public CustomerManagementPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//input[@placeholder='First Name']")
    public WebElement firstName;

    @FindBy(xpath = "//input[@placeholder='Last Name']")
    public WebElement lastName;

    @FindBy(xpath = "//input[@placeholder='Post Code']")
    public WebElement postCode;

    @FindBy(xpath = "//button[text()='Add Customer']")
    public WebElement addCustomerSubmitBtn;

    @FindBy(xpath = "//table/tbody/tr")
    public List<WebElement> customerRows;

    @FindBy(xpath = "//button[text()='Delete']")
    public List<WebElement> deleteButtons;

    // addCustomer
    public void addCustomer(String fName, String lName, String post){
        firstName.sendKeys(fName);
        lastName.sendKeys(lName);
        postCode.sendKeys(post);
        addCustomerSubmitBtn.click();
    }
}