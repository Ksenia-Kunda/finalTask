package page.account;

import base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static helper.Locators.get;

/**
 * Created by Ksenia on 06.11.2016.
 */
public class OrderHistoryPage extends PageBase {

    private static final By ORDER_LIST = get("OrderHistoryPage.OrderList");

    public OrderHistoryPage(WebDriver driver) {
        super(driver);
    }

    public Boolean orderListCheck() {
        return driver.findElement(ORDER_LIST).isDisplayed();
    }
}
