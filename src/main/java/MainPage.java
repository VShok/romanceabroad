import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class MainPage extends BaseActions {

    public MainPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
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

    public void clickRegistrationButton() {
        driver.findElement(Locators.BUTTON_REGISTRATION).click();
    }
    public void fillInEmailAndPassword() {
        driver.findElement(Locators.TEXT_FIELD_EMAIL).sendKeys(Data.email);
        driver.findElement(Locators.TEXT_FIELD_PASSWORD).sendKeys(Data.password);
        driver.findElement(Locators.BUTTON_NEXT).click();
    }
    public void fillInFullInformation() {
        driver.findElement(Locators.TEXT_FIELD_USERNAME).sendKeys(generateNewNumber(Data.username, 5));
        driver.findElement(Locators.BUTTON_DAY_SELECT).click();
        driver.findElement(Locators.SIXTH_DAY_SELECT).click();
        driver.findElement(Locators.BUTTON_MONTH_SELECT).click();
        driver.findElement(Locators.JUNE_MONTH_SELECT).click();
        driver.findElement(Locators.BUTTON_YEAR_SELECT).click();
        driver.findElement(Locators.NINETEEN_EIGHTY_NINE_YEAR_SELECT).click();
        driver.findElement(Locators.TEXT_FIELD_PHONE).sendKeys(Data.phoneNumber);
    }
}
