package helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static helpers.LoginHelper.driver;

public class WaitHelper {

    WaitHelper(){

    }

    public static void waitTillClickable(WebElement webElement) throws InterruptedException {
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].click()", webElement);
        WebDriverWait wait = new WebDriverWait(driver, 10);

// visible
     /*   WebElement button = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[id*='datepicker'][id*='title']")));
        button.click();

// or exist
        WebElement button = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[id*='datepicker'][id*='title']")));
        button.click();*/

    }
    public static void waitTillVisible(By by){
        WebDriverWait wait = new WebDriverWait(driver,30);
        WebElement button = wait.until(ExpectedConditions.visibilityOfElementLocated(by));

    }
}
