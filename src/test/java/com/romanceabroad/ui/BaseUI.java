package com.romanceabroad.ui;

import com.romanceabroad.ui.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import java.lang.reflect.Method;

public class BaseUI {

    WebDriver driver;
    WebDriverWait wait;
    MainPage mainPage;
    HowWeWorkPage howWeWorkPage;
    PrettyWomenPage prettyWomenPage;
    PhotosPage photosPage;
    GiftsPage giftsPage;
    TourToUkrainePage tourToUkrainePage;
    BlogPage blogPage;
    SignInPage signInPage;
    ContactUsPage contactUsPage;
    String mainUrl = "https://romanceabroad.com/";
    SoftAssert softAssert = new SoftAssert();


    @BeforeMethod(groups = {"user", "admin"}, alwaysRun = true)

    @Parameters("browser")

    public void setup(@Optional("chrome") String browser, Method method){



        // Check if parameter passed from TestNG is 'firefox'

        if (browser.equalsIgnoreCase("firefox")) {

            // Create firefox instance

            System.setProperty("webdriver.gecko.driver", "geckodriver");

            driver = new FirefoxDriver();

        }

        // Check if parameter passed as 'chrome'

        else if (browser.equalsIgnoreCase("chrome")) {

            // Set path to chromedriver.exe

            System.setProperty("webdriver.chrome.driver", "chromedriver");

            // Create chrome instance
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--kiosk");
            driver = new ChromeDriver(options);
            driver.get("chrome://settings/clearBrowserData");

        }
        else {
            System.setProperty("webdriver.chrome.driver", "chromedriver");

            ChromeOptions options = new ChromeOptions();
            options.addArguments("--kiosk");
            driver = new ChromeDriver(options);
            driver.get("chrome://settings/clearBrowserData");
        }
        wait = new WebDriverWait(driver, 30);
        mainPage = new MainPage(driver, wait);
        howWeWorkPage = new HowWeWorkPage(driver, wait);
        prettyWomenPage = new PrettyWomenPage(driver, wait);
        photosPage = new PhotosPage(driver, wait);
        giftsPage = new GiftsPage(driver, wait);
        tourToUkrainePage = new TourToUkrainePage(driver, wait);
        blogPage = new BlogPage(driver, wait);
        signInPage = new SignInPage(driver, wait);
        contactUsPage = new ContactUsPage(driver, wait);
        driver.get(mainUrl);
    }

    @AfterMethod(groups = {"user", "admin"}, alwaysRun = true)
    public void afterActions() {
        driver.quit();
    }
}
