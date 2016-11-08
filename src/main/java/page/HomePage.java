package page;

import base.PageBase;
import org.openqa.selenium.WebDriver;
import page.contactUs.ContactUsPage;
import page.itemPage.ItemPage;
import page.searchPage.SearchPage;
import page.account.SingInPage;

/**
 * Created by Ksenia on 30.10.2016.
 */
public class HomePage extends PageBase {

    private SearchPage searchPage;

    public HomePage(WebDriver driver) {
        super(driver);
        searchPage = new SearchPage(driver);
    }

    public ContactUsPage goToContactUsPage() {
        getHeader().contactUsClick();
        return new ContactUsPage(driver);
    }

    public SingInPage goToSingInPage() {
        getHeader().singInClick();
        return new SingInPage(driver);
    }

    public SearchPage fillUpSearchInput(String searchingItem) {
        getHeader().searchInput(searchingItem);
        return new SearchPage(driver);
    }

    public SearchPage goToTShortSearchPage() {
        getHeader().WomenTShortButtonClick();
        return new SearchPage(driver);
    }

    public ItemPage chooseItemGoToItemPage(int numberOfItem) {
        return searchPage.openMore(numberOfItem);
    }
}
