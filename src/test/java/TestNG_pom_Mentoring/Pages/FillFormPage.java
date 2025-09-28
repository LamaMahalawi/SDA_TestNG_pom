package TestNG_pom_Mentoring.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import utilities.Driver;

public class FillFormPage {
    By nameField = By.id("name");
    By ageField = By.id("age");
    By departmentSelect = By.id("options");
    By codingInterest = By.xpath("//input[@value='coding']");
    By gender = By.xpath("//input[@value='male']");
    By generatePasscode = By.xpath("//button[@type='button']");

    public FillFormPage fillName(String name) {
        Driver.getDriver().findElement(nameField).sendKeys(name);
        return this;
    }

    public FillFormPage fillAge(String age) {
        Driver.getDriver().findElement(ageField).sendKeys(age);
        return this;
    }

    public FillFormPage fillOptions(String optionsValue) {
        Select depOpt = new Select(Driver.getDriver().findElement(departmentSelect));
        depOpt.selectByValue(optionsValue);
        return this;
    }

    public FillFormPage fillInterest() {
        Driver.getDriver().findElement(codingInterest).click();
        return this;
    }

    public FillFormPage fillGender() {
        Driver.getDriver().findElement(gender).click();
        return this;
    }

    public FillFormPage formSubmit() {
        Driver.getDriver().findElement(generatePasscode).click();
        return this;
    }

    public String getAlertMessage() {
        String text= Driver.getDriver().switchTo().alert().getText();
        Driver.getDriver().switchTo().alert().accept();
        return text;
    }

    public FillFormPage verifyPasscode() {
        Assert.assertTrue(Driver.getDriver().switchTo().alert().getText().contains("Your passcode is:"));
        return this;
    }
}
