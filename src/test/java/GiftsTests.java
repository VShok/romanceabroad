import org.testng.Assert;
import org.testng.annotations.Test;

public class GiftsTests extends BaseUI {

    String currentUrlSearch;
    public static final boolean testCase15 = true;


    @Test(priority = 1, enabled = testCase15, groups = {"user", "admin"})
    public void testGifts () {

        mainPage.clickGiftsLink();
        currentUrlSearch = driver.getCurrentUrl();
        System.out.println(currentUrlSearch);

        Assert.assertEquals(Data.expectedGiftsUrl,currentUrlSearch);
    }
}
