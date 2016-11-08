package base;

import org.openqa.selenium.WebDriver;
import page.part.Header;

/**
 * Created by Ksenia on 30.10.2016.
 */
public abstract class PageBase {

    private final Header HEADER;
    protected WebDriver driver;

    public PageBase(WebDriver driver) {
        this.driver = driver;
        HEADER = new Header(driver);
    }

    public Header getHeader() {
        return HEADER;
    }
}
