import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


public class PrettyWomenTests extends BaseUI {

    String currentUrlSearch;

    @Test
    public void testPrettyWoman() {

        mainPage.clickPrettyWomenLink();

        currentUrlSearch = driver.getCurrentUrl();
        System.out.println(currentUrlSearch);

        Assert.assertEquals(Data.expectedPrettyWomenUrl,currentUrlSearch);

        WebElement maxAge = driver.findElement(Locators.FILTER_MAX_AGE);
        prettyWomenPage.getDropDownListByIndex(maxAge,8);
    }
    @Test
    public  void testSearchButton() {
        mainPage.clickPrettyWomenLink();
        if(driver.findElement(Locators.TEXT_FIELD_PRETTY_WOMEN_SEARCH).isDisplayed()) {
            System.out.println(Data.clicable);
        } else {
            Assert.assertFalse(false, Data.notClicable);
        }
    }
}
