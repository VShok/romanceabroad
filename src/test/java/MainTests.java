import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class MainTests extends BaseUI {
    public static final boolean testCase9 = true;
    public static final boolean testCase10 = true;
    public static final boolean testCase11 = true;

    @Test(priority = 1, enabled = testCase9, groups = {"user", "admin"})
    public void testYoutubePlayButton () {
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        WebElement frameHomePageYoutube = driver.findElement(Locators.FRAME_HOME_PAGE_YOUTUBE);
        driver.switchTo().frame(frameHomePageYoutube);
        driver.findElement(Locators.BUTTON_HOME_PAGE_YOUTUBE).click();

    }
    // List<int>
    @Test(priority = 2, enabled = testCase10, groups = {"user", "admin"})
    public void testCheckCountTitles() {
        List<WebElement> links = driver.findElements(Locators.TAB_OF_MAIN_PAGE);
        System.out.println(links.size());
        List<Integer> count = new ArrayList<>(Arrays.asList(4,7,8,9,10));
        for (int i = 0; i < count.size(); i++) {
            if (count.get(i) == links.size()) {
                System.out.println(Data.matched);
            }
        }
    }
    // List<String>
    @Test(priority = 3, enabled = testCase11, groups = {"user", "admin"})
    public void testCheckMainTitles() {
        WebElement title = driver.findElement(Locators.TITLE_HOME_PAGE);
        wait.until(ExpectedConditions.visibilityOfAllElements(title));
        String mainTitles = mainPage.getCurrentTitleTextHomePage();
        System.out.println(mainTitles);
        List<String> titles = new ArrayList<>(Arrays.asList(Data.titleHome, Data.titleBlog, Data.titleGifts));

        if(titles.contains(mainTitles)) {
            System.out.println(Data.matched);
        } else {
            Assert.fail(Data.notMatched);
        }
    }
}
