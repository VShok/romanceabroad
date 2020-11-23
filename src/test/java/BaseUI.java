import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

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
    String mainUrl = "https://romanceabroad.com/";

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--kiosk");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, 30);
        mainPage = new MainPage(driver, wait);
        howWeWorkPage = new HowWeWorkPage(driver, wait);
        prettyWomenPage = new PrettyWomenPage(driver, wait);
        photosPage = new PhotosPage(driver, wait);
        giftsPage = new GiftsPage(driver, wait);
        tourToUkrainePage = new TourToUkrainePage(driver, wait);
        blogPage = new BlogPage(driver, wait);
        signInPage = new SignInPage(driver, wait);
        driver.get(mainUrl);
    }

    @AfterMethod
    public void afterActions() {
     //   driver.quit();
    }
}
