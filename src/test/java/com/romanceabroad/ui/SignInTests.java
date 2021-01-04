package com.romanceabroad.ui;
import com.automation.remarks.testng.VideoListener;
import com.automation.remarks.video.annotations.Video;
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
}
