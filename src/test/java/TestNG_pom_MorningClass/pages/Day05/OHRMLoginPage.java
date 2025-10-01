package TestNG_pom_MorningClass.pages.Day05;

import org.openqa.selenium.By;
import utilities.Driver;
import static org.testng.Assert.assertTrue;

public class OHRMLoginPage {

    private By username = By.xpath("//input[@name='username']");
    private By password = By.xpath("//input[@name='password']");
    private By loginButton = By.xpath("//button[@type='submit']");
    private By errorForUsername = By.xpath("//div[@class='oxd-form-row' and contains(., 'Username')]//span");
    private By errorForPassword = By.xpath("//div[@class='oxd-form-row' and contains(., 'Password')]//span");
    private By invalidCredentialsError = By.xpath("//p[.='Invalid credentials']");

    public OHRMLoginPage enterUsername(String username) {
        Driver.getDriver().findElement(this.username).sendKeys(username);
        return this;
    }

    public OHRMLoginPage enterPassword(String password) {
        Driver.getDriver().findElement(this.password).sendKeys(password);
        return this;
    }

    public OHRMDashboardPage clickLogin() {
        Driver.getDriver().findElement(loginButton).click();
        return new OHRMDashboardPage();
    }

    public OHRMLoginPage assertEmptyUsername() {
        assertTrue(Driver.getDriver().findElement(errorForUsername).isDisplayed());
        return this;
    }

    public OHRMLoginPage assertEmptyPassword() {
        assertTrue(Driver.getDriver().findElement(errorForPassword).isDisplayed());
        return this;
    }

    public OHRMLoginPage assertInvalidCredentials() {
        assertTrue(Driver.getDriver().findElement(invalidCredentialsError).isDisplayed());
        return this;
    }
}
