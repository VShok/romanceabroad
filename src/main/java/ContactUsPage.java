import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactUsPage extends BaseActions {


    public ContactUsPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    public void fillInContactUsInformation(String name, String email, String subject, String message) {
        driver.findElement(Locators.TEXT_FIELD_USER_NAME).sendKeys(name);
        driver.findElement(Locators.TEXT_FIELD_USER_EMAIL).sendKeys(email);
        driver.findElement(Locators.TEXT_FIELD_USER_SUBJECT).sendKeys(subject);
        driver.findElement(Locators.TEXT_FIELD_USER_MESSAGE).sendKeys(message);

    }
}
