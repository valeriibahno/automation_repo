package POM;

import Services.DriverManager;
import Services.PropertyManager;
import elements.Decorator;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {

    protected static final Logger LOGGER = Logger.getLogger(BasePage.class);
    protected WebDriver driver;
    protected WebDriverWait explicitWait;

    public BasePage() {
        driver = DriverManager.getDriver();
//        PageFactory.initElements(driver, this);
        PageFactory.initElements(new Decorator(new DefaultElementLocatorFactory(driver)), this);
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(Long.parseLong(PropertyManager.getPropertyValue("explicit_wait"))));
    }
}
