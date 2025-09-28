package Assignments.Assignment02;

import org.testng.annotations.*;
import Assignments.Assignment02.FluentWebTablePage;
import utilities.Driver;

public class FluentWebTableTest {
    @DataProvider(name = "tableData")
    public Object[][] tableData() {
        return new Object[][] {
                {"Lama", "23", "USA"},
                {"Osama", "24", "Canada"},
                {"Jod", "5", "UK"}
        };
    }

    @Test(dataProvider = "tableData")
    public void addRecordAndValidate(String name, String age, String country) {
        FluentWebTablePage tablePage = new FluentWebTablePage(Driver.getDriver());
        Driver.getDriver().get("https://claruswaysda.github.io/addRecordWebTable.html");

        tablePage
                .enterName(name)
                .enterAge(age)
                .selectCountry(country)
                .clickAddRecord()
                .validateRow(name, age, country);
    }
}