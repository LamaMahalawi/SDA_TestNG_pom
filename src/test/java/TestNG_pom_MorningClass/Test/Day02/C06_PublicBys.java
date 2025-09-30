package TestNG_pom_MorningClass.Test.Day02;


import org.testng.annotations.Test;
import TestNG_pom_MorningClass.pages.Day02.SLLoginPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C06_PublicBys {

    @Test
    void publicBysTest() {

        SLLoginPage loginPage = new SLLoginPage();

        Driver.getDriver().get(ConfigReader.getProperty("sd_url"));

        //This is not the recommended way:
//        Driver.getDriver().findElement(loginPage.username).sendKeys(ConfigReader.getProperty("sd_username"));
//        Driver.getDriver().findElement(loginPage.password).sendKeys(ConfigReader.getProperty("sd_password"));
//        Driver.getDriver().findElement(loginPage.loginButton).click();

    }

}
