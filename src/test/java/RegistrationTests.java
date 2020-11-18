import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class RegistrationTests extends BaseUI {

    @Test

    public void testRegistration() {

        WebElement buttonRegistration = driver.findElement(Locators.BUTTON_REGISTRATION);
        buttonRegistration.click();
        driver.findElement(Locators.TEXT_FIELD_EMAIL).sendKeys(Data.email);
        driver.findElement(Locators.TEXT_FIELD_PASSWORD).sendKeys(Data.password);
        driver.findElement(Locators.BUTTON_NEXT).click();
        driver.findElement(Locators.TEXT_FIELD_USERNAME).sendKeys(Data.username);
        driver.findElement(Locators.TEXT_FIELD_PHONE).sendKeys(Data.phoneNumber);

    }

}
