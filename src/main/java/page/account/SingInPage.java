package page.account;

import base.PageBase;
import helper.DbConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import page.cartPage.CartCheckPaymentPage;

import static helper.Locators.get;

/**
 * Created by Ksenia on 31.10.2016.
 */
public class SingInPage extends PageBase {

    private static final By INPUT_EMAIL = get("SingInPage.InputEmail");
    private static final By CREATE_ACCOUNT_BUTTON = get("SingInPage.CreateAccountButton");
    private static final By SEX_CHOICE = get("SingInPage.Sex");
    private static final By FIRST_NAME = get("SingInPage.FirstName");
    private static final By LAST_NAME = get("SingInPage.LastName");
    private static final By PASSWORD = get("SingInPage.Password");
    private static final By BIRTH_DAY = get("SingInPage.BirthDay");
    private static final By BIRTH_MONTH = get("SingInPage.BirthMouth");
    private static final By BIRTH_YEAR = get("SingInPage.BirthYear");
    private static final By ADDRESS = get("SingInPage.Address");
    private static final By CITY = get("SingInPage.City");
    private static final By STATE = get("SingInPage.State");
    private static final By POST_CODE = get("SingInPage.PostCode");
    private static final By MOBIL_PHONE = get("SingInPage.MobilPhone");
    private static final By REGISTER_BUTTON = get("SingInPage.RegisterButton");

    public SingInPage(WebDriver driver) {
        super(driver);
    }

    public void inputEmail(int randomNumber) {
        driver.findElement(INPUT_EMAIL).sendKeys(DbConfig.getValue("db.emailName") + randomNumber + DbConfig.getValue("db.emailDomain"));
    }

    public void createAccountButtonClick() {
        driver.findElement(CREATE_ACCOUNT_BUTTON).click();
    }

    public void fillAllInputs(int randomNumber) {
        inputSex();
        inputFirstName();
        inputLastName();
        inputPassword(randomNumber);
        inputBirthDay();
        inputBirthMonth();
        inputBirthYear();
        inputAddress();
        inputCity();
        inputState();
        inputPostalCode();
        inputMobilePhone();
    }

    public void inputSex() {
        driver.findElement(SEX_CHOICE).click();
    }

    public void inputFirstName() {
        driver.findElement(FIRST_NAME).sendKeys(DbConfig.getValue("db.firstName"));
    }

    public void inputLastName() {
        driver.findElement(LAST_NAME).sendKeys(DbConfig.getValue("db.lastName"));
    }

    public void inputPassword(int randomNumber) {
        driver.findElement(PASSWORD).sendKeys(DbConfig.getValue("db.password") + randomNumber);
    }

    public void inputBirthDay() {
        Select select = new Select(driver.findElement(BIRTH_DAY));
        select.selectByValue(DbConfig.getValue("db.dayOfBirth"));
    }

    public void inputBirthMonth() {
        Select select = new Select(driver.findElement(BIRTH_MONTH));
        select.selectByValue(DbConfig.getValue("db.monthOfBirth"));
    }

    public void inputBirthYear() {
        Select select = new Select(driver.findElement(BIRTH_YEAR));
        select.selectByValue(DbConfig.getValue("db.yearOfBirth"));
    }

    public void inputAddress() {
        driver.findElement(ADDRESS).sendKeys(DbConfig.getValue("db.address"));
    }

    public void inputCity() {
        driver.findElement(CITY).sendKeys(DbConfig.getValue("db.city"));
    }

    public void inputState() {
        Select select = new Select(driver.findElement(STATE));
        select.selectByValue(DbConfig.getValue("db.state"));
    }

    public void inputPostalCode() {
        driver.findElement(POST_CODE).sendKeys(DbConfig.getValue("db.zip/PostalCode"));
    }

    public void inputMobilePhone() {
        driver.findElement(MOBIL_PHONE).sendKeys(DbConfig.getValue("db.mobilePhone"));
    }

    public MyAccountPage registerButtonMyAccountClick() {
        driver.findElement(REGISTER_BUTTON).click();
        return new MyAccountPage(driver);
    }

    public CartCheckPaymentPage registerButtonCartClick() {
        driver.findElement(REGISTER_BUTTON).click();
        return new CartCheckPaymentPage(driver);
    }
}
