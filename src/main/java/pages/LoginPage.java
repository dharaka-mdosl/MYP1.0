package pages;

import helpers.WaitHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver=driver;
    }
    
    @FindBy(how= How.ID,using="email")
    @CacheLookup
    WebElement usernameTxt;
    @FindBy(how=How.ID,using="password")
    @CacheLookup
    WebElement password;
    @FindBy(how=How.ID,using="btn-login")
    @CacheLookup
    WebElement login;

    public void login(String userName, String password) {
      //  WaitHelper.waitTillVisible((By) driver.findElement(By.id(usernameTxt.toString())));
        usernameTxt.sendKeys(userName);
            this.password.sendKeys(password);
            login.click();

    }
}

