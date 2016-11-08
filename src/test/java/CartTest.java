import base.TestBase;
import helper.MyListener;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import page.HomePage;
import page.account.MyAccountPage;
import page.account.SingInPage;
import page.cartPage.*;
import page.itemPage.ItemPage;
import page.searchPage.SearchPage;
import page.account.OrderHistoryPage;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.TestCaseId;

import static helper.Locators.get;

/**
 * Created by Ksenia on 05.11.2016.
 */
@Listeners(MyListener.class)
public class CartTest extends TestBase {

    private static final String SEARCHING_ITEM = "dresses";
    private static final int NUMBER_OF_ITEM = 1;
    private HomePage homePage;
    private SearchPage searchPage;
    private ItemPage itemPage;
    private CartPage cartPage;
    private SoftAssert softAssert;
    private SingInPage singInPage;
    private CartCheckPaymentPage cartCheckPaymentPage;
    private MyAccountPage myAccountPage;
    private OrderHistoryPage orderHistoryPage;


    @BeforeMethod
    public void setup() {
        super.setup();
        homePage = new HomePage(driver);
        softAssert = new SoftAssert();
    }

    @Test
    @TestCaseId("E-5")
    @Features("Cart")
    @Stories("Verify the ability to add and delete items from cart")
    public void cartTest() {
        searchPage = homePage.fillUpSearchInput(SEARCHING_ITEM);
        itemPage = searchPage.openMore(NUMBER_OF_ITEM);
        itemPage.addToCartButtonClick();
        cartPage = itemPage.proceedToCheckoutClick();
        softAssert.assertTrue(cartPage.proceedToCheckoutButtonIsDisplayed(), "The button proceed to checkout is not displayed in the Cart.");

        cartPage.removeItem();
        softAssert.assertTrue(cartPage.cartIsEmptyCheck(), "The cart is not empty.");

        softAssert.assertAll();
    }

    @Test
    @TestCaseId("E-7")
    @Features("Cart")
    @Stories("Proceed To Checkout")
    public void buyingTest() {
        itemPage = homePage.chooseItemGoToItemPage(NUMBER_OF_ITEM);
        itemPage.addToCartButtonClick();
        cartPage = itemPage.proceedToCheckoutClick();
        singInPage = cartPage.proceedToCheckoutButtonClick();
        singInPage.inputEmail(getRandomNumber());
        singInPage.createAccountButtonClick();
        singInPage.fillAllInputs(getRandomNumber());
        cartCheckPaymentPage = singInPage.registerButtonCartClick();
        cartCheckPaymentPage.proceedToCheckoutButtonAddressClick();
        cartCheckPaymentPage.termsOfServiceCheckBox();
        cartCheckPaymentPage.proceedToCheckoutButtonSoppingClick();
        cartCheckPaymentPage.payByCheckButtonClick();
        cartCheckPaymentPage.confirmOrderButtonClick();
        myAccountPage = cartCheckPaymentPage.goToMyAccountPage();
        orderHistoryPage = myAccountPage.goToOrderHistoryPage();

        Assert.assertTrue(orderHistoryPage.orderListCheck(), "There is no order in the cart.");
    }
}
