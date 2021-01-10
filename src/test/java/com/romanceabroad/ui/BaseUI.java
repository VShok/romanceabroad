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
        import java.util.HashMap;
        import java.util.Map;


public class BaseUI {

    ChromeOptions options;

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

    protected TestBox testBox;
    protected TestBrowser testBrowser;
    protected String valueOfBox;

    protected enum TestBox {
        WEB, MOBILE, SAUCE
    }

    ;

    protected enum TestBrowser {
        CHROME, FIREFOX
    }

    ;


    @BeforeMethod(groups = {"user", "admin"}, alwaysRun = true)
    @Parameters({"browser", "version", "platform", "testBox", "deviceName", "testEnv"})

    public void setup(@Optional("chrome") String browser,
                      @Optional("null") String version, @Optional("null") String platform,
                      @Optional("web") String box, @Optional("null") String device,
                      @Optional("qa") String env, Method method) throws MalformedURLException {

        Reports.start(method.getDeclaringClass().getName() + " : " + method.getName());

        if (box.equalsIgnoreCase("web")) {
            testBox = TestBox.WEB;
        } else if (box.equalsIgnoreCase("mobile")) {
            testBox = TestBox.MOBILE;
        } else if (box.equalsIgnoreCase("sauce")) {
            testBox = TestBox.SAUCE;
        }

        if (browser.equalsIgnoreCase("chrome")) {
            testBrowser = TestBrowser.CHROME;
        } else if (box.equalsIgnoreCase("firefox")) {
            testBrowser = TestBrowser.FIREFOX;
        }

        switch (testBox) {
            case WEB:
                switch (testBrowser) {
                    case FIREFOX:

                        System.setProperty("webdriver.gecko.driver", "geckodriver");
                        driver = new FirefoxDriver();

                        break;

                    // Check if parameter passed as 'chrome'

                    case CHROME:
                        // Set path to chromedriver.exe
                        System.setProperty("webdriver.chrome.driver", "chromedriver");
                        // Create chrome instance
                        options = new ChromeOptions();
                        options.addArguments("--kiosk");
                        driver = new ChromeDriver(options);
                        driver.get("chrome://settings/clearBrowserData");
                        break;

                    default:
                        System.out.println("Default!");
                        System.setProperty("webdriver.chrome.driver", "chromedriver");

                        options = new ChromeOptions();
                        options.addArguments("--kiosk");
                        driver = new ChromeDriver(options);
                        driver.get("chrome://settings/clearBrowserData");
                        break;
                }
                break;

            case MOBILE:
                switch (testBrowser) {
                    case CHROME:
                        Map<String, String> mobileEmulation = new HashMap<String, String>();
                        mobileEmulation.put("deviceName", "Pixel 2 XL");
                        options = new ChromeOptions();
                        options.setExperimentalOption("mobileEmulation", mobileEmulation);
                        System.setProperty("webdriver.chrome.driver", "chromedriver");
                        driver = new ChromeDriver(options);
                        driver.get("chrome://settings/clearBrowserData");
                        break;
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
                        new URL("https://recreant:9789592c-10d1-4d12-8055-c861fc5bc38d@ondemand.us-west-1.saucelabs.com:443/wd/hub"),
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

        if (env.contains("qa")) {
            driver.get(Data.MAIN_URL);
        } else if (env.contains("uat")){
            driver.get("https://www.google.com/");
        } else if (env.contains("prod")) {
            driver.get("https://www.yahoo.com/");
        }

        valueOfBox = box;
    }

    @AfterMethod(groups = {"user", "admin"}, alwaysRun = true)
    public void afterActions(ITestResult testResult) {

        if (testResult.getStatus() == ITestResult.FAILURE) {
            Reports.fail(driver, testResult.getName());
        }
        Reports.stop();

        //driver.quit();
    }
}
