package pages;

import helpers.WaitHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SystemManagerPage {

    WebDriver driver;

    public SystemManagerPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(how= How.XPATH,using="//div[@class='header_aa']")
    @CacheLookup
    WebElement expandMenuButton;

    @FindBy(how= How.XPATH,using="//span[text()='User Management']")
    @CacheLookup
    WebElement expandUserManagementButton;

    @FindBy(how= How.LINK_TEXT,using="Create and Update")
    @CacheLookup
    WebElement createAndUpdateUserManagementButton;

    public void expandLeftMenu() {
       expandMenuButton.click();
    }

    public void expandUserManagement() {
        expandUserManagementButton.click();
    }

    public void clickCreateAndUpdateUserManagement() {
        createAndUpdateUserManagementButton.click();
    }
}
