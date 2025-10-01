package TestNG_pom_MorningClass.pages.Day05;


import org.openqa.selenium.By;
import utilities.Driver;
import static org.testng.Assert.assertTrue;

public class OHRMDashboardPage extends OHRMLoginPage  {

    private By profileDD = By.xpath("//img[@class='oxd-userdropdown-img']");

    public OHRMDashboardPage assertLogin() {
        assertTrue(Driver.getDriver().findElement(profileDD).isDisplayed(), "Profile dropdown is not visible!");
        return this;
    }
}
