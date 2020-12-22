package com.romanceabroad.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;


public class PrettyWomenTests extends BaseUI {

    String currentUrlSearch;
    public static final boolean testCase2 = true;
    public static final boolean testCase3 = true;
    public static final boolean testCase4 = true;
    public static final boolean testCase18 = true;


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
}

