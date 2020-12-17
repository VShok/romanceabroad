import org.testng.Assert;
import org.testng.annotations.Test;
public class SignInTests extends BaseUI {

    public static final boolean testCase5 = true;


    @Test(dataProvider = "SignIn",enabled = testCase5, groups = {"user", "admin"}, dataProviderClass = DataProviders.class)
    public void testSignInFillInLoginPassword (String email, String password) {

        mainPage.clickSignInLink();

        signInPage.fillInEmailAndPassword(email, password);

        signInPage.getCurrentTitle();

        Assert.assertEquals(Data.expectedLogInTitle,signInPage.getCurrentTitle());

    }
}
