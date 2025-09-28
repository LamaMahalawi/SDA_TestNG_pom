package TestNG_pom_MorningClass.Test;

import org.testng.annotations.Test;
import TestNG_pom_MorningClass.pages.SLLoginPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C09_DynamicXPath {

    @Test
    void methodChainTest() {

        SLLoginPage loginPage = new SLLoginPage();

        Driver.getDriver().get(ConfigReader.getProperty("sd_url"));

        loginPage
                .enterUsername(ConfigReader.getProperty("sd_username"))
                .enterPassword(ConfigReader.getProperty("sd_password"))
                .clickLoginButton()
                .assertLogin()

                .addProductByName("Bolt T-Shirt")
                .addProductByName("T-Shirt (Red)")
                .assertPriceByName("Bike Light", 9.99)
                .assertPriceByName("Fleece Jacket", 49.99)
                .clickOnCart()
                .assertCartHeader()
                .assertProductInCartByName("Bolt T-Shirt")
                .assertProductInCartByName("T-Shirt (Red)");

        Driver.closeDriver();
    }
}