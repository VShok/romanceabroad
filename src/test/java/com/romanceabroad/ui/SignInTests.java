package com.romanceabroad.ui;

import org.testng.Assert;
import org.testng.annotations.Test;
public class SignInTests extends BaseUI {

    public static final boolean testCase5 = true;
    public static final boolean testCase20 = true;


    @Test(dataProvider = "SignIn",enabled = testCase5, groups = {"user", "admin"}, dataProviderClass = DataProviders.class)
    public void testSignInFillInLoginPassword (String email, String password) {

        mainPage.clickSignInLink();

        signInPage.fillInEmailAndPassword(email, password);

        signInPage.getCurrentTitle();

        Assert.assertEquals(Data.expectedLogInTitle,signInPage.getCurrentTitle());

    }

    @Test(dataProvider = "SignInNeg", enabled = testCase20, groups = {"user", "groups"}, dataProviderClass = DataProviders.class)
    public void testSignInNeg(String email, String password) {
        mainPage.clickSignInLink();
        signInPage.fillInEmailAndPassword(email, password);
        signInPage.getCurrentTitle();
        Assert.assertEquals(Data.expectedLogInTitle,signInPage.getCurrentTitle());
    }
}
