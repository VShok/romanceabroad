import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseUI {

    WebDriver driver;
    WebDriverWait wait;
    MainPage mainPage;
    String mainUrl = "https://romanceabroad.com/";

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--kiosk");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, 30);
        driver.get(mainUrl);
    }

    @AfterMethod
    public void afterActions() {
     //   driver.quit();
    }

    public static String generateNewNumber(String name, int length){

        return name + RandomStringUtils.random(length, "172984757");

    }

    public void getDropDownListByIndex(WebElement element, int index) {

        Select select = new Select(element);
        select.selectByIndex(index);
    }
}
