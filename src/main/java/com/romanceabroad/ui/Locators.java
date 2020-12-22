package com.romanceabroad.ui;

import org.openqa.selenium.By;

public class Locators {
    // Main Page

    public static final By FRAME_HOME_PAGE_YOUTUBE = By.xpath("//iframe[@src='https://www.youtube.com/embed/RRECuJzm3IY?start=85']");
    public static final By BUTTON_HOME_PAGE_YOUTUBE = By.xpath("//button[@class='ytp-large-play-button ytp-button']");
    public static final By TITLE_HOME_PAGE = By.xpath("//a[contains(text(),'HOME')]");

    // Tour to Ukraine Page

    public static final By LINK_TOUR_UKRAINE = By.xpath("//a[@href='https://romanceabroad.com/store/sweets/20-tour_to_ukraine']");

    // Gifts Page

    public static final By LINK_GIFTS = By.xpath("//a[@href='https://romanceabroad.com/store/category-sweets']");
    public static final By TEXT_FIELD_SEARCH_PRODUCT = By.xpath("//input[@class='form-control'][@id='search_product']");
    public static final By BUTTON_SEARCH_PRODUCT = By.xpath("//button[@id='search_friend'][@type='submit']");
    public static final By BUTTON_GIFTS = By.xpath("//span[@id='categories'][@class='input-group-addon']");
    public static final By QUICK_VIEW_SPA = By.xpath("//div[@class='quick_view_wrapper'][@id='product_quick_view_2']");
    public static final By QUICK_VIEW_CHOCOLATE_FRUITS = By.xpath("//div[@class='quick_view_wrapper'][@id='product_quick_view_3']");
    public static final By QUICK_VIEW_TEDDY_BEAR = By.xpath("//div[@class='quick_view_wrapper'][@id='product_quick_view_11']");
    public static final By QUICK_VIEW_FLOWER_BASKET = By.xpath("//div[@class='quick_view_wrapper'][@id='product_quick_view_12']");
    public static final By QUICK_VIEW_SUSHI_SETS = By.xpath("//div[@class='quick_view_wrapper'][@id='product_quick_view_16']");
    public static final By QUICK_VIEW_TOUR_TO_UKRAINE = By.xpath("//div[@class='quick_view_wrapper'][@id='product_quick_view_20']");


    // How It Works Page

    public static final By LINK_HOW_WE_WORKS = By.xpath("//a[@href='https://romanceabroad.com/content/view/how-it-works']");
    public static final By BLOGS_PAGES = By.xpath("//li//div[@class='fleft']");

    // Photo Page

    public static final By LINK_PHOTOS = By.xpath("//a[@href='https://romanceabroad.com/media/index']");
    public static final By LINK_TAB_USER_PROFILE = By.xpath("//ul[@id='gallery_filters']//a");
    public static final By SELECT_PHOTOS = By.xpath("//span[@id='gallery_media_sorter']//select");
    public static final By BUTTON_PHOTO = By.xpath("//li[@data-param='photo']//a");
    public static final By BUTTON_VIDEO = By.xpath("//li[@data-param='video']//a");
    public static final By BUTTON_ALBUMS = By.xpath("//li[@data-param='albums']//a");
    public static final By BUTTON_ADD_PHOTOS = By.xpath("//button[contains(text(), 'Add photo')]");
    public static final By SORT_BY_DATE =  By.xpath("//select[@class='form-control']//option[@value='date_add']");
    public static final By SORT_BY_VIEWS =  By.xpath("//select[@class='form-control']//option[@value='views']");
    public static final By SORT_BY_COMMENTS =  By.xpath("//select[@class='form-control']//option[@value='comments_counts']");
    public static final By SORT_LOWEST_HIGHEST = By.xpath("//span[@id='gallery_media_sorter'][@class='form-group ']//i[@data-role='sorter-dir']");

    // Registration Page

    public static final By BUTTON_REGISTRATION = By.cssSelector("#show-registration-block");
    public static final By TEXT_FIELD_EMAIL = By.cssSelector("input#email");
    public static final By TEXT_FIELD_PASSWORD = By.cssSelector("input#password");
    public static final By BUTTON_NEXT = By.xpath("//button[@data-action='next-page'][text()='Next']");
    public static final By TOOLTIP_ERROR=  By.xpath("//div[@class='tooltip']");
    public static final By TEXT_FIELD_USERNAME = By.cssSelector("#nickname");
    public static final By BUTTON_DAY_SELECT = By.cssSelector("div#daySelect");
    public static final By LIST_VALUE_DAY = By.xpath("//li[@data-handler='selectDay']");
    public static final By BUTTON_MONTH_SELECT = By.cssSelector("div#monthSelect");
    public static final By LIST_VALUE_MONTH = By.xpath("//li[@data-handler='selectMonth']");
    public static final By BUTTON_YEAR_SELECT = By.cssSelector("div#yearSelect");
    public static final By LIST_VALUE_YEAR = By.xpath("//li[@data-handler='selectYear']");
    public static final By TEXT_FIELD_PHONE = By.cssSelector("input[name='data[phone]']");
    public static final By CHECKBOX_CONFIRMATION = By.cssSelector("input#confirmation");
    public static final By LIST_VALUE_LOCATION = By.xpath("//div[@class='dropdown dropdown_location']//ul/li");
    public static final By AUTO_FILLING_FORM_LOCATION = By.xpath("//input[@name='region_name']");

    // Pretty Women Page

    public static final By LINK_PRETTY_WOMAN = By.xpath("//a[@href='https://romanceabroad.com/users/search']");
    public static final By TABLE_AGE_MIN_MAX = By.xpath("//div[@class='search-box advanced']");
    public static final By FILTER_MAX_AGE = By.cssSelector("select#age_max");
    public static final By FILTER_MIN_AGE = By.cssSelector("select#age_min");
    public static final By FILTER_SORT_BY = By.xpath("//div[@class='form-inline']//select");
    public static final By TEXT_FIELD_PRETTY_WOMEN_SEARCH = By.xpath("//input[@value='Search']");
    public static final By BUTTON_SEARCH = By.cssSelector("#main_search_button_user_advanced");
    public static final By THIRD_PAGE_PRETTY_WOMEN = By.xpath("//div[@id='pages_block_2']//a[@data-page='3']");
    public static final By TEXT_USER_INFO = By.xpath("//div[@class='text-overflow']");

    // Sigh In Form

    public static final By LINK_SIGN_IN = By.xpath("//a[@href='https://romanceabroad.com/users/login_form']");
    public static final By LINK_LOGIN_EMAIL = By.xpath("//form[@action='https://romanceabroad.com/users/login']//input[@id='email']");
    public static final By LINK_LOGIN_PASSWORD = By.xpath("//form[@action='https://romanceabroad.com/users/login']//input[@id='password']");
    public static final By TITLE_LOGIN = By.xpath("//div[@class='pg-modal']//h1");

    // Blog Page

    public static final By LINK_BLOG = By.xpath("//a[@href='https://romanceabroad.com/content/view/blog']");
    public static final By BLOGS_BLOG_PAGE = By.xpath("//div[@class='info-content-block wysiwyg']//ul//li/a");

    // Contact Us

    public static final By LINK_CONTACT_US_PAGE = By.xpath("//li/a[@id='footer_footer-menu-help-item_footer-menu-tickets-item']/div");
    public static final By SELECT_REASON = By.xpath("//select[@name='id_reason']");
    public static final By TEXT_FIELD_USER_NAME = By.xpath("//input[@name='user_name']");
    public static final By TEXT_FIELD_USER_EMAIL = By.xpath("//input[@name='user_email']");
    public static final By TEXT_FIELD_USER_SUBJECT = By.xpath("//input[@name='subject']");
    public static final By TEXT_FIELD_USER_MESSAGE = By.xpath("//textarea[@name='message']");

    // Titles
    public static final By H1_TITLE = By.xpath("//h1");
    public static final By TAB_OF_MAIN_PAGE = By.xpath("//ul[@class='navbar-nav']//li");
    public static final By IMAGES = By.xpath("//a[@class='g-pic-border g-rounded']");
}
