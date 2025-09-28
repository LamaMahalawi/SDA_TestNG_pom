package Assignments.Assignment01.Task02.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class ManagerLoginPage {
    public ManagerLoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//button[contains(text(),'Bank Manager Login')]")
    public WebElement managerLoginBtn;

    @FindBy(xpath = "//button[contains(text(),'Add Customer')]")
    public WebElement addCustomerBtn;

    @FindBy(xpath = "//button[contains(text(),'Open Account')]")
    public WebElement openAccountBtn;

    @FindBy(xpath = "//button[contains(text(),'Customers')]")
    public WebElement customersBtn;

    @FindBy(xpath = "//button[contains(text(),'Home')]")
    public WebElement homeBtn;
}