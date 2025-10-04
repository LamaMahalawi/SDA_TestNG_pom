package Assignments.Assignment05.UserStory7.Page;

import Assignments.Assignment05.UserStory7.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class RegistrationPage extends BasePage {
    public RegistrationPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "ssn")
    public WebElement ssn;

    @FindBy(id = "firstName")
    public WebElement firstName;

    @FindBy(id = "lastName")
    public WebElement lastName;

    @FindBy(xpath = "//*[@id=\"registrationForm\"]/div[4]/div/label[2]")
    public WebElement genderFemale;

    @FindBy(xpath = "//*[@id=\"job\"]/option[3]")
    public WebElement job;

    @FindBy(id = "cv")
    public WebElement cv;

    @FindBy(id = "username")
    public WebElement username;

    @FindBy(id = "email")
    public WebElement email;

    @FindBy(id = "password")
    public WebElement password;

    @FindBy(xpath = "//*[@id=\"registrationForm\"]/button")
    public WebElement registerBtn;


    public RegistrationPage fillAllFields(String passwordValue) {
        safeSendKeys(ssn, "123-45-6789");
        safeSendKeys(firstName, "Lama");
        safeSendKeys(lastName, "Mahalawi");
        safeClick(genderFemale);
        safeClick(job);
        safeSendKeys(cv, "C:\\Users\\Lama-\\IdeaProjects\\SDA_TestNG_pom\\src\\test\\java\\Assignments\\Assignment05\\UserStory7\\User Story 7.pdf");
        safeSendKeys(username, "johndoe");
        safeSendKeys(email, "Lama@example.com");
        safeSendKeys(password, passwordValue);
        return this; // (Fluent POM)
    }

    public void clickRegister() {
        safeClick(registerBtn);
    }
}