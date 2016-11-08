package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by Ksenia on 05.11.2016.
 */
public class TestBase {

    private static final String URL = "http://automationpractice.com/index.php";
    protected static WebDriver driver;

    @BeforeMethod
    public void setup() {
        String browser = System.getProperty("browser") != null ? System.getProperty("browser").toLowerCase() : "firefox";
        switch (browser) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            default:
                driver = new FirefoxDriver();
                break;
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(URL);
    }

    @AfterMethod
    public void teardown() {
        driver.close();
    }

    protected int getRandomNumber() {
        return new Random().nextInt(10000) + 10000;
    }

    public static WebDriver getDriver() {
        return driver;
    }
}

