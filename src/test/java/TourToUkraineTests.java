import org.testng.Assert;
import org.testng.annotations.Test;

public class TourToUkraineTests extends BaseUI {
    public static final boolean testCase6 = true;
    String currentUrlSearch;
    @Test(enabled = testCase6, groups = {"user", "admin"})
    public void testTourToUkraineLink() {

        mainPage.clickTourToUkraineLink();

        currentUrlSearch = driver.getCurrentUrl();
        System.out.println(currentUrlSearch);

        Assert.assertEquals(Data.expectedTourUkraineUrl,currentUrlSearch);
    }


}
