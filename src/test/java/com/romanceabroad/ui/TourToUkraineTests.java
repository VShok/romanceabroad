package com.romanceabroad.ui;
import com.automation.remarks.testng.VideoListener;
import com.automation.remarks.video.annotations.Video;
import org.testng.annotations.Listeners;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TourToUkraineTests extends BaseUI {
    public static final boolean testCase6 = true;
    String currentUrlSearch;
    @Test(enabled = testCase6, groups = {"user", "admin"})
    public void testTourToUkraineLink() {

        mainPage.clickTourToUkraineLink();
        mainPage.javaWait(1500);
        currentUrlSearch = driver.getCurrentUrl();
        System.out.println(currentUrlSearch);

        Assert.assertEquals(Data.expectedTourUkraineUrl,currentUrlSearch);
    }


}
