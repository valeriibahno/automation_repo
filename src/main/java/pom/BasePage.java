package pom;

import elements.Decorator;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import services.DriverManager;

public abstract class BasePage {

    protected static final Logger LOGGER = Logger.getLogger(BasePage.class);
    protected WebDriver driver;

    public BasePage() {
        driver = DriverManager.getDriver();
        PageFactory.initElements(new Decorator(new DefaultElementLocatorFactory(driver)), this);
    }
}
