import base.TestBase;
import helper.MyListener;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import page.contactUs.ContactUsPage;
import page.HomePage;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.TestCaseId;

/**
 * Created by Ksenia on 30.10.2016.
 */
@Listeners(MyListener.class)
public class ContactUsTest extends TestBase {

    private static final int CUSTOMER_SERVES = 1;
    private static final String ORDER_REFERENCE = "Model demo_3";
    private static final String FILE_PATH = "src\\main\\resources\\uploadingFile.txt";
    private static final String MASSAGE = "Do you have another color of this dress?";
    private static final String EXPECTED_RESULT_E1 = "Your message has been successfully sent to our team.";
    private static final String EXPECTED_RESULT_E2 = "The message cannot be blank.";

    private HomePage homePage;
    private ContactUsPage contactUsPage;

    @BeforeMethod
    public void setup() {
        super.setup();
        homePage = new HomePage(driver);
    }


    @Test
    @TestCaseId("E-1")
    @Features("ContactUs")
    @Stories("Verify that contact us form sends successfully")
    public void passContactUsTest() {
        contactUsPage = homePage.goToContactUsPage();
        contactUsPage.fillAllInputs(CUSTOMER_SERVES, getRandomNumber(), ORDER_REFERENCE, FILE_PATH);
        contactUsPage.textMassage(MASSAGE);
        contactUsPage.passSendButtonClick();
        String actualResult = contactUsPage.getPassMassage();

        Assert.assertEquals(actualResult, EXPECTED_RESULT_E1);
    }

    @Test
    @TestCaseId("E-2")
    @Features("ContactUs")
    @Stories("Verify that error message appears if Message area is empty")
    public void failContactUsTest() {
        contactUsPage = homePage.goToContactUsPage();
        contactUsPage.fillAllInputs(CUSTOMER_SERVES, getRandomNumber(), ORDER_REFERENCE, FILE_PATH);
        contactUsPage.failSendButtonClick();
        String actualResult = contactUsPage.getErrorMassage();

        Assert.assertEquals(actualResult, EXPECTED_RESULT_E2);
    }
}
