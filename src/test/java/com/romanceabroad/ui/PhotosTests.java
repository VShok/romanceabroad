package com.romanceabroad.ui;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.automation.remarks.testng.VideoListener;
import com.automation.remarks.video.annotations.Video;
import org.testng.annotations.Listeners;

import java.util.List;

public class PhotosTests extends BaseUI {
    public static final boolean testCase7 = true;
    public static final boolean testCase8 = true;
    public static final boolean testCase19 = true;
    String currentUrlSearch;
    String actualTitle;

    @Test(priority = 1, enabled = testCase7, groups = {"user", "admin"})
    public void testPhotosLink() {

        mainPage.clickPhotosLink();
        mainPage.javaWait(1500);
        currentUrlSearch = driver.getCurrentUrl();
        System.out.println(currentUrlSearch);

        Assert.assertEquals(Data.expectedPhotosUrl, currentUrlSearch);

    }

    @Test(priority = 2, enabled = testCase8, groups = {"user", "admin"})
    public void testClickButtonAddPhoto() {

        mainPage.clickPhotosLink();
        wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.BUTTON_ADD_PHOTOS));
        int count = mainPage.getSizeDropDownList(Locators.SELECT_PHOTOS);
        mainPage.selectItemDropDownRandomOption(Locators.SELECT_PHOTOS, "Sort By");
        System.out.println(count);
        Assert.assertTrue(driver.findElement(Locators.BUTTON_ADD_PHOTOS).isDisplayed(), Data.notDisplayed);
    }

    @Test(priority = 3, enabled = testCase19, groups = {"user", "admin"})
    public void testTabs() {
        mainPage.clickPhotosLink();
        List<WebElement> userTabs = driver.findElements(Locators.LINK_TAB_USER_PROFILE);
        actualTitle = photosPage.getAnyTitle();
        Assert.assertEquals(actualTitle, Data.expectedTitleAllPhotos);
        for (int i = 0; i < userTabs.size(); i++) {
            userTabs.get(i).click();
            actualTitle = photosPage.getAnyTitle();
            if (i == 0) {
                Assert.assertEquals(actualTitle, Data.expectedTitleGallery);
            } else if (i == 1) {
                Assert.assertEquals(actualTitle, Data.expectedTitlePhotoGallery);
            } else if (i == 2) {
                Assert.assertEquals(actualTitle, Data.expectedTitleVideoGallery);
                String textMedia = driver.findElement
                        (Locators.BLOCK_GALLERY_ALBUMS).getText();
                System.out.println(textMedia);
                if(textMedia.contains(Data.textMedia)) {
                    System.out.println("Text Media is correct");
                }
            } else if (i == 3) {
                Assert.assertEquals(actualTitle, Data.expectedTitleAlbumsGallery);
                mainPage.javaWaitSec(2);
                Assert.assertTrue(driver.findElement(Locators.TYPE_OF_ALBUMS).isDisplayed());
            }
            userTabs = driver.findElements(Locators.LINK_TAB_USER_PROFILE);
        }
    }

}
