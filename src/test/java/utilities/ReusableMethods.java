package utilities;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class ReusableMethods {
    private static final int DEFAULT_WAIT = 10; // default timeout in seconds

    // Wait until element is visible
    public static WebElement waitForVisibility(By element, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public static WebElement waitForVisibility(By element) {
        return waitForVisibility(element, DEFAULT_WAIT);
    }

    // Wait until element is clickable
    public static WebElement waitForClickability(By element, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static WebElement waitForClickability(By element) {
        return waitForClickability(element, DEFAULT_WAIT);
    }

    // Click with wait
    public static void clickWithWait(By element, int timeout) {
        waitForClickability(element, timeout).click();
    }

    public static void clickWithWait(By element) {
        waitForClickability(element, DEFAULT_WAIT).click();
    }

    // SendKeys with clear + wait
    public static void sendKeysWithWait(By element, String text, int timeout) {
        WebElement el = waitForVisibility(element, timeout);
        el.clear();
        el.sendKeys(text);
    }

    // JavaScript Click
    public static void jsClick(By element) {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].click();", Driver.getDriver().findElement(element));
    }

    // Scroll to element
    public static void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    // Wait for page load
    public static void waitForPageToLoad(long timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeout));
        wait.until(webDriver -> ((JavascriptExecutor) webDriver)
                .executeScript("return document.readyState").equals("complete"));
    }

    // Take screenshot (returns Base64 string)
    public static String takeScreenshot() {
        TakesScreenshot ts = (TakesScreenshot) Driver.getDriver();
        return ts.getScreenshotAs(OutputType.BASE64);
    }

    // Hard wait (not recommended but sometimes needed)
    public static void sleep(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
