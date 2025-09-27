package Assignments.Assignment01.Task01.Pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;
import java.util.List;

public class P02_ContactListPage {
    public P02_ContactListPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "logout")
    public WebElement logout;

    @FindBy(id = "add-contact")
    public WebElement addContactBtn;

    @FindBy(css = "tr.contactTableBodyRow")
    public List<WebElement> contacts;
}