package com.romanceabroad.ui;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;
import com.automation.remarks.testng.VideoListener;
import com.automation.remarks.video.annotations.Video;
import org.testng.annotations.Listeners;

import java.util.List;


public class PrettyWomenTests extends BaseUI {

    String currentUrlSearch;
    public static final boolean testCase2 = true;
    public static final boolean testCase3 = true;
    public static final boolean testCase4 = true;
    public static final boolean testCase18 = true;
    public static final boolean testCase20 = true;
    public static final boolean testCase21 = true;
    public static final boolean testCase22 = true;

    @Test(priority = 1, enabled = testCase2, groups = {"user", "admin"})
    public void testPrettyWomenLink() {

        prettyWomenPage.clickPrettyWomenLink();

        currentUrlSearch = driver.getCurrentUrl();
        System.out.println(currentUrlSearch);

        Assert.assertEquals(Data.expectedPrettyWomenUrl,currentUrlSearch);

        prettyWomenPage.getDropDownListByIndex(Locators.FILTER_MAX_AGE,8);
    }
    @Test(priority = 3, enabled = testCase3, groups = {"user", "admin"})
    public  void testSearchButtonTestCase3() {
        prettyWomenPage.clickPrettyWomenLink();
        if(driver.findElement(Locators.TEXT_FIELD_PRETTY_WOMEN_SEARCH).isDisplayed()) {
            System.out.println(Data.clicable);
        } else {
            Assert.assertFalse(false, Data.notClicable);
        }
    }

    @Test(priority = 4, enabled = testCase4, groups = {"user", "admin"})
    public void testThirdPageTestCase4() {
        prettyWomenPage.clickPrettyWomenLink();
        mainPage.scrollToBottomOfPage();
        mainPage.javaWait(2500);
        mainPage.performClickWebElement(driver.findElement(Locators.THIRD_PAGE_PRETTY_WOMEN));
    }

    @Test( priority = 2, enabled = testCase18, groups = {"user", "admin"}, dataProvider = "PrettyWomen", dataProviderClass = DataProviders.class)
    public void searchDifferentResults(String minAge, String maxAge, String sortBy) {
        int min = Integer.parseInt(minAge);
        int max = Integer.parseInt(maxAge);
        System.out.println(min + " and " + max);


        prettyWomenPage.clickPrettyWomenLink();
        prettyWomenPage.getDropDownListByText(Locators.FILTER_MAX_AGE, maxAge );
        prettyWomenPage.getDropDownListByText(Locators.FILTER_SORT_BY, sortBy);
        prettyWomenPage.getDropDownListByText(Locators.FILTER_MIN_AGE, minAge);
        prettyWomenPage.clickSearchButton();

        List<WebElement> infoAboutUser = driver.findElements(Locators.TEXT_USER_INFO);
        for (int i = 0; i<infoAboutUser.size(); i++) {
            if (i % 2==0) {
                WebElement text = infoAboutUser.get(i);
                String info = text.getText();
                String[] splitedPhrase = info.split(", ");
                String age = splitedPhrase[1];
                int ageNum = Integer.parseInt(age);

                if(min <= ageNum || ageNum <= max) {
                    System.out.println("This age: " + ageNum + " is correct");
                } else {
                    Assert.fail("Wrong age: " + ageNum);
                }
            }
            mainPage.javaWaitSec(3);
            infoAboutUser = driver.findElements(Locators.TEXT_USER_INFO);
        }
    }

    @Test(priority = 5, enabled = testCase20, groups = {"user", "admin"})
    public void testUserProfile() {
        mainPage.clickMobileMenu2();
        mainPage.javaWaitSec(2);
        mainPage.clickPrettyWomenLink();
        driver.findElement(Locators.USER_PROFILE).click();
        mainPage.javaWaitSec(2);
        String currentUrl;

        List<WebElement> informationUserProfile = driver.findElements(Locators.TAB_PRETTY_WOMEN_PROFILE);
        for (int i = 0; i < informationUserProfile.size(); i++) {
            informationUserProfile.get(i).click();
            mainPage.javaWaitSec(3);
            prettyWomenPage.getAnyTitle();
            if (i == 0) {
                currentUrl = driver.getCurrentUrl();
                Assert.assertTrue(currentUrl.contains("/wall"));
            } else if (i == 1) {
                currentUrl = driver.getCurrentUrl();
                Assert.assertTrue(currentUrl.contains("/profile"));
            } else if (i == 2) {
                currentUrl = driver.getCurrentUrl();
                Assert.assertTrue(currentUrl.contains("/gallery"));
            }
            informationUserProfile = driver.findElements(Locators.TAB_PRETTY_WOMEN_PROFILE);
        }
    }

    @Test(priority = 6, enabled = testCase21, groups = {"user", "admin"})
    public void testFooter() {
        String text;
        mainPage.clickGiftsLink();
        mainPage.javaWaitSec(2);
        mainPage.scrollToBottomOfPage();
        List<WebElement> footerLinks = driver.findElements(Locators.LINKS_FOOTER);
        for (int i = 0; i < footerLinks.size() - 1; i++) {
            if (i == 0) {
                text = footerLinks.get(i).getText();
                Assert.assertTrue(text.contains("Contact"));
            } else if (i == 1) {
                text = footerLinks.get(i).getText();
                Assert.assertTrue(text.contains("Sitemap"));
            } else if (i == 2) {
                text = footerLinks.get(i).getText();
                Assert.assertTrue(text.contains("How it works"));
            } else if (i == 3) {
                text = footerLinks.get(i).getText();
                Assert.assertTrue(text.contains("News"));
            } else if (i == 4) {
                text = footerLinks.get(i).getText();
                Assert.assertTrue(text.contains("Privacy"));
            } else if (i == 5) {
                text = footerLinks.get(i).getText();
                Assert.assertTrue(text.contains("Terms of use"));
            }
            footerLinks.get(i).click();
            mainPage.javaWaitSec(1);
            driver.navigate().back();
            footerLinks = driver.findElements(Locators.LINKS_FOOTER);
        }
    }

    @Test(priority = 7, enabled = testCase22, groups = {"user", "admin"})
    public void selectRandomDropDownListTestsOnSearchPage() {
        mainPage.clickMobileMenu(valueOfBox);
        mainPage.scrollToBottomOfPage();
        prettyWomenPage.clickPrettyWomenLink();
        int sizeOfDropDownListSortBy = prettyWomenPage.getSizeDropDownList(Locators.FILTER_MAX_AGE);
        System.out.println(sizeOfDropDownListSortBy);
        prettyWomenPage.clickSearchParameters(valueOfBox);
        for (int i = 0; i < 2; i++) {
            prettyWomenPage.selectItemDropDownRandomOption(Locators.FILTER_MAX_AGE, "Sort By");
            mainPage.javaWaitSec(3);
        }
    }
}

