package TestNG_pom_MorningClass.Test.Day01;

import org.testng.annotations.Test;
import TestNG_pom_MorningClass.pages.Day01.CLContactListPage;
import TestNG_pom_MorningClass.pages.Day01.CLHomePage;
import utilities.ConfigReader;
import utilities.Driver;

public class C03_PageFactory {
    @Test
    void pageFactoryTest() {

        CLHomePage homePage = new CLHomePage();
        CLContactListPage contactListPage = new CLContactListPage();

        Driver.getDriver().get(ConfigReader.getProperty("cl_url"));

        homePage.email.sendKeys(ConfigReader.getProperty("cl_email"));

        homePage.password.sendKeys(ConfigReader.getProperty("cl_password"));

        homePage.submit.click();

        assert contactListPage.logout.isDisplayed();

        Driver.closeDriver();

    }
}
