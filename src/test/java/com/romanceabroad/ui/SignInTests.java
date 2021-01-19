package com.romanceabroad.ui;
import com.automation.remarks.testng.VideoListener;
import com.automation.remarks.video.annotations.Video;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.Assert;
import org.testng.annotations.Test;
public class SignInTests extends BaseUI {

    public static final boolean testCase5 = true;


    @Test(dataProvider = "SignIn",enabled = testCase5, groups = {"user", "admin"}, dataProviderClass = DataProviders.class)
    public void testSignInFillInLoginPassword (String email, String password, Boolean condition) {

        mainPage.clickSignInLink();

        signInPage.fillInEmailAndPassword(email, password);

        signInPage.getCurrentTitle();

        Assert.assertEquals(Data.expectedLogInTitle,signInPage.getCurrentTitle());

    }
    @Test(dataProvider = "NewRequirementsForPassword", dataProviderClass = DataProviders.class, groups = {"user", "groups"})
    public void password(String password, Boolean requirement) {
        mainPage.clickSignInLink();
        signInPage.fillInSignInForm(password);

        if(!requirement) {
            Assert.assertTrue(driver.findElement(Locators.ALERT_WRONG_PASSWORD).isDisplayed());
        }

    }
}
