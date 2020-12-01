import org.testng.Assert;
import org.testng.annotations.Test;

public class SignInTests extends BaseUI {


    @Test
    public void testSignIn () {

        mainPage.clickSignInLink();

        signInPage.fillInEmailAndPassword();

        signInPage.getCurrentTitle();

        Assert.assertEquals(Data.expectedLogInTitle,signInPage.getCurrentTitle());

    }
}
