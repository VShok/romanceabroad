import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class RegistrationTests extends BaseUI {

    public static final boolean testCase1 = true;
    @Test(enabled = testCase1, groups = {"user", "admin"})
    public void testFillInformationRegistrationPage() {
        mainPage.clickRegistrationButton();
        mainPage.fillInEmailAndPassword(Data.email, Data.password);
        mainPage.fillInFullInformation(mainPage.generateNewNumber(Data.username, 5),
                Data.phoneNumber, Data.month, Data.day, Data.year, Data.location, Data.city);
        WebElement checkbox = driver.findElement(Locators.CHECKBOX_CONFIRMATION);
        if (!checkbox.isSelected()) {
            checkbox.click();
            System.out.println(Data.checkbox);
        }
    }
}
