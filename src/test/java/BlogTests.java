import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;


public class BlogTests extends BaseUI {
    String currentUrlSearch;
    // List<WebElement>
    @Test
    public void testBlog () {
        mainPage.clickBlogLink();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy((By.xpath("//div[@class='info-content-block wysiwyg']//ul//li/a"))));
        List <WebElement> blogs = driver.findElements(By.xpath("//div[@class='info-content-block wysiwyg']//ul//li/a"));
        System.out.println(blogs.size());
        for (int i = 0; i < blogs.size(); i++) {
            String info = blogs.get(i).getText();
            System.out.println(info);
            blogs.get(i).click();
            driver.get(Data.expectedBlogUrl);
            currentUrlSearch = driver.getCurrentUrl();
            blogs = driver.findElements(By.xpath("//div[@class='info-content-block wysiwyg']//ul//li/a"));
            softAssert.assertEquals(Data.expectedBlogUrl, currentUrlSearch, "Mismatch between URL's");
        }
    }
}
