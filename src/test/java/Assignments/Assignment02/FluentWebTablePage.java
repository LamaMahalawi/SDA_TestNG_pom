package Assignments.Assignment02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class FluentWebTablePage {
    private WebDriver driver;


    private By nameInput = By.id("nameInput");
    private By ageInput = By.id("ageInput");
    private By countrySelect = By.xpath("//*[@id=\"countrySelect\"]");
    private By addButton = By.xpath("/html/body/div/button");
    private By tableRows = By.xpath("//*[@id=\"tableBody\"]");

    // Constructor
    public FluentWebTablePage(WebDriver driver) {
        this.driver = driver;
    }

    // Enter Name
    public FluentWebTablePage enterName(String name) {
        driver.findElement(nameInput).sendKeys(name);
        return this;
    }

    // Enter Age
    public FluentWebTablePage enterAge(String age) {
        driver.findElement(ageInput).sendKeys(age);
        return this;
    }

    // Select Country
    public FluentWebTablePage selectCountry(String country) {
        WebElement select = driver.findElement(countrySelect);
        select.click();
        List<WebElement> options = select.findElements(By.tagName("option"));
        for (WebElement option : options) {
            if (option.getText().equals(country)) {
                option.click();
                break;
            }
        }
        return this;
    }

    // Click Add Record
    public FluentWebTablePage clickAddRecord() {
        driver.findElement(addButton).click();
        return this;
    }

    // Validate
    public FluentWebTablePage validateRow(String name, String age, String country) {
        List<WebElement> rows = driver.findElements(tableRows);
        int lastIndex = rows.size() - 1;
        List<WebElement> cols = rows.get(lastIndex).findElements(By.tagName("td"));

        if (cols.get(0).getText().equals(name) &&
                cols.get(1).getText().equals(age) &&
                cols.get(2).getText().equals(country)) {
            System.out.println("Record validated: " + name + ", " + age + ", " + country);
        } else {
            System.out.println("Validation for: " + name + ", " + age + ", " + country);
        }
        return this;
    }

}