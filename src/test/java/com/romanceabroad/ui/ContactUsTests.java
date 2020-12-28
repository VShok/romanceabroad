package com.romanceabroad.ui;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.automation.remarks.testng.VideoListener;

import com.automation.remarks.video.annotations.Video;

import org.testng.annotations.Listeners;

public class ContactUsTests extends BaseUI {
    String currentUrlSearch;
    public static final boolean testCase17 = true;
    @Test(enabled = testCase17, groups = {"users", "admin"})
    public void testFillInContactUsPage() {

        mainPage.clickHowWeWorkLink();
        mainPage.clickContactUsPage();
        mainPage.javaWaitSec(3);
        currentUrlSearch = driver.getCurrentUrl();
        System.out.println(currentUrlSearch);

        Assert.assertEquals(Data.expectedContactUsUrl,currentUrlSearch);
        mainPage.selectItemDropDownRandomOption(Locators.SELECT_REASON, "Reason");
        contactUsPage.fillInContactUsInformation(Data.name, Data.email1, Data.subject, Data.message);

    }


}
