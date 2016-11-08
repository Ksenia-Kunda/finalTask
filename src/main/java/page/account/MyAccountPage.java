package page.account;

import base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static helper.Locators.get;

/**
 * Created by Ksenia on 07.11.2016.
 */
public class MyAccountPage extends PageBase {

    private static final By MY_ACCOUNT = get("MyAccountPage.AccountPage");
    private static final By ORDER_HISTORY_BUTTON = get("MyAccountPage.OrderHistory");

    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    public Boolean myAccountPageIsDisplayed() {
        return driver.findElement(MY_ACCOUNT).isDisplayed();
    }

    public OrderHistoryPage goToOrderHistoryPage() {
        driver.findElement(ORDER_HISTORY_BUTTON).click();
        return new OrderHistoryPage(driver);
    }
}
