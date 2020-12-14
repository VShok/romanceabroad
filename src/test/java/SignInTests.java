import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class SignInTests extends BaseUI {

    public static final boolean testCase5 = true;

    @DataProvider(name = "SignIn")
    public static Object[][] testSignIn() throws Exception {
        ArrayList<Object[]> out = new ArrayList<>();
        Files.readAllLines(Paths.get("SignIn.csv")).stream().forEach(s-> {

            String[] data = s.split(",");
            out.add(new Object[] {data[0],data[1]});
        });

        return out.toArray(new Object[out.size()][]);
    }

    @Test(dataProvider = "SignIn",enabled = testCase5, groups = {"user", "admin"})
    public void testSignInFillInLoginPassword (String email, String password) {

        mainPage.clickSignInLink();

        signInPage.fillInEmailAndPassword(email, password);

        signInPage.getCurrentTitle();

        Assert.assertEquals(Data.expectedLogInTitle,signInPage.getCurrentTitle());

    }
}
