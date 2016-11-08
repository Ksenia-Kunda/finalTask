package page.searchPage;

import base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import page.itemPage.ItemPage;

import java.util.List;

import static helper.Locators.get;

/**
 * Created by Ksenia on 05.11.2016.
 */
public class SearchPage extends PageBase {

    private static final By SEARCH_RESULT = get("SearchPage.SearchItem");
    private static final By MORE_BUTTON = get("SearchPage.QuickView");
    private Actions actions;
    private Boolean b = true;

    public SearchPage(WebDriver driver) {
        super(driver);
        actions = new Actions(driver);
    }

    public Boolean checkSearchResult(String nameOfItem) {
        List<WebElement> elements = driver.findElements(SEARCH_RESULT);

        for (int i = 0; i < elements.size(); i++) {
            actions.moveToElement(driver.findElements(SEARCH_RESULT).get(i)).click(driver.findElements(MORE_BUTTON).get(i)).build().perform();
            ItemPage itemPage = new ItemPage(driver);
            String name = itemPage.getNameOfItem();
            if (elements.size() > 1) {
                itemPage.backToSearch();
            }
            if (!name.contains(nameOfItem)) {
                b = false;
                break;
            }
        }
        return b;
    }

    public ItemPage openMore(int numberOfItem) {
        actions.moveToElement(driver.findElements(SEARCH_RESULT).get(numberOfItem)).click(driver.findElements(MORE_BUTTON).get(numberOfItem)).build().perform();
        return new ItemPage(driver);
    }
}
