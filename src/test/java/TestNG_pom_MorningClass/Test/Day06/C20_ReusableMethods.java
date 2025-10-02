package TestNG_pom_MorningClass.Test.Day06;

import TestNG_pom_MorningClass.pages.Day01.CLHomePage;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

public class C20_ReusableMethods {

    @Test
    void pageFactoryTest() {
        CLHomePage homePage = new CLHomePage();
        Driver.getDriver().get(ConfigReader.getProperty("cl_url"));
        homePage.email.sendKeys("xyz");
        homePage.password.sendKeys(ConfigReader.getProperty("cl_password"));
        homePage.submit.click();
        System.out.println("Error: " + homePage.getErrorText());//This one does not use wait method.
        System.out.println("Error: " + homePage.getErrorTextBy());//This one uses wait method.
        Driver.closeDriver();
    }

}

