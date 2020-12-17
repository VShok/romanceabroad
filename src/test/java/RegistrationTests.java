import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


public class RegistrationTests extends BaseUI {

    public static final boolean testCase1 = true;
    public static final boolean testCase18 = true;
   @Test(dataProvider = "Registration", enabled = testCase1, groups = {"user", "admin"}, dataProviderClass = DataProviders.class)
    public void testFillInformationRegistrationPage(String email, String password, String day, String month,
                                                    String year, String phone, String city, String location) {
        System.out.println(email);
        mainPage.clickRegistrationButton();
        mainPage.fillInEmailAndPassword(email, password);
        mainPage.fillInFullInformation(mainPage.generateNewNumber(Data.username, 5), day, month, year, phone, city, location);
        WebElement checkbox = driver.findElement(Locators.CHECKBOX_CONFIRMATION);
        if (!checkbox.isSelected()) {
            checkbox.click();
            System.out.println(Data.checkbox);
        }
    }

    @Test(dataProvider = "Registration2", enabled = testCase18, groups = {"user", "admin"}, dataProviderClass = DataProviders.class)
    public void testFillInformationRegistrationPage(String email,String username,boolean requirement) {
        System.out.println(email);
        mainPage.clickRegistrationButton();
        mainPage.fillInEmailAndPassword(email, Data.password);
        if(!requirement) {
            Assert.assertTrue(driver.findElement(Locators.TOOLTIP_ERROR).isDisplayed());
        } else {
            mainPage.clickNextButton();
            mainPage.fillInFullInformation(username, Data.day, Data.month, Data.year, Data.phone, Data.city, Data.location);
        }
    }
}
