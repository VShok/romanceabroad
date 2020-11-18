import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TourToUkraineTests extends BaseUI {

    String currentUrlSearch;
    @Test
    public void testTourToUkraine () {

        WebElement link_Tour_Ukraine = driver.findElement(Locators.LINK_TOUR_UKRAINE);
        link_Tour_Ukraine.click();

        currentUrlSearch = driver.getCurrentUrl();
        System.out.println(currentUrlSearch);

        Assert.assertEquals(Data.expectedTourUkraineUrl,currentUrlSearch);
    }


}
