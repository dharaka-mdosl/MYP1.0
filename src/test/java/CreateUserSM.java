import entities.User;
import helpers.LoginHelper;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SystemManagerPage;
import pages.user.UserCreateAndUpdatePage;
import pages.user.ViewUsersPage;

import java.sql.Timestamp;
import java.util.Date;

public class CreateUserSM extends LoginHelper {
    public CreateUserSM(){
    }

    User user;

    @Test
    public void test() throws InterruptedException {
            System.out.println("Navigating");
            driver.get("https://gen2uatsm.mydigitaloffice.com");

            LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
            loginPage.login("dharaka@mydigitaloffice.ca", "123456789");
            SystemManagerPage systemManagerPage = PageFactory.initElements(driver, SystemManagerPage.class);
            systemManagerPage.expandLeftMenu();
        systemManagerPage.expandUserManagement();
        systemManagerPage.clickCreateAndUpdateUserManagement();
        UserCreateAndUpdatePage userCreateAndUpdatePage = PageFactory.initElements(driver, UserCreateAndUpdatePage.class);
        user = new User(generateUserTimeStamp(),"first"+" "+"last","","tnh12","IT Person","MYP - Admin","1qaz2wsx","Free User");
        try {
            userCreateAndUpdatePage.createRandomUser(user);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ViewUsersPage viewUsersPage = PageFactory.initElements(driver, ViewUsersPage.class);
        viewUsersPage.clickViewUsers();
        viewUsersPage.searchByCreatedUser(user);
       Assert.assertTrue(viewUsersPage.verifyRecordsInUserTable(user.getFullName()));
        Assert.assertTrue(viewUsersPage.verifyRecordsInUserTable(user.getUserName()));
        Assert.assertTrue(viewUsersPage.verifyRecordsInUserTable(user.getHotelCode()));
        Assert.assertTrue(viewUsersPage.verifyRecordsInUserTable(user.getMainRole()));
        Assert.assertTrue(viewUsersPage.verifyRecordsInUserTable(user.getRole()));
        Assert.assertTrue(viewUsersPage.verifyRecordsInUserTable(user.getMyPRole()));
        Assert.assertTrue(viewUsersPage.verifyRecordsInUserTable(user.getsSOPassword()));

    }

    public String generateUserTimeStamp(){
        Date date = new Date();
        Timestamp ts=new Timestamp(date.getTime());
        String timestamp[] = ts.toString().split(" ");
        return "testuser"+timestamp[0]+timestamp[1];
    }
}
