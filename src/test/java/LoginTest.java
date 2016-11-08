import base.TestBase;
import helper.MyListener;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import page.HomePage;
import page.account.MyAccountPage;
import page.account.SingInPage;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.TestCaseId;

/**
 * Created by Ksenia on 30.10.2016.
 */
@Listeners(MyListener.class)
public class LoginTest extends TestBase {

    private int randomNumber;
    private HomePage homePage;
    private SingInPage singInPage;
    private MyAccountPage myAccountPage;

    @BeforeMethod
    public void setup() {
        super.setup();
        homePage = new HomePage(driver);
        this.randomNumber = super.getRandomNumber();
    }

    @Test
    @TestCaseId("E-3")
    @Features("Login")
    @Stories("Verify the ability to register")
    public void singInTest() {
        singInPage = homePage.goToSingInPage();
        singInPage.inputEmail(randomNumber);
        singInPage.createAccountButtonClick();
        singInPage.fillAllInputs(getRandomNumber());
        myAccountPage = singInPage.registerButtonMyAccountClick();

        Assert.assertTrue(myAccountPage.myAccountPageIsDisplayed(), "Page My account isn't visible");
    }
}
