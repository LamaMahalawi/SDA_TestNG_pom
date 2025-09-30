package TestNG_pom_MorningClass.Test.Day02;

import org.testng.annotations.Test;
import TestNG_pom_MorningClass.pages.Day02.SLLoginPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C07_ActionsMethods {


    @Test
    void actionsMethodsTest() {
        SLLoginPage loginPage = new SLLoginPage();

        Driver.getDriver().get(ConfigReader.getProperty("sd_url"));

        loginPage.enterUsername(ConfigReader.getProperty("sd_username"));
        loginPage.enterPassword(ConfigReader.getProperty("sd_password"));
        loginPage.clickLoginButton();

        Driver.closeDriver();
    }


    @Test
    void actionsMethodsTestSingleMethod() {
        SLLoginPage loginPage = new SLLoginPage();

        Driver.getDriver().get(ConfigReader.getProperty("sd_url"));

        loginPage.login(ConfigReader.getProperty("sd_username"), ConfigReader.getProperty("sd_password"));

        Driver.closeDriver();
    }

}