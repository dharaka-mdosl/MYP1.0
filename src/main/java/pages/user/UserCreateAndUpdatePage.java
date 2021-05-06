package pages.user;

import entities.User;
import helpers.WaitHelper;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Timestamp;
import java.util.Date;

public class UserCreateAndUpdatePage {

    WebDriver driver;

    public UserCreateAndUpdatePage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(how= How.ID,using="form_one_user_name")
    @CacheLookup
    WebElement userName;

    @FindBy(how= How.ID,using="form_one_first_name")
    @CacheLookup
    WebElement firstName;

    @FindBy(how= How.ID,using="form_one_last_name")
    @CacheLookup
    WebElement lastName;

    @FindBy(how= How.ID,using="form_one_main_role")
    @CacheLookup
    WebElement mainRole;

    @FindBy(how= How.ID,using="form_one_role")
    @CacheLookup
    WebElement role;

    @FindBy(how= How.ID,using="form_one_myp_role")
    @CacheLookup
    WebElement myPRole;

    @FindBy(how= How.ID,using="form_one_myp_user")
    @CacheLookup
    WebElement myPUser;

    @FindBy(how= How.ID,using="form_one_password")
    @CacheLookup
    WebElement password;

    @FindBy(how= How.ID,using="form_one_confirm")
    @CacheLookup
    WebElement confirmPassword;

    @FindBy(how= How.XPATH,using="(//button[@type='button'])[2]")
    @CacheLookup
    WebElement next;

    @FindBy(how= How.XPATH,using="(//button[@type='button'])[4]")
    @CacheLookup
    WebElement isInformationNext;

    @FindBy(how= How.XPATH,using="(//input[@placeholder='Search here'])[1]")
    @CacheLookup
    WebElement leftSearch;

    @FindBy(how= How.XPATH,using="(//input[@type='checkbox'])[1]")
    @CacheLookup
    WebElement leftTableCheckbox;

    @FindBy(how= How.XPATH,using="(//button[@type='button'])[5]")
    @CacheLookup
    WebElement rightArrow;

   /* @FindBy(how= How.XPATH,using="(//button[@type='submit'])[1]")
    @CacheLookup
    WebElement submit;*/

    @FindBy(how= How.CSS,using="#root > div > div.wrapper_a > div.container_a > div > div.container_ab > div > div > div.steps-content > div > div > div > div.ant-collapse-content.ant-collapse-content-active > div > form > div:nth-child(4) > div:nth-child(2) > button.ant-btn.ant-btn-primary")
    @CacheLookup
    WebElement submit;

    public void addUsername(User user) {
        this.userName.sendKeys(user.getUserName());
    }

    public void addFirstName(User user) {
        String arr[] = user.getFullName().split("\\s+");
            firstName.sendKeys(arr[0]);
    }

    public void addLastName(User user) {
        String arr[] = user.getFullName().split("\\s+");
        lastName.sendKeys(arr[1]);
    }

    public void addMainRole(User user){
        mainRole.click();
        mainRole.sendKeys(user.getMainRole());
        String webElement=String.format("//div[text()='%s']",user.getMainRole());
        driver.findElement(By.xpath(webElement)).click();

    }

    public void addRole(User user){
        role.click();
        role.sendKeys(user.getRole());
        String webElement=String.format("//div[text()='%s']",user.getRole());
        driver.findElement(By.xpath(webElement)).click();
    }


    public void addMyPRole(User user) throws InterruptedException {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", myPRole);
        Thread.sleep(500);
        myPRole.click();
        myPRole.sendKeys(user.getMyPRole());
        String webElement=String.format("//div[text()='%s']",user.getMyPRole());
        driver.findElement(By.xpath(webElement)).click();
    }
    public void selectMyP(User user)
    {
        myPUser.click();
    }

    public void setPassword(User user){
        this.password.sendKeys(user.getsSOPassword());
    }

    public void setConfirmPassword(User user){
        this.confirmPassword.sendKeys(user.getsSOPassword());
    }

    public void clickNext(){
        next.click();
    }

    public void clickIsInformationNext(){
        isInformationNext.click();
    }

    public void searchLeft(String searchkey){
        leftSearch.sendKeys(searchkey);
    }

    public void selectAllLeftCheckbox(){
        leftTableCheckbox.click();
    }

    public void clickRightArrow(){
        rightArrow.click();
    }

    public void submitUser(){
        WebDriverWait wait = new WebDriverWait(driver,60);
        wait.until(ExpectedConditions.visibilityOf(submit));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", submit);

    }

    public void createRandomUser(User user) throws InterruptedException {

        addUsername(user);
        addFirstName(user);
        addLastName(user);
        addMainRole(user);
        addRole(user);
        selectMyP(user);
        addMyPRole(user);
        setPassword(user);
        setConfirmPassword(user);
        clickNext();
        clickIsInformationNext();
        searchLeft(user.getHotelCode());
        selectAllLeftCheckbox();
        clickRightArrow();
        submitUser();

    }
}
