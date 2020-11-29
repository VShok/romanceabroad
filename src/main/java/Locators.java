import org.openqa.selenium.By;

public class Locators {
    // Main Page

    public static final By FRAME_HOME_PAGE_YOUTUBE = By.xpath("//iframe[@src='https://www.youtube.com/embed/RRECuJzm3IY?start=85']");
    public static final By BUTTON_HOME_PAGE_YOUTUBE = By.xpath("//button[@class='ytp-large-play-button ytp-button']");

    // Tour to Ukraine Page

    public static final By LINK_TOUR_UKRAINE = By.xpath("//a[@href='https://romanceabroad.com/store/sweets/20-tour_to_ukraine']");

    // Gifts Page

    public static final By LINK_GIFTS = By.xpath("//a[@href='https://romanceabroad.com/store/category-sweets']");

    // How It Works Page

    public static final By LINK_HOW_WE_WORKS = By.xpath("//a[@href='https://romanceabroad.com/content/view/how-it-works']");
    public static final By BLOGS_PAGES = By.xpath("//li//div[@class='fleft']");

    // Photo Page

    public static final By LINK_PHOTOS = By.xpath("//a[@href='https://romanceabroad.com/media/index']");
    public static final By BUTTON_ADD_PHOTOS = By.xpath("//button[contains(text(), 'Add photo')]");

    // Registration Page

    public static final By BUTTON_REGISTRATION = By.cssSelector("#show-registration-block");
    public static final By TEXT_FIELD_EMAIL = By.cssSelector("input#email");
    public static final By TEXT_FIELD_PASSWORD = By.cssSelector("input#password");
    public static final By BUTTON_NEXT = By.xpath("//button[@data-action='next-page'][text()='Next']");
    public static final By TEXT_FIELD_USERNAME = By.cssSelector("#nickname");
    public static final By BUTTON_DAY_SELECT = By.cssSelector("div#daySelect");
    public static final By SIXTH_DAY_SELECT = By.xpath("//li[@data-handler='selectDay']//a[@data-value='6']");
    public static final By BUTTON_MONTH_SELECT = By.cssSelector("div#monthSelect");
    public static final By JUNE_MONTH_SELECT = By.xpath("//li[@data-handler='selectMonth']//a[@data-value='5']");
    public static final By BUTTON_YEAR_SELECT = By.cssSelector("div#yearSelect");
    public static final By NINETEEN_EIGHTY_NINE_YEAR_SELECT = By.xpath("//li[@data-handler='selectYear']//a[@data-value='1989']");
    public static final By TEXT_FIELD_PHONE = By.cssSelector("input[name='data[phone]']");
    public static final By BUTTON_CONFIRMATION = By.cssSelector("input#confirmation");

    // Pretty Women Page

    public static final By LINK_PRETTY_WOMAN = By.xpath("//a[@href='https://romanceabroad.com/users/search']");
    public static final By TABLE_AGE_MIN_MAX = By.xpath("//div[@class='search-box advanced']");
    public static final By FILTER_MAX_AGE = By.xpath("//select[@id='age_max']");
    public static final By TEXT_FIELD_PRETTY_WOMEN_SEARCH = By.xpath("//input[@value='Search']") ;

    // Sigh In Form

    public static final By LINK_SIGN_IN = By.xpath("//a[@href='https://romanceabroad.com/users/login_form']");
    public static final By LINK_LOGIN_EMAIL = By.xpath("//form[@action='https://romanceabroad.com/users/login']//input[@id='email']");
    public static final By LINK_LOGIN_PASSWORD = By.xpath("//form[@action='https://romanceabroad.com/users/login']//input[@id='password']");
    public static final By TITLE_LOGIN = By.xpath("//div[@class='pg-modal']//h1");

    // Blog Page

    public static final By LINK_BLOG = By.xpath("//a[@href='https://romanceabroad.com/content/view/blog']");
    public static final By BLOGS_BLOG_PAGE = By.xpath("//div[@class='info-content-block wysiwyg']//ul//li/a");

    //Titles
    public static final By CURRENT_TITLE = By.xpath("//h1");
    public static final By TAB_OF_MAIN_PAGE = By.xpath("//ul[@class='navbar-nav']//li");
    public static final By IMAGES = By.xpath("//a[@class='g-pic-border g-rounded']");
}
