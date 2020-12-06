import org.testng.Assert;
import org.testng.annotations.Test;

public class GiftsTests extends BaseUI {

    String currentUrlSearch;
    public static final boolean testCase15 = true;


    @Test(enabled = testCase15, groups = {"user", "admin"})
    public void testGiftsLink () {

        mainPage.clickGiftsLink();
        currentUrlSearch = driver.getCurrentUrl();
        System.out.println(currentUrlSearch);

        Assert.assertEquals(Data.expectedGiftsUrl,currentUrlSearch);
    }
}
