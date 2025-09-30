package TestNG_pom_MorningClass.Test.Day03;

import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.MyTestListener;

@Listeners(MyTestListener.class)//1st way to link test class and listener class(not recommended)

public class C13_Listeners {
    @Test
    void successTest() {
    }

    @Test
    void failedTest() throws Exception {
        throw new Exception("This is an issue!!!");
    }


    @Test
    void skippedTest() {
        throw new SkipException("Test skipped!!!");
    }

    @Test
    void assertionErrorTest() {
        assert false;
    }
}
