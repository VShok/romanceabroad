import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignInTests extends BaseUI {

    String currentLogInTitle;

    @Test
    public void testSignIn () {

        mainPage.clickSignInLink();

        signInPage.fillInEmailAndPassword();

        WebElement headerLogIn = driver.findElement(Locators.TITLE_LOGIN);
        currentLogInTitle = headerLogIn.getText();

        System.out.println(currentLogInTitle);

        Assert.assertEquals(Data.expectedLogInTitle,currentLogInTitle);

    }
}
