package page.cartPage;

import base.PageBase;
import helper.Waiter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import page.account.SingInPage;

import static helper.Locators.get;

/**
 * Created by Ksenia on 06.11.2016.
 */
public class CartPage extends PageBase {

    private static final By PROCEED_TO_CHECKOUT = get("CartPage.ProceedToCheckout");
    private static final By REMOVE_ITEM = get("CartPage.RemoveItem");
    private static final By CART_IS_EMPTY_CHECK = get("CartPage.CartIsEmpty");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public Boolean proceedToCheckoutButtonIsDisplayed() {
        return driver.findElement(PROCEED_TO_CHECKOUT).isDisplayed();
    }

    public void removeItem() {
        driver.findElement(REMOVE_ITEM).click();
    }

    public Boolean cartIsEmptyCheck() {
        Waiter.getWaiter(driver, 15).until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                driver.navigate().refresh();
                return driver.findElement(CART_IS_EMPTY_CHECK).isDisplayed();
            }
        });
        return driver.findElement(CART_IS_EMPTY_CHECK).isDisplayed();
    }

    public SingInPage proceedToCheckoutButtonClick() {
        driver.findElement(PROCEED_TO_CHECKOUT).click();
        return new SingInPage(driver);
    }
}
