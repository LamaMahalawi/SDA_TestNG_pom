package Assignments.Assignment01.Task02.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class ManagerLoginPage {
    public ManagerLoginPage(){
    PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//button[text()='Bank Manager Login']")
    public WebElement managerLoginBtn;

    @FindBy(xpath = "//button[@ng-class='btnClass1']")
    public WebElement addCustomerBtn;

    @FindBy(xpath = "//button[@ng-class='btnClass2']")
    public WebElement openAccountBtn;

    @FindBy(xpath = "//button[@ng-class='btnClass3']")
    public WebElement customersBtn;

    @FindBy(xpath = "/html/body/div/div/div[1]/button[1]")
    public WebElement homeBtn;
}