import org.openqa.selenium.By;
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
        prettyWomenPage.changeMaxAgePrettyWomen();
    }
    @Test
    public  void testSearchButton() {
        mainPage.clickPrettyWomenLink();
        if(driver.findElement(By.xpath("//input[@value='Search']")).isDisplayed()) {
            System.out.println("Clickable");
        } else {
            Assert.assertFalse(false, "Not clickable");
        }
    }
}
