import org.openqa.selenium.By;

public class Locators {

    // Tour to Ukraine Page
    public static final By LINK_TOUR_UKRAINE = By.xpath("//a[@href='https://romanceabroad.com/store/sweets/20-tour_to_ukraine']");

    // Gifts Page

    public static final By LINK_GIFTS = By.xpath("//a[@href='https://romanceabroad.com/store/category-sweets']");

    // How We Work Page

    public static final By LINK_HOW_WE_WORKS = By.xpath("//a[@href='https://romanceabroad.com/content/view/how-it-works']");

    // Photo Page

    public static final By LINK_PHOTOS = By.xpath("//a[@href='https://romanceabroad.com/media/index']");

    // Registration Page

    public static final By BUTTON_REGISTRATION = By.cssSelector("#show-registration-block");
    public static final By TEXT_FIELD_EMAIL = By.cssSelector("input#email");
    public static final By TEXT_FIELD_PASSWORD = By.cssSelector("input#password");
    public static final By BUTTON_NEXT = By.xpath("//button[@data-action='next-page'][text()='Next']");
    public static final By TEXT_FIELD_USERNAME = By.cssSelector("#nickname");
    public static final By TEXT_FIELD_PHONE = By.cssSelector("input[name='data[phone]']");
    // Search Page

    public static final By LINK_PRETTY_WOMAN = By.xpath("//a[@href='https://romanceabroad.com/users/search']");

    // Sigh In Form

    public static final By LINK_SIGN_IN = By.xpath("//a[@href='https://romanceabroad.com/users/login_form']");
    public static final By LINK_LOGIN_EMAIL = By.xpath("//form[@action='https://romanceabroad.com/users/login']//input[@id='email']");
    public static final By LINK_LOGIN_PASSWORD = By.xpath("//form[@action='https://romanceabroad.com/users/login']//input[@id='password']");
    public static final By TITLE_LOGIN = By.xpath("//div[@class='pg-modal']//h1");

    // Blog Page
    public static final By LINK_BLOG = By.xpath("//a[@href='https://romanceabroad.com/content/view/blog']");
}
