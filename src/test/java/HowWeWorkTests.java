import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HowWeWorkTests extends BaseUI {
    String currentUrlSearch;

    @Test
    public void testHowWeWork () {

        WebElement link_HowWeWork = driver.findElement(Locators.LINK_HOW_WE_WORKS);
        link_HowWeWork.click();

        currentUrlSearch = driver.getCurrentUrl();
        System.out.println(currentUrlSearch);

        Assert.assertEquals(Data.expectedHowWeWorksUrl,currentUrlSearch);
    }
}
