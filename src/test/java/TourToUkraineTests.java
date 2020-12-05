import org.testng.Assert;
import org.testng.annotations.Test;

public class TourToUkraineTests extends BaseUI {
    public static final boolean testCase6 = true;
    String currentUrlSearch;
    @Test(priority = 1, enabled = testCase6, groups = {"user", "admin"})
    public void testTourToUkraine () {

        mainPage.clickTourToUkraineLink();

        currentUrlSearch = driver.getCurrentUrl();
        System.out.println(currentUrlSearch);

        Assert.assertEquals(Data.expectedTourUkraineUrl,currentUrlSearch);
    }


}
