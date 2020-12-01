import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Conditions extends BaseUI {
    @Test
    public void test() {
        String fruit1 = "orange";
        String fruit2 = "kiwi";
        if (fruit2.contains("kiwi") || fruit1.contains("kiwi")) {
            System.out.println("We can find our fruits!");
        } else {
            Assert.fail("We can't find fruits!");
        }
    }

    @Test
    public void test2() {
        int number1 = 10;
        int number2 = 10;
        int sum;

        if (number1 == number2) {
            sum = 95 + 100;
        } else {
            sum = 100 - 95;
        }
        System.out.println(sum);
    }

    @Test
    public void test3() {
        boolean requirement = false;

        if (!requirement) {
            System.out.println("Boolean is true!");
        } else {
            Assert.fail("Boolean is false");
        }
    }

    @Test
    public void test4() {
        mainPage.clickRegistrationButton();
        mainPage.fillInEmailAndPassword();
        WebElement checkbox = driver.findElement(Locators.BUTTON_CONFIRMATION);
        if (!checkbox.isSelected()) {
            checkbox.click();
            System.out.println(Data.checkbox);
        }
    }


    @Test
    public void test5() {
        List<WebElement> links = driver.findElements(Locators.TAB_OF_MAIN_PAGE);
        System.out.println(links.size());
        for (int i = 0; i < links.size(); i++) {
            mainPage.getCurrentTitleHomePages(i);
            links.get(i).click();
            driver.get(Data.MAIN_URL);
            links = driver.findElements(Locators.TAB_OF_MAIN_PAGE);
        }
    }

    @Test
    public void test6() {
        String phrase = "Melon is inside the list";
        List<String> crunchyList1 = new ArrayList<>(Arrays.asList("apple", "kiwi", phrase));
        crunchyList1.add("melon");
        System.out.println(crunchyList1.size());

        for (int i = 0; i < crunchyList1.size(); i++) {
            String element = crunchyList1.get(i);
            System.out.println(i + " iteration");
            if (element.contains("apple")) {
                System.out.println(phrase);
                break;
            } else {
                System.out.println("Bad loop");
            }
        }
    }

    @Test
    public void test7() {
        String actualURLPrettyWomen;
        List<WebElement> links = driver.findElements(Locators.TAB_OF_MAIN_PAGE);
        System.out.println(links.size());

        for (int i = 0; i < links.size(); i++) {
            mainPage.getCurrentTitleHomePages(i);
            //links.get(i).click();
            mainPage.ajaxClick(links.get(i));
            if (mainPage.getCurrentTitleHomePages(i).contains("WORK")) {
                mainPage.getTitle();
                Assert.assertEquals(mainPage.getTitle(), Data.expectedTitleHowItWorksPage);
            }
            if (mainPage.getCurrentTitleHomePages(i).contains("PRETTY WOMEN")) {
                mainPage.getTitle();
                actualURLPrettyWomen = driver.getCurrentUrl();
                Assert.assertEquals(Data.expectedTitlePrettyWomen, mainPage.getTitle());
                Assert.assertEquals(Data.expectedPrettyWomenUrl, actualURLPrettyWomen);
                driver.findElement(Locators.IMAGES).isDisplayed();
                if(actualURLPrettyWomen.contains("#")) {
                    Assert.fail("It contains restricted #");
                } else {
                    System.out.println("No special characters, It's a good URL");
                }
            }

            driver.get(Data.MAIN_URL);
            links = driver.findElements(Locators.TAB_OF_MAIN_PAGE);
        }
    }
}
