import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GiftsTests extends BaseUI {

    String currentUrlSearch;


    @Test
    public void testGifts () {

        WebElement link_Gifts = driver.findElement(Locators.LINK_GIFTS);
        link_Gifts.click();

        currentUrlSearch = driver.getCurrentUrl();
        System.out.println(currentUrlSearch);

        Assert.assertEquals(Data.expectedGiftsUrl,currentUrlSearch);
    }
}
