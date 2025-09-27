package Assignments.Assignment01.Task01.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class P03_AddContactPage {
    public P03_AddContactPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "firstName")
    public WebElement firstName;

    @FindBy(id = "lastName")
    public WebElement lastName;

    @FindBy(id = "birthdate")
    public WebElement birthdate;

    @FindBy(id = "email")
    public WebElement Email;

    @FindBy(id = "phone")
    public WebElement phone;

    @FindBy(id = "street1")
    public WebElement street1;

    @FindBy(id = "street2")
    public WebElement street2;

    @FindBy(id = "city")
    public WebElement city;

    @FindBy(id = "stateProvince")
    public WebElement state;

    @FindBy(id = "postalCode")
    public WebElement postalCode;

    @FindBy(id = "country")
    public WebElement country;

    @FindBy(id = "submit")
    public WebElement submit;

    // Action
    public void addContact(String Firstname, String Lastname,String Birthdate,
    String email, String phoneNo, String Street1,  String Street2, String cityName,
    String stateName, String postal, String countryName ){
        firstName.sendKeys(Firstname);
        lastName.sendKeys(Lastname);
        birthdate.sendKeys(Birthdate);
        Email.sendKeys(email);
        phone.sendKeys(phoneNo);
        street1.sendKeys(Street1);
        street2.sendKeys(Street2);
        city.sendKeys(cityName);
        state.sendKeys(stateName);
        postalCode.sendKeys(postal);
        country.sendKeys(countryName);
        submit.click();

    }

}
