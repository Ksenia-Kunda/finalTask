package page.cartPage;

import base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import page.account.MyAccountPage;

import static helper.Locators.get;

/**
 * Created by Ksenia on 06.11.2016.
 */
public class CartCheckPaymentPage extends PageBase {

    private static final By PROCEED_TO_CHECKOUT_ADDRESS = get("CartCheckPaymentPage.ProceedToCheckoutAddress");
    private static final By CONFIRM_ORDER_BUTTON = get("CartCheckPaymentPage.ConfirmOrder");
    private static final By TERMS_OF_SERVICE_CHECKBOX = get("CartCheckPaymentPage.TermsOfService");
    private static final By PROCEED_TO_CHECKOUT = get("CartCheckPaymentPage.ProceedToCheckout");
    private static final By PAY_BY_CHECK_BUTTON = get("CartCheckPaymentPage.PayByCheck");

    public CartCheckPaymentPage(WebDriver driver) {
        super(driver);
    }

    public void proceedToCheckoutButtonAddressClick() {
        driver.findElement(PROCEED_TO_CHECKOUT_ADDRESS).click();
    }

    public void confirmOrderButtonClick() {
        driver.findElement(CONFIRM_ORDER_BUTTON).click();
    }

    public void termsOfServiceCheckBox() {
        driver.findElement(TERMS_OF_SERVICE_CHECKBOX).click();
    }

    public void proceedToCheckoutButtonSoppingClick() {
        driver.findElement(PROCEED_TO_CHECKOUT).click();
    }

    public CartCheckPaymentPage payByCheckButtonClick() {
        driver.findElement(PAY_BY_CHECK_BUTTON).click();
        return new CartCheckPaymentPage(driver);
    }

    public MyAccountPage goToMyAccountPage() {
        getHeader().customerAccountClick();
        return new MyAccountPage(driver);
    }
}
