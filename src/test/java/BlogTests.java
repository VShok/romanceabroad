import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


public class BlogTests extends BaseUI {
    String currentUrlSearch;

    @Test
    public void testBlog () {

        mainPage.clickBlogLink();

        currentUrlSearch = driver.getCurrentUrl();
        System.out.println(currentUrlSearch);

        Assert.assertEquals(Data.expectedBlogUrl,currentUrlSearch);
    }
}
