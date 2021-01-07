package com.romanceabroad.ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;


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
    
    protected TestBox testBox ;

    protected enum TestBox {
        LOCAL, SAUCE
    };


    @BeforeMethod(groups = {"user", "admin"}, alwaysRun = true)
    @Parameters({"browser", "version", "platform", "testbox"})

    public void setup(@Optional("chrome") String browser,@Optional("null") String version,@Optional("null") String platform,@Optional("null") String box, Method method) throws MalformedURLException {

        Reports.start(method.getDeclaringClass().getName() + " : " + method.getName());

        if(box.equalsIgnoreCase("local")) {
            testBox = TestBox.LOCAL;
        } else if(box.equalsIgnoreCase("sauce")) {
            testBox = TestBox.SAUCE;
        }

        switch (testBox) {
            case LOCAL:
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

            } else {
                System.setProperty("webdriver.chrome.driver", "chromedriver");

                ChromeOptions options = new ChromeOptions();
                options.addArguments("--kiosk");
                driver = new ChromeDriver(options);
                driver.get("chrome://settings/clearBrowserData");
            }
            break;
            case SAUCE:
                DesiredCapabilities capabilities = new DesiredCapabilities();
                capabilities.setCapability("username", "recreant");
                capabilities.setCapability("accessKey", "9789592c-10d1-4d12-8055-c861fc5bc38d");
                capabilities.setCapability("browserName", browser);
                capabilities.setCapability("platform", platform);
                capabilities.setCapability("version", version);
                capabilities.setCapability("name", method.getName());
                driver = new RemoteWebDriver(
                        new URL("https//" + System.getenv("SAUCE_USERNAME") + ":" + System.getenv("SAUCE_ACCESS_KEY") + "@ondemand.us-west-1.saucelabs.com:443/wd/hub"),
                        capabilities);
                break;
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
    public void afterActions(ITestResult testResult) {

        if (testResult.getStatus() == ITestResult.FAILURE) {
            Reports.fail(driver, testResult.getName());
        }
        Reports.stop();

        driver.quit();
    }
}
