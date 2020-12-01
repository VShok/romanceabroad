import org.testng.Assert;
import org.testng.annotations.Test;

public class GiftsTests extends BaseUI {

    String currentUrlSearch;


    @Test
    public void testGifts () {

        mainPage.clickGiftsLink();
        currentUrlSearch = driver.getCurrentUrl();
        System.out.println(currentUrlSearch);

        Assert.assertEquals(Data.expectedGiftsUrl,currentUrlSearch);
    }
}
