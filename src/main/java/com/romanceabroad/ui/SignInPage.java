package com.romanceabroad.ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignInPage extends BaseActions {
    public SignInPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    public void fillInEmailAndPassword(String email, String password) {
        WebElement linkLoginEmail = driver.findElement(Locators.LINK_LOGIN_EMAIL);
        linkLoginEmail.sendKeys(email);

        WebElement linkLoginPassword = driver.findElement(Locators.LINK_LOGIN_PASSWORD);
        linkLoginPassword.sendKeys(password);
    }

    public String getCurrentTitle () {
        String title = driver.findElement(Locators.TITLE_LOGIN).getText();
        System.out.println(title);
        return title;
    }
}
