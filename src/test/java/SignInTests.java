import org.testng.Assert;
import org.testng.annotations.Test;

public class SignInTests extends BaseUI {

    public static final boolean testCase5 = true;
    @Test(priority = 1, enabled = testCase5, groups = {"user", "admin"})
    public void testSignIn () {

        mainPage.clickSignInLink();

        signInPage.fillInEmailAndPassword();

        signInPage.getCurrentTitle();

        Assert.assertEquals(Data.expectedLogInTitle,signInPage.getCurrentTitle());

    }
}
