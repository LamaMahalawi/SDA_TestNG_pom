package TestNG_pom_MorningClass.pages;

import org.openqa.selenium.By;
import org.testng.Assert;
import utilities.Driver;

import static org.testng.Assert.assertTrue;

public class SLCartPage {

    private By yourCartHeader = By.cssSelector(".header_secondary_container");
    private String productXPathInCartByName = "//div[@class='cart_item_label']//div[contains(., '%s')]";


    public SLCartPage assertCartHeader() {
        Assert.assertEquals(Driver.getDriver().findElement(yourCartHeader).getText(), "Your Cart");
        return this;
    }

    public SLCartPage assertProductInCartByName(String productName) {
        assertTrue(Driver.getDriver().findElement(By.xpath(String.format(productXPathInCartByName, productName))).isDisplayed());
        return this;
    }


}