package helpers;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.io.IOException;

public class LoginHelper {
    public static WebDriver driver;

    public LoginHelper(){
        BrowserFactory obj;
    }

    @BeforeSuite
    public void beforeSuite(){

    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("in @BeforeClass");
    }

    @BeforeMethod
    public void beforeMethodClass(){
        System.out.println("in @BeforeMethod");
        driver = BrowserFactory.getDriver("chrome");

    }

    @AfterMethod
    public void close()
    {
  //  this.driver.close();
    }

    @AfterClass
    public void afterClass(){

    }

    @AfterSuite
    public void afterSuite() throws IOException{
      //  driver.quit();
    }
}
