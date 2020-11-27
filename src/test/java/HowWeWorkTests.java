import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HowWeWorkTests extends BaseUI {
    String currentUrlSearch;

    @Test
    public void testHowWeWork () {

        mainPage.clickHowWeWorkLink();
        currentUrlSearch = driver.getCurrentUrl();
        System.out.println(currentUrlSearch);

        Assert.assertEquals(Data.expectedHowWeWorksUrl,currentUrlSearch);
    }
    @Test
    public void testMainTitle() {
        mainPage.clickHowWeWorkLink();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1")));
        String titleHowItWorksPage = driver.findElement(By.xpath("//h1")).getText();
        if (titleHowItWorksPage != Data.expectedTitleHowItWorksPage) {
            System.out.println("Wrong title in How it works page");
        }

    }
    @Test
    public void testCountPagesContent() {
        mainPage.clickHowWeWorkLink();
        int count = 22;
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1")));
        int countPagesContent = driver.findElements(By.xpath("//li//div[@class='fleft']")).size();
        System.out.println(countPagesContent);
        if (countPagesContent != count) {
            System.out.println("There is a mismatch");
        }
    }
}
