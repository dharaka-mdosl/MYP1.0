package pages.user;

import entities.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class ViewUsersPage {
    WebDriver driver;

    public ViewUsersPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(how= How.LINK_TEXT,using="View")
    @CacheLookup
    WebElement viewUsersButton;

    @FindBy(how= How.XPATH,using="(//span[@role='button'])[2]")
    @CacheLookup
    WebElement searchByUserNameButton;

    @FindBy(how= How.XPATH,using="//input[@placeholder='Search']")
    @CacheLookup
    WebElement searchByUserNameTextbox;

    @FindBy(how= How.XPATH,using="(//button[@type='button'])[2]")
    @CacheLookup
    WebElement search;

    @FindBy(how= How.XPATH,using="//td[@class='ant-table-cell']")
    @CacheLookup
    List<WebElement> row1AllRecords;

    public void clickViewUsers(){
        viewUsersButton.click();
    }

    public void searchByCreatedUser(User user){
        searchByUserNameButton.click();
        searchByUserNameTextbox.sendKeys(user.getUserName());
        search.click();
    }

    public Boolean verifyRecordsInUserTable(String key){
        boolean isExist = row1AllRecords.stream().anyMatch(element -> key.contains(element.getText()));
        return  isExist;
    }

}
