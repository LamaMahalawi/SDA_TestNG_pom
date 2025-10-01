package Assignments.Assignment01.Task02.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Driver;
import java.time.Duration;

public class CustomerLoginPage {
    public CustomerLoginPage(){
    PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//button[text()='Customer Login']")
    public WebElement customerLoginBtn;

    @FindBy(id = "userSelect")
    public WebElement yourNameDropdown;

    @FindBy(xpath = "//button[text()='Login']")
    public WebElement loginBtn;

    @FindBy(xpath = "//button[text()='Logout']")
    public WebElement logoutBtn;

    public void loginAsCustomer(String customerName){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(yourNameDropdown));
        Select select = new Select(yourNameDropdown);
        select.selectByVisibleText(customerName);
        loginBtn.click();
    }
}