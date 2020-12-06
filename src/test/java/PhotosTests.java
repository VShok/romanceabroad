import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PhotosTests extends BaseUI {
    public static final boolean testCase7 = true;
    public static final boolean testCase8 = true;
    String currentUrlSearch;

    @Test(priority = 1, enabled = testCase7, groups = {"user", "admin"})
    public void testPhotosLink () {

        mainPage.clickPhotosLink();

        currentUrlSearch = driver.getCurrentUrl();
        System.out.println(currentUrlSearch);

        Assert.assertEquals(Data.expectedPhotosUrl,currentUrlSearch);

    }

    @Test(priority = 2, enabled = testCase8, groups = {"user", "admin"})
    public void testClickAddPhoto() {
        mainPage.clickPhotosLink();
        wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.BUTTON_ADD_PHOTOS));
        int count = mainPage.getSizeDropDownList(Locators.SELECT_PHOTOS);
        mainPage.selectItemDropDownRandomOption(Locators.SELECT_PHOTOS, "Sort By");
        System.out.println(count);
        Assert.assertTrue(driver.findElement(Locators.BUTTON_ADD_PHOTOS).isDisplayed(), Data.notDisplayed);
    }
}
