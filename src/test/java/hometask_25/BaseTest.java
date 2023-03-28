package hometask_25;

import BO.CartBO;
import BO.CatalogGridBO;
import BO.FilterBO;
import BO.HeaderBO;
import POM.*;
import Services.DriverManager;
import Services.PropertyManager;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.io.File;

public abstract class BaseTest {

    protected WebDriver driver;
    protected HeaderPage headerPage;
    protected HeaderBO headerBO;
    protected CatalogGridBO catalogGridBO;
    protected FilterBO filterBO;
    protected CartBO cartBO;

    private final static Logger LOGGER = Logger.getLogger(BaseTest.class);

    @BeforeClass
    public void setUp() {
        driver = DriverManager.getDriver();
        headerPage = new HeaderPage();
        headerBO = new HeaderBO();
        catalogGridBO = new CatalogGridBO();
        filterBO = new FilterBO();
        cartBO = new CartBO();
    }

    @BeforeMethod
    public void openBasePage() {
        driver.get(PropertyManager.getPropertyValue("base_url"));
        Assert.assertTrue(headerPage.isDisplayedLogo(), "Logo is not displayed");
    }

    @AfterMethod
    public void screenShotForFailureAndQuit(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            try {
                TakesScreenshot screenshot = (TakesScreenshot) driver;
                File src = screenshot.getScreenshotAs(OutputType.FILE);
                FileUtils.copyFile(src, new File("src\\test\\java\\hometask_25\\failed_tests\\" + result.getName() + ".jpg"));
            } catch (Exception e) {
                LOGGER.warn("Exception while taking screenshot " + e.getMessage());
            }
        }
        DriverManager.quit();
    }
}
