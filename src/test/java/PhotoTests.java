import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PhotoTests extends BaseUI {

    String currentUrlSearch;

    @Test
    public void testPhotos () {

        WebElement link_Photos = driver.findElement(Locators.LINK_PHOTOS);
        link_Photos.click();

        currentUrlSearch = driver.getCurrentUrl();
        System.out.println(currentUrlSearch);

        Assert.assertEquals(Data.expectedPhotosUrl,currentUrlSearch);

    }
}
