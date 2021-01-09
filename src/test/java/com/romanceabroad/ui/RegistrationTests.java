package com.romanceabroad.ui;
import com.automation.remarks.testng.VideoListener;
import com.automation.remarks.video.annotations.Video;
import org.testng.annotations.Listeners;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

@Listeners(VideoListener.class)


public class RegistrationTests extends BaseUI {

    public static final boolean testCase1 = false;
    public static final boolean testCase18 = true;
    @Video(name="Registration test")
   @Test(dataProvider = "Registration", enabled = testCase1, groups = {"user", "admin"}, dataProviderClass = DataProviders.class)
    public void testFillInformationRegistrationPage(String email, String password, String day, String month,
                                                    String year, String phone, String city, String location) {

        Reports.log("Click Join button");
        System.out.println(email);
        mainPage.clickRegistrationButton();
        mainPage.fillInEmailAndPassword(email, password);
        mainPage.fillInFullInformation(mainPage.generateNewNumber(Data.username, 5), day, month, year, phone, city, location);
        WebElement checkbox = driver.findElement(Locators.CHECKBOX_CONFIRMATION);
        if (!checkbox.isSelected()) {
            checkbox.click();
            System.out.println(Data.checkbox);
        }
    }

    @Test(dataProvider = "Registration2", enabled = testCase18, groups = {"user", "admin"}, dataProviderClass = DataProviders.class)
    public void testFillInformationRegistrationPage(String email,String username,boolean requirement) {
        System.out.println(email);
        mainPage.clickRegistrationButton();
        mainPage.fillInEmailAndPassword(email, Data.password);
        if(!requirement) {
            Reports.log("Error message is not displayed");
            Assert.assertTrue(driver.findElement(Locators.TOOLTIP_ERROR).isDisplayed());
        } else {
            mainPage.clickNextButton();
            mainPage.fillInFullInformation(username, Data.day, Data.month, Data.year, Data.phone, Data.city, Data.location);
        }
    }
}
