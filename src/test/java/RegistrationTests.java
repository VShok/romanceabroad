import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationTests extends BaseUI {

    @Test
    public void testRegistration() {
        mainPage.clickRegistrationButton();
        mainPage.fillInEmailAndPassword();
        mainPage.fillInFullInformation();
        WebElement checkbox = driver.findElement(Locators.BUTTON_CONFIRMATION);
        if (!checkbox.isSelected()) {
            checkbox.click();
            System.out.println("Checkbox is selected!");
        }
    }
}
