import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PhotosTests extends BaseUI {

    String currentUrlSearch;

    @Test
    public void testPhotos () {

        mainPage.clickPhotosLink();

        currentUrlSearch = driver.getCurrentUrl();
        System.out.println(currentUrlSearch);

        Assert.assertEquals(Data.expectedPhotosUrl,currentUrlSearch);

    }
}
