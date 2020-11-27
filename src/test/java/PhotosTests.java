import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
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

    @Test
    public void clickAddPhoto() {
        mainPage.clickPhotosLink();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(), 'Add photo')]")));
        Assert.assertTrue(driver.findElement(By.xpath("//button[contains(text(), 'Add photo')]")).isDisplayed(), "Not Displayed");
    }
}
