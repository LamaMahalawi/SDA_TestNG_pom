package Assignments.Assignment01.Task01.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class P01_LoginPage {
    public P01_LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "firstName")
    public WebElement firstName;

    @FindBy(id = "lastName")
    public WebElement lastName;

    @FindBy(id = "email")
    public WebElement email;

    @FindBy(id = "password")
    public WebElement password;

    @FindBy(id = "submit")
    public WebElement submit;

    @FindBy(id = "signup")
    public WebElement signupBtn;

    @FindBy(id = "login")
    public WebElement loginBtn;

    // Actions
    public void register(String fname, String lname, String mail, String pass){
        firstName.sendKeys(fname);
        lastName.sendKeys(lname);
        email.sendKeys(mail);
        password.sendKeys(pass);
        submit.click();
    }

    public void login(String mail, String pass){
        email.sendKeys(mail);
        password.sendKeys(pass);
        submit.click();
    }
}

