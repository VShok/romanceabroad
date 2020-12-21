package com.romanceabroad.ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PrettyWomenPage extends BaseActions {
    public PrettyWomenPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void clickPrettyWomenLink() {
        driver.findElement(Locators.LINK_PRETTY_WOMAN).click();
        javaWait(3500);
    }

    public void clickSearchButton() {
        driver.findElement(Locators.BUTTON_SEARCH).click();
        javaWait(3500);
    }
}
