import org.testng.Assert;
import org.testng.annotations.Test;

public class HowWeWorkTests extends BaseUI {
    String currentUrlSearch;

    @Test
    public void testHowWeWork () {

        mainPage.clickHowWeWorkLink();

        currentUrlSearch = driver.getCurrentUrl();
        System.out.println(currentUrlSearch);

        Assert.assertEquals(Data.expectedHowWeWorksUrl,currentUrlSearch);
    }
}
