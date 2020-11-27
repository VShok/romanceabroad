import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class MainTests extends BaseUI {

    @Test
    public void testYoutubePlayButton () {
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        WebElement frameHomePageYoutube = driver.findElement(Locators.FRAME_HOME_PAGE_YOUTUBE);
        driver.switchTo().frame(frameHomePageYoutube);
        driver.findElement(Locators.BUTTON_HOME_PAGE_YOUTUBE).click();

    }
    // List<int>
    @Test
    public void checkCountTitles() {
        List<WebElement> links = driver.findElements(By.xpath("//ul[@class='navbar-nav']//li"));
        System.out.println(links.size());
        List<Integer> count = new ArrayList<>(Arrays.asList(4,7,8,9,10));
        for (int i = 0; i < count.size(); i++) {
            if (count.get(i) == links.size()) {
                System.out.println("There is a match");
            }
        }
    }
    // List<String>
    @Test
    public void checkTitles() {
        WebElement title = driver.findElement(By.xpath("//a[contains(text(),'HOME')]"));
        wait.until(ExpectedConditions.visibilityOfAllElements(title));
        String mainTitles = title.getText();
        System.out.println(mainTitles);
        List<String> titles= new ArrayList<>(Arrays.asList(Data.titleHome, Data.titleBlog, Data.titleGifts));

        if(titles.contains(mainTitles)) {
            System.out.println("There is a match");
        } else {
            Assert.fail("There is no a match");
        }

    }


}
