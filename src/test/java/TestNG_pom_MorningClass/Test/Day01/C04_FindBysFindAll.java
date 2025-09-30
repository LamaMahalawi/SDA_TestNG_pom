package TestNG_pom_MorningClass.Test.Day01;

import org.testng.annotations.Test;
import TestNG_pom_MorningClass.pages.Day01.FindByTestPage;
import utilities.Driver;

public class C04_FindBysFindAll {

    @Test
    void findBysFindAllTest() {
        FindByTestPage testPage = new FindByTestPage();

        Driver.getDriver().get("https://testpages.eviltester.com/styled/find-by-playground-test.html");

        System.out.println(testPage.paragraph1.getText());
        System.out.println(testPage.paragraph2.getText());
        System.out.println(testPage.paragraph3.getText());

        Driver.closeDriver();

    }

}