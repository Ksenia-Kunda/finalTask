import base.TestBase;
import helper.MyListener;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import page.HomePage;
import page.searchPage.SearchPage;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.TestCaseId;

/**
 * Created by Ksenia on 06.11.2016.
 */
@Listeners(MyListener.class)
public class CatalogTest extends TestBase {

    private static final String SEARCHING_ITEM = "t-shirt";
    private SearchPage searchPage;
    private HomePage homePage;

    @BeforeMethod
    public void setup() {
        super.setup();
        homePage = new HomePage(driver);
    }

    @Test
    @TestCaseId("E-6")
    @Features("Catalog")
    @Stories("Catalog Test")
    public void catalogTShortTest() {
        searchPage = homePage.goToTShortSearchPage();
        Boolean actualResult = searchPage.checkSearchResult(SEARCHING_ITEM);

        Assert.assertTrue(actualResult, "The item is not displayed");
    }
}
