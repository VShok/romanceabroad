import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PrettyWomenTests extends BaseUI {

    String currentUrlSearch;

    @Test
    public void testPrettyWoman () {

        WebElement link_PrettyWoman = driver.findElement(Locators.LINK_PRETTY_WOMAN);
        link_PrettyWoman.click();

        currentUrlSearch = driver.getCurrentUrl();
        System.out.println(currentUrlSearch);

        Assert.assertEquals(Data.expectedPrettyWomenUrl,currentUrlSearch);
    }
}
