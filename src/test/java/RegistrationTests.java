import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class RegistrationTests extends BaseUI {

    public static final boolean testCase1 = true;

    @Test(enabled = testCase1, groups = {"user", "admin"})
    public void testFillInformationRegistrationPage() {
        mainPage.clickRegistrationButton();
        mainPage.fillInEmailAndPassword();
        mainPage.fillInFullInformation();
        WebElement checkbox = driver.findElement(Locators.BUTTON_CONFIRMATION);
        if (!checkbox.isSelected()) {
            checkbox.click();
            System.out.println(Data.checkbox);
        }
    }
}
