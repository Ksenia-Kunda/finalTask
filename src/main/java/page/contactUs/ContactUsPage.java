package page.contactUs;

import base.PageBase;
import helper.DbConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.File;

import static helper.Locators.get;

/**
 * Created by Ksenia on 30.10.2016.
 */
public class ContactUsPage extends PageBase {

    private static final By SUBJECT_HEADING = get("ContactUsPage.SubjectHeading");
    private static final By EMAIL_ADDRESS = get("ContactUsPage.EmailAddress");
    private static final By ORDER_REFERENCE = get("ContactUsPage.OrderReference");
    private static final By ATTACH_FILE = get("ContactUsPage.AttachFile");
    private static final By SEND_BUTTON = get("ContactUsPage.SendButton");
    private static final By INPUT_MASSAGE = get("ContactUsPage.Massage");
    private static final By ERROR_MASSAGE = get("ContactUsPage.ErrorMassage");
    private static final By SUCCESS_MASSAGE = get("ContactUsPage.SuccessMassage");

    public ContactUsPage(WebDriver driver) {
        super(driver);
    }

    public void fillUpSubjectHeading(int choice) {
        Select select = new Select(driver.findElement(SUBJECT_HEADING));
        select.selectByIndex(choice);
    }

    public void fillUpEmail(int randomNumber) {
        driver.findElement(EMAIL_ADDRESS).sendKeys(DbConfig.getValue("db.emailName") + randomNumber + DbConfig.getValue("db.emailDomain"));
    }

    public void fillUpOrderReference(String orderReference) {
        driver.findElement(ORDER_REFERENCE).sendKeys(orderReference);
    }

    public void uploadFile(String filePath) {
        driver.findElement(ATTACH_FILE).sendKeys(new File(filePath).getAbsolutePath());
    }

    public void textMassage(String massage) {
        driver.findElement(INPUT_MASSAGE).sendKeys(massage);
    }

    public void fillAllInputs(int choice, int randomNumber, String orderReference, String filePath) {
        fillUpSubjectHeading(choice);
        fillUpEmail(randomNumber);
        fillUpOrderReference(orderReference);
        uploadFile(filePath);
    }

    public void passSendButtonClick() {
        driver.findElement(SEND_BUTTON).click();
    }

    public void failSendButtonClick() {
        driver.findElement(SEND_BUTTON).click();
    }

    public String getErrorMassage() {
        return driver.findElement(ERROR_MASSAGE).getText();
    }

    public String getPassMassage() {
        return driver.findElement(SUCCESS_MASSAGE).getText();
    }
}
