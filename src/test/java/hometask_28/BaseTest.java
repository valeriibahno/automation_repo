package hometask_28;

import bo.*;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pom.HeaderPage;
import services.DriverManager;
import services.PropertyManager;

import java.io.File;

public class BaseTest {

    protected WebDriver driver;
    protected HeaderPage headerPage;
    protected HeaderBO headerBO;
    protected CatalogGridBO catalogGridBO;
    protected FilterBO filterBO;
    protected CartBO cartBO;
    protected LogInBO logInBO;
    protected MainBO mainBO;
    protected DeliveryPointsBO deliveryPointsBO;
    protected CareersBO careersBO;

    private final static Logger LOGGER = Logger.getLogger(BaseTest.class);

    @BeforeMethod
    public void setUp() {
        driver = DriverManager.getDriver();
        headerPage = new HeaderPage();
        headerBO = new HeaderBO();
        catalogGridBO = new CatalogGridBO();
        filterBO = new FilterBO();
        cartBO = new CartBO();
        logInBO = new LogInBO();
        mainBO = new MainBO();
        deliveryPointsBO = new DeliveryPointsBO();
        careersBO = new CareersBO();

        driver.get(PropertyManager.getPropertyValue("base_url"));
        Assert.assertTrue(headerPage.isDisplayedLogo(), "Logo is not displayed");
    }

    @AfterMethod
    public void screenShotForFailure(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            try {
                TakesScreenshot screenshot = (TakesScreenshot) driver;
                File src = screenshot.getScreenshotAs(OutputType.FILE);
                FileUtils.copyFile(src, new File("src\\test\\java\\hometask_28\\failed_tests\\" + result.getName() + ".jpg"));
            } catch (Exception e) {
                LOGGER.warn("Exception while taking screenshot " + e.getMessage());
            }
        }
    }

    @AfterClass
    public void closeBrowser() {
        DriverManager.quit();
    }
}
