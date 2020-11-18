import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SignInTests extends BaseUI {

    String currentLogInTitle;


    String email = "grubhuo@gmail.com";
    String password = "Pork450941!";
    @Test
    public void testSignIn () {

        WebElement link_SignIn = driver.findElement(Locators.LINK_SIGN_IN);
        link_SignIn.click();

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        WebElement linkLoginEmail = driver.findElement(Locators.LINK_LOGIN_EMAIL);
        linkLoginEmail.sendKeys(email);

        WebElement linkLoginPassword = driver.findElement(Locators.LINK_LOGIN_PASSWORD);
        linkLoginPassword.sendKeys(password);

        WebElement headerLogIn = driver.findElement(Locators.TITLE_LOGIN);
        currentLogInTitle = headerLogIn.getText();

        System.out.println(currentLogInTitle);

        Assert.assertEquals(Data.expectedLogInTitle,currentLogInTitle);

    }
}
