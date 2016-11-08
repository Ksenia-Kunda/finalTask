package page.part;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import static helper.Locators.get;

/**
 * Created by Ksenia on 30.10.2016.
 */
public class Header {

    private static final By CONTACT_US = get("Header.ContactUs");
    private static final By SING_IN = get("Header.SingIn");
    private static final By SEARCH_INPUT = get("Header.SearchInput");
    private static final By SEARCH_BUTTON = get("Header.SearchButton");
    private static final By CUSTOMER_ACCOUNT_BUTTON = get("Header.CustomerAccountButton");
    private static final By WOMEN_BUTTON = get("Header.WomenButton");
    private static final By HIDDEN_TSHORT_BUTTON = get("Header.HiddenTShorts");
    private Actions actions;

    private WebDriver driver;

    public Header(WebDriver driver) {
        this.driver = driver;
        this.actions = new Actions(driver);
    }

    public void contactUsClick() {
        driver.findElement(CONTACT_US).click();
    }

    public void singInClick() {
        driver.findElement(SING_IN).click();
    }

    public void searchInput(String searchingItem) {
        driver.findElement(SEARCH_INPUT).sendKeys(searchingItem);
        driver.findElement(SEARCH_BUTTON).click();
    }

    public void customerAccountClick() {
        driver.findElement(CUSTOMER_ACCOUNT_BUTTON).click();
    }

    public void WomenTShortButtonClick() {
        actions.moveToElement(driver.findElement(WOMEN_BUTTON)).perform();
        driver.findElement(HIDDEN_TSHORT_BUTTON).click();
    }
}
