package pom;

import elements.Title;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import services.Waits;

public class DeliveryPointsPage extends BasePage {

    @FindBy(xpath = "//rz-retail")
    private WebElement mapWithDeliveryPoints;

    @FindBy(xpath = "//section[@id='pickup']/h1")
    private Title titleDeliveryPoints;

    public DeliveryPointsPage selectDeliveryPointsByCity(String city) {

        LOGGER.info("Select delivery point " + city);
        driver.findElement(By.xpath(String.format("//rz-tag-list//a[contains((.),'%s')]", city))).click();
        Waits.waitForVisibleWebElement(mapWithDeliveryPoints);
        return this;
    }

    public String getTitleDeliveryPoints() {
        Waits.waitForVisibleWebElement(titleDeliveryPoints);
        return titleDeliveryPoints.getTitle();
    }
}
