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
 * Created by Ksenia on 05.11.2016.
 */
@Listeners(MyListener.class)
public class SearchItemTest extends TestBase {

    private static final String SEARCHING_ITEM = "blouse";
    private SearchPage searchPage;
    private HomePage homePage;

    @BeforeMethod
    public void setup() {
        super.setup();
        homePage = new HomePage(driver);
    }

    @Test
    @TestCaseId("E-4")
    @Features("Searching")
    @Stories("Verify the ability to search items")
    public void searchTest() {
        searchPage = homePage.fillUpSearchInput(SEARCHING_ITEM);
        Boolean result = searchPage.checkSearchResult(SEARCHING_ITEM);

        Assert.assertTrue(result, "Found items are not blouses");
    }
}
