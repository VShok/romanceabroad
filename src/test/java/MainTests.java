import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class MainTests extends BaseUI {

    @Test
    public void testMainPage () {
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        WebElement frameHomePageYoutube = driver.findElement(Locators.FRAME_HOME_PAGE_YOUTUBE);
        driver.switchTo().frame(frameHomePageYoutube);
        driver.findElement(Locators.BUTTON_HOME_PAGE_YOUTUBE).click();

    }


}
