import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HowWeWorkTests extends BaseUI {
    String currentUrlSearch;
    public static final boolean testCase12 = true;
    public static final boolean testCase13 = true;
    public static final boolean testCase14 = true;

    @Test(priority = 1, enabled = testCase12, groups = {"user", "admin"})
    public void testHowWeWorkLink () {

        mainPage.clickHowWeWorkLink();
        currentUrlSearch = driver.getCurrentUrl();
        System.out.println(currentUrlSearch);

        Assert.assertEquals(Data.expectedHowWeWorksUrl,currentUrlSearch);
    }
    @Test(priority = 2, enabled = testCase13, groups = {"user", "admin"})
    public void testMainTitle() {
        mainPage.clickHowWeWorkLink();
        wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.CURRENT_TITLE));
        String titleHowItWorksPage = driver.findElement(Locators.CURRENT_TITLE).getText();
        if (titleHowItWorksPage != Data.expectedTitleHowItWorksPage) {
            System.out.println("Wrong title in How it works page");
        }

    }
    @Test(priority = 3, enabled = testCase14, groups = {"user", "admin"})
    public void testCountPagesContent() {
        mainPage.clickHowWeWorkLink();
        int count = 22;
        wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.CURRENT_TITLE));
        int countPagesContent = driver.findElements(Locators.BLOGS_PAGES).size();
        System.out.println(countPagesContent);
        if (countPagesContent != count) {
            System.out.println("There is a mismatch");
        }
    }
}
