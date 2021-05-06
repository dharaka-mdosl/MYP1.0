package helpers;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class BrowserFactory {

    public static WebDriver driver;

    public BrowserFactory() {

    }

    public static WebDriver getDriver() {
        if (driver == null) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-notifications");
            options.setPageLoadStrategy(PageLoadStrategy.NONE);
            options.addArguments("start-maximized");
            System.setProperty("webdriver.chrome.driver", "C:\\Softwares\\chromedriver-90");
            driver = new ChromeDriver(options);
            driver.manage().window().maximize();

            driver.manage().timeouts().implicitlyWait(150, TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(150, TimeUnit.SECONDS);
        }
        return driver;
    }

    public static WebDriver getDriver(String browserName) {
        if (driver == null) {
            if (browserName.equalsIgnoreCase("firefox")) {
                System.setProperty("webdriver.gecko.driver", "C:\\Softwares\\geckodriver\\geckodriver.exe");
                driver = new FirefoxDriver();
                driver.manage().window().maximize();
                driver.manage().deleteAllCookies();
                driver.manage().timeouts().implicitlyWait(150, TimeUnit.SECONDS);
                driver.manage().timeouts().pageLoadTimeout(150, TimeUnit.SECONDS);
            } else if (browserName.equalsIgnoreCase("chrome")) {
                System.out.println("in chrome");
                System.setProperty("webdriver.chrome.driver", "C:\\Softwares\\chromedriver-90\\chromedriver.exe");
                driver = new ChromeDriver();
                driver.manage().window().maximize();
                driver.manage().deleteAllCookies();
                driver.manage().timeouts().implicitlyWait(150, TimeUnit.SECONDS);
                driver.manage().timeouts().pageLoadTimeout(150, TimeUnit.SECONDS);
            }

        }
        return driver;

    }
}
