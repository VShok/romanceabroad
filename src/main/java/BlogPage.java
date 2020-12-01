import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BlogPage extends BaseActions {
    public BlogPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public String getCurrentTextBlog(int index) {
        String text = driver.findElements(Locators.BLOGS_BLOG_PAGE).get(index).getText();
        System.out.println(text);
        return text;
    }
}
