import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TourToUkraineTests extends BaseUI {

    String currentUrlSearch;
    @Test
    public void testTourToUkraine () {

        mainPage.clickTourToUkraineLink();

        currentUrlSearch = driver.getCurrentUrl();
        System.out.println(currentUrlSearch);

        Assert.assertEquals(Data.expectedTourUkraineUrl,currentUrlSearch);
    }


}
