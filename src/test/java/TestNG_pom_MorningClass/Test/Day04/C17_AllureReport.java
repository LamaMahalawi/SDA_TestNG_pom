package TestNG_pom_MorningClass.Test.Day04;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

public class C17_AllureReport {
    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Description("This is the login function.")
    void test01(){
        System.out.println("Critical Test!");
        assert false;
    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Description("This is the registration function.")
    void test02(){
        System.out.println("Blocker Test!");
    }

    @Test
    @Severity(SeverityLevel.TRIVIAL)
    @Description("This is the highlight function.")
    void test03(){
        System.out.println("Trivial Test!");
    }
}
