package page.itemPage;

import base.PageBase;
import helper.Waiter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import page.cartPage.CartPage;

import static helper.Locators.get;

/**
 * Created by Ksenia on 06.11.2016.
 */
public class ItemPage extends PageBase {

    private String nameOfItem;
    private static final By NAME_OF_ITEM = get("ItemPage.NameOfItem");
    private static final By ADD_TO_CART_BUTTON = get("ItemPage.AddToCart");
    private static final By BOX_INFO_PRODUCT = get("ItemPage.BoxInfoProduct");
    private static final By PROCEED_TO_CHECKOUT = get("ItemPage.ProceedToCheckout");
    private static final By BACK_TO_SEARCH = get("ItemPage.BackToSearch");
    private Actions actions;

    public ItemPage(WebDriver driver) {
        super(driver);
        actions = new Actions(driver);
    }

    public String getNameOfItem() {
        this.nameOfItem = driver.findElement(NAME_OF_ITEM).getText().toLowerCase();
        return nameOfItem;
    }

    public void backToSearch() {
        driver.findElement(BACK_TO_SEARCH).click();
    }

    public void addToCartButtonClick() {
        actions.moveToElement(driver.findElement(BOX_INFO_PRODUCT)).click(driver.findElement(ADD_TO_CART_BUTTON)).build().perform();
    }

    public CartPage proceedToCheckoutClick() {
        Waiter.getWaiter(driver, 15).until(ExpectedConditions.visibilityOf(driver.findElement(PROCEED_TO_CHECKOUT)));
        actions.moveToElement(driver.findElement(PROCEED_TO_CHECKOUT)).click().build().perform();
        return new CartPage(driver);
    }
}
