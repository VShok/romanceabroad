import org.testng.Assert;
import org.testng.annotations.Test;


public class PrettyWomenTests extends BaseUI {

    String currentUrlSearch;
    public static final boolean testCase2 = true;
    public static final boolean testCase3 = true;
    public static final boolean testCase4 = true;


    @Test(priority = 1, enabled = testCase2, groups = {"user", "admin"})
    public void testPrettyWomenLink() {

        mainPage.clickPrettyWomenLink();

        currentUrlSearch = driver.getCurrentUrl();
        System.out.println(currentUrlSearch);

        Assert.assertEquals(Data.expectedPrettyWomenUrl,currentUrlSearch);

        prettyWomenPage.getDropDownListByIndex(Locators.FILTER_MAX_AGE,8);
    }
    @Test(priority = 2, enabled = testCase3, groups = {"user", "admin"})
    public  void testSearchButtonTestCase3() {
        mainPage.clickPrettyWomenLink();
        if(driver.findElement(Locators.TEXT_FIELD_PRETTY_WOMEN_SEARCH).isDisplayed()) {
            System.out.println(Data.clicable);
        } else {
            Assert.assertFalse(false, Data.notClicable);
        }
    }

    @Test(priority = 3, enabled = testCase4, groups = {"user", "admin"})
    public void testThirdPageTestCase4() {
        mainPage.clickPrettyWomenLink();
        mainPage.scrollToBottomOfPage();
        mainPage.javaWait(2500);
        mainPage.performClickWebElement(driver.findElement(Locators.THIRD_PAGE_PRETTY_WOMEN));
    }
}
