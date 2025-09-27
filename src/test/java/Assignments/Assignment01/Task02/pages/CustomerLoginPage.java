package Assignments.Assignment01.Task02.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utilities.Driver;


public class CustomerLoginPage {
    public CustomerLoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//button[contains(text(),'Customer Login')]")
    public WebElement customerLoginButton;

    @FindBy(id = "userSelect")
    public WebElement customerDropdown;

    @FindBy(xpath = "//button[contains(text(),'Login')]")
    public WebElement loginButton;

    @FindBy(xpath = "//button[contains(text(),'Home')]")
    public WebElement homeButton;
}