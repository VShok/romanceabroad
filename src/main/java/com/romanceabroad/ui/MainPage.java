package com.romanceabroad.ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;

public class MainPage extends BaseActions {

    @FindBy(css = "#show-registration-block")
    WebElement registrationButton;

    public MainPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void clickMobileMenu(String valueOfBox) {
        if(valueOfBox.contains("mobile")) {
            driver.findElement(Locators.MOBILE_MENU).click();
        }
    }

    public void clickMobileMenu() {
        try {
            driver.findElement(Locators.MOBILE_MENU).click();
        } catch (Exception e) {

        }
    }

    public void clickMobileMenu2() {
        if(driver.findElement(Locators.MOBILE_MENU).isDisplayed()) {
            driver.findElement(Locators.MOBILE_MENU).click();
        }
    }

    public void clickMobileMenu3() {
        if(driver.findElements(Locators.MOBILE_MENU).size() > 0) {
            driver.findElement(Locators.MOBILE_MENU).click();
        }
    }

    public String getCurrentTitleTextHomePage() {
        String text = driver.findElement(Locators.TITLE_HOME_PAGE).getText();
        return text;
    }

    public void clickNextButton() {
        Reports.log("Click Next button");
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
        Reports.log("Click Join button");
        registrationButton.click();
    }
    public void fillInEmailAndPassword(String email, String password) {
        Reports.log("Type email in the text field" + email);
        driver.findElement(Locators.TEXT_FIELD_EMAIL).sendKeys(email);

        Reports.log("Type password in the text field" + password);
        driver.findElement(Locators.TEXT_FIELD_PASSWORD).sendKeys(password);

        Reports.log("Click Next button");
        driver.findElement(Locators.BUTTON_NEXT).click();
    }
    public void fillInFullInformation(String username, String day, String month, String year, String phone, String city, String location) {
        Reports.log("Type username in the text field" + username);
        driver.findElement(Locators.TEXT_FIELD_USERNAME).sendKeys(username);

        Reports.log("Choose day from the list" + day);
        driver.findElement(Locators.BUTTON_DAY_SELECT).click();
        clickValueOfList(Locators.LIST_VALUE_DAY, day);

        Reports.log("Choose month from the list" + month);
        driver.findElement(Locators.BUTTON_MONTH_SELECT).click();
        clickValueOfList(Locators.LIST_VALUE_MONTH, month);

        Reports.log("Choose year from the list" + year);
        driver.findElement(Locators.BUTTON_YEAR_SELECT).click();
        clickValueOfList(Locators.LIST_VALUE_YEAR, year);

        Reports.log("Type phone number in the text field" + phone);
        driver.findElement(Locators.TEXT_FIELD_PHONE).sendKeys(phone);

        Reports.log("Click on confirmation checkbox");
        driver.findElement(Locators.CHECKBOX_CONFIRMATION).click();

        Reports.log("Clear the location");
        driver.findElement(Locators.AUTO_FILLING_FORM_LOCATION).clear();

        Reports.log("Type the city in the text field" + city);
        driver.findElement(Locators.AUTO_FILLING_FORM_LOCATION).sendKeys(city);

        Reports.log("Type the location in the text field" + location);
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
