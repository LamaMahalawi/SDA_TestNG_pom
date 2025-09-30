package TestNG_pom_MorningClass.pages.Day02;

import org.openqa.selenium.By;
import utilities.Driver;

public class SLLoginPage {
    private By username = By.xpath("//input[@placeholder='Username']");
    private By password = By.xpath("//input[@placeholder='Password']");
    private By loginButton = By.id("login-button");

    public SLLoginPage enterUsername(String username) {
        Driver.getDriver().findElement(this.username).sendKeys(username);
        return this;
    }

    public SLLoginPage enterPassword(String password) {
        Driver.getDriver().findElement(this.password).sendKeys(password);
        return this;
    }

    public SLProductsPage clickLoginButton() {
        Driver.getDriver().findElement(loginButton).click();
        return new SLProductsPage();
    }

    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
    }
}
