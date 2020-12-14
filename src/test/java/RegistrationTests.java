import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class RegistrationTests extends BaseUI {

    public static final boolean testCase1 = true;
    @DataProvider(name = "Registration")
    public static Object[][] testRegistration1() throws Exception {
        ArrayList<Object[]> out = new ArrayList<>();
        Files.readAllLines(Paths.get("Registration.csv")).stream().forEach(s-> {

            String[] data = s.split(",");
            out.add(new Object[] {data[0],data[1],data[2],data[3],data[4],data[5],data[6],data[7]});
        });

        return out.toArray(new Object[out.size()][]);
    }

    @Test(dataProvider = "Registration", enabled = testCase1, groups = {"user", "admin"})
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
}
