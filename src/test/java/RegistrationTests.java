import org.testng.annotations.Test;

public class RegistrationTests extends BaseUI {

    @Test
    public void testRegistration() {
        mainPage.clickRegistrationButton();
        mainPage.fillInEmailAndPassword();
        mainPage.fillInFullInformation();
    }

}
