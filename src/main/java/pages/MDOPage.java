package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MDOPage {
    WebDriver driver;

    public MDOPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(how= How.XPATH,using="//h2[text()='MYP']")
    @CacheLookup
    WebElement myPButton;

    public void navigateToMyP() {
        myPButton.click();

    }
}
