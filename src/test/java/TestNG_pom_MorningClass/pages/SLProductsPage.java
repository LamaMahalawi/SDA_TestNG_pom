package TestNG_pom_MorningClass.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utilities.Driver;

import java.time.Duration;

public class SLProductsPage {

    private By sortDD = By.xpath("//select[@class='product_sort_container']");
    private By menu = By.cssSelector("#react-burger-menu-btn");
    private By addCartButtons = By.cssSelector(".btn_inventory ");
    private By cartButton = By.cssSelector(".shopping_cart_link ");
    private String addCartButtonByName = "//div[@class='inventory_item_description' and contains(., '%s')]//button";
    private String priceByName = "//div[@class='inventory_item_description' and contains(., '%s')]//div[@class='inventory_item_price']";

    public SLProductsPage sortProducts(String text) {
        new Select(Driver.getDriver().findElement(sortDD)).selectByVisibleText(text);
        return this;
    }

    public SLProductsPage sortProducts(int index) {
        new Select(Driver.getDriver().findElement(sortDD)).selectByIndex(index);
        return this;
    }

    public SLProductsPage assertLogin() {
        Assert.assertTrue(Driver.getDriver().findElement(menu).isDisplayed());
        return this;
    }

    public SLProductsPage addProductByIndex(int index) {
        Driver.getDriver().findElements(addCartButtons).get(index).click();
        return this;
    }

    public SLProductsPage addAllProducts() {
        Driver.getDriver().findElements(addCartButtons).forEach(WebElement::click);//Using lambda is recommended
        return this;
    }

    public SLCartPage clickOnCart() {
        Driver.getDriver().findElement(cartButton).click();
        return new SLCartPage();
    }


    public SLProductsPage addProductByName(String productName) {
        Driver.getDriver().findElement(By.xpath(String.format(addCartButtonByName, productName))).click();
        return this;
    }

    public SLProductsPage assertPriceByName(String productName, double price) {
        String strPrice = Driver.getDriver().findElement(By.xpath(String.format(priceByName, productName))).getText();
        Assert.assertEquals(Double.parseDouble(strPrice.replaceAll("[^0-9.]", "")), price);
        return this;
    }


}