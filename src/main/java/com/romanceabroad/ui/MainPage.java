package com.romanceabroad.ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;

public class MainPage extends BaseActions {

    public MainPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public String getCurrentTitleTextHomePage() {
        String text = driver.findElement(Locators.TITLE_HOME_PAGE).getText();
        return text;
    }

    public void clickNextButton() {
        driver.findElement(Locators.BUTTON_NEXT);
    }


    public String getCurrentTitleHomePages(int index) {
        String info = driver.findElements(Locators.TAB_OF_MAIN_PAGE).get(index).getText();
        System.out.println(info);
        return info;
    }
    public String getTitle() {
        String actualTitle = driver.findElement(Locators.H1_TITLE).getText();
        return actualTitle;
    }

    public void clickHowWeWorkLink() {
        WebElement link_HowWeWork = driver.findElement(Locators.LINK_HOW_WE_WORKS);
        link_HowWeWork.click();
    }

    public void clickPrettyWomenLink() {
        WebElement link_PrettyWoman = driver.findElement(Locators.LINK_PRETTY_WOMAN);
        link_PrettyWoman.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.TABLE_AGE_MIN_MAX));
    }

    public void clickGiftsLink() {
        WebElement link_Gifts = driver.findElement(Locators.LINK_GIFTS);
        link_Gifts.click();
    }

    public void clickPhotosLink() {
        WebElement link_Photos = driver.findElement(Locators.LINK_PHOTOS);
        link_Photos.click();
    }

    public void clickTourToUkraineLink() {
        WebElement link_Tour_Ukraine = driver.findElement(Locators.LINK_TOUR_UKRAINE);
        link_Tour_Ukraine.click();
    }

    public void clickBlogLink() {
        WebElement link_Blog = driver.findElement(Locators.LINK_BLOG);
        link_Blog.click();
    }

    public void clickSignInLink() {
        WebElement link_SignIn = driver.findElement(Locators.LINK_SIGN_IN);
        link_SignIn.click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    public void clickContactUsPage() {
        wait.until(ExpectedConditions.elementToBeClickable(Locators.LINK_CONTACT_US_PAGE));
        WebElement link_Contact_Us = driver.findElement(Locators.LINK_CONTACT_US_PAGE);
        ajaxClick(link_Contact_Us);
    }

    public void clickRegistrationButton() {
        driver.findElement(Locators.BUTTON_REGISTRATION).click();
    }
    public void fillInEmailAndPassword(String email, String password) {
        driver.findElement(Locators.TEXT_FIELD_EMAIL).sendKeys(email);
        driver.findElement(Locators.TEXT_FIELD_PASSWORD).sendKeys(password);
        driver.findElement(Locators.BUTTON_NEXT).click();
    }
    public void fillInFullInformation(String username, String day, String month, String year, String phone, String city, String location) {
        driver.findElement(Locators.TEXT_FIELD_USERNAME).sendKeys(username);

        driver.findElement(Locators.BUTTON_DAY_SELECT).click();
        clickValueOfList(Locators.LIST_VALUE_DAY, day);

        driver.findElement(Locators.BUTTON_MONTH_SELECT).click();
        clickValueOfList(Locators.LIST_VALUE_MONTH, month);

        driver.findElement(Locators.BUTTON_YEAR_SELECT).click();
        clickValueOfList(Locators.LIST_VALUE_YEAR, year);

        driver.findElement(Locators.TEXT_FIELD_PHONE).sendKeys(phone);
        driver.findElement(Locators.CHECKBOX_CONFIRMATION).click();
        driver.findElement(Locators.AUTO_FILLING_FORM_LOCATION).clear();
        driver.findElement(Locators.AUTO_FILLING_FORM_LOCATION).sendKeys(city);
        clickValueOfList(Locators.LIST_VALUE_LOCATION, location);
    }

    public void javaWait(int ms) {
        System.out.println("Child!!!");
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
