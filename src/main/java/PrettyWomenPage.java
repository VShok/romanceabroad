import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PrettyWomenPage extends BaseActions {
    public PrettyWomenPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void changeMaxAgePrettyWomen() {
        WebElement filterMaxAge = driver.findElement(Locators.FILTER_MAX_AGE);
        getDropDownListByIndex(filterMaxAge, 8);
    }
}
