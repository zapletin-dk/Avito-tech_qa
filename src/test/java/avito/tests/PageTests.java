package avito.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PageTests {
    WebDriver driver;
    @BeforeTest
    public void setUp(){
        driver = DriverSingleton.getDriver();
    }
    @AfterTest
    public void tearDown(){
        DriverSingleton.closeDriver();
    }

    @Test
    public void test(){
        driver.get("https://www.avito.ru/avito-care/eco-impact");
    }
}
