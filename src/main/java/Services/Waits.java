package Services;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Waits {

    private Waits() {}

    public static void waitForProgressBarDisappear() {
        new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(Long.parseLong(PropertyManager.getPropertyValue("explicit_wait"))))
                .until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='preloader' and (@hidden)]")));
    }

    public static void waitForVisibleWebElement(WebElement element) {
        new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(Long.parseLong(PropertyManager.getPropertyValue("explicit_wait"))))
                .until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitForWebElementToBeClickable(WebElement element) {
        new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(Long.parseLong(PropertyManager.getPropertyValue("explicit_wait"))))
                .until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void waitForUrlChanged(String partUrl) {
        new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(Long.parseLong(PropertyManager.getPropertyValue("explicit_wait"))))
                .until(ExpectedConditions.urlContains(partUrl));
    }

    public static void waitTitleContains(String title) {
        new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(Long.parseLong(PropertyManager.getPropertyValue("explicit_wait"))))
                .until(ExpectedConditions.titleContains(title));
    }
}
