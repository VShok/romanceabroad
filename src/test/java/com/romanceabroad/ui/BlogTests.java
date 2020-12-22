package com.romanceabroad.ui;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;


public class BlogTests extends BaseUI {
    String titleOfArticle;
    String nameOfArticle;
    String currentUrl;
    public static final boolean testCase16 = true;

    @Test(enabled = testCase16, groups = {"user", "admin"})
    public void testBlogLink () {
        mainPage.clickBlogLink();
         currentUrl = driver.getCurrentUrl();
        System.out.println(currentUrl);
        Assert.assertEquals(Data.expectedBlogUrl, currentUrl);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy((Locators.BLOGS_BLOG_PAGE)));
        List <WebElement> blogs = blogPage.collectAllLinksOfArticles();
        for (int i = 0; i < blogs.size(); i++) {
            WebElement link = blogs.get(i);
            nameOfArticle = link.getText();
            link.click();
            titleOfArticle = blogPage.getAnyTitle();
            driver.navigate().back();
            blogs = blogPage.collectAllLinksOfArticles();
            }
        }
    }
