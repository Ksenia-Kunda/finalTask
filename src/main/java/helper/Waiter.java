package helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Ksenia on 06.11.2016.
 */
public class Waiter {

    public static WebDriverWait getWaiter(WebDriver driver, int seconds) {
        return new WebDriverWait(driver, seconds);
    }

}
