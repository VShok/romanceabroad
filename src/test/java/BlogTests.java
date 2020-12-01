import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import java.util.List;


public class BlogTests extends BaseUI {
    String currentUrlSearch;

    @Test
    public void testBlog () {
        mainPage.clickBlogLink();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy((Locators.BLOGS_BLOG_PAGE)));
        List <WebElement> blogs = driver.findElements(Locators.BLOGS_BLOG_PAGE);
        System.out.println(blogs.size());
        for (int i = 0; i < blogs.size(); i++) {
            blogPage.getCurrentTextBlog(i);
            blogs.get(i).click();
            driver.get(Data.expectedBlogUrl);
            currentUrlSearch = driver.getCurrentUrl();
            blogs = driver.findElements(Locators.BLOGS_BLOG_PAGE);
            softAssert.assertEquals(Data.expectedBlogUrl, currentUrlSearch, "Mismatch between URL's");
        }
        softAssert.assertAll();
    }
}
