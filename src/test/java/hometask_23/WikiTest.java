package hometask_23;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;

public class WikiTest {

    private final static Logger LOGGER = Logger.getLogger(WikiTest.class);
    private WebDriver driver;

    private final By selectEnglish = new By.ByXPath("//a[@lang='en']");
    private final By logIn = new By.ByXPath("//li[@id='pt-login-2']");
    private final By inputUsername = new By.ByXPath("//input[contains(@class,'loginText')]");
    private final By inputPassword = new By.ByXPath("//input[contains(@class,'loginPassword')]");
    private final By checkboxRemember = new By.ByXPath("//input[@id='wpRemember']");
    private final By buttonLogin = new By.ByXPath("//button[@id='wpLoginAttempt']");
    private final By userNameOnPage = new By.ByXPath("//li[@id='pt-userpage-2']");
    private final By inputSearch = new By.ByXPath("//form[@id='searchform']//input[@placeholder='Search Wikipedia']");
    private final By errorMessage = new By.ByXPath("//div[contains(@class,'message-box-error')]");

    private final String userName = "ValeriyB777";
    private final String password = "dfkthfwiki66446";
    private final String userNameWrong = "Valeriy";
    private final String passwordWrong = "wrong";
    private final String searchUkraine = "Ukraine";
    private final String TITLE_ENG = "Wikipedia, the free encyclopedia";
    private final String TITLE_UA = "Вікіпедія";
    private final String SEARCH_UA_TITLE = "Ukraine - Wikipedia";
    private final String ERROR_MESSAGE = "Incorrect username or password entered. Please try again.";

    @BeforeMethod
    void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://uk.wikipedia.org");
    }

    /**
     * 1. Go to https://uk.wikipedia.org/
     * 2. Change language to English
     * 3. Verify that you are on the main page
     * 4. Log in with your credentials and click Remember me checkbox
     * 5. Verify that you are logged in
     */
    @Test
    public void test_1() {

        driver.findElement(selectEnglish).click();

        Assert.assertEquals(driver.getTitle(), TITLE_ENG, "Title on the main page is:");

        driver.findElement(logIn).click();
        driver.findElement(inputUsername).sendKeys(userName);
        driver.findElement(inputPassword).sendKeys(password);
        driver.findElement(checkboxRemember).click();
        driver.findElement(buttonLogin).click();

        String userNameFromPage = driver.findElement(userNameOnPage).getText();

        Assert.assertEquals(userNameFromPage, userName, "UserName is incorrect");

        driver.findElement(inputSearch).sendKeys(searchUkraine);
        driver.findElement(inputSearch).submit();

        Assert.assertEquals(driver.getTitle(), SEARCH_UA_TITLE, "Title on the page is:");
    }

    /**
     * 1. Go to https://uk.wikipedia.org/
     * 2. Verify that you are on the main page
     * 3. Change language to English
     * 4. Log in with wrong credentials
     * 5. Verify that error message is displayed
    */
    @Test
    void test_2() {

        Assert.assertEquals(driver.getTitle(), TITLE_UA, "Error message");
        driver.findElement(selectEnglish).click();

        driver.findElement(logIn).click();
        driver.findElement(inputUsername).sendKeys(userNameWrong);
        driver.findElement(inputPassword).sendKeys(passwordWrong);
        driver.findElement(buttonLogin).click();

        String errorMessageText = driver.findElement(errorMessage).getText();

        Assert.assertEquals(errorMessageText, ERROR_MESSAGE, "Error message is displayed");
    }

    @AfterMethod
    public void screenShotForFailureAndQuit(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            try {
                TakesScreenshot screenshot = (TakesScreenshot) driver;
                File src = screenshot.getScreenshotAs(OutputType.FILE);
                FileUtils.copyFile(src, new File("src\\test\\java\\hometask_23\\screenShots\\" + result.getName() + ".jpg"));
            } catch (Exception e) {
                LOGGER.warn("Exception while taking screenshot " + e.getMessage());
            }
        }
        driver.quit();
    }
}
