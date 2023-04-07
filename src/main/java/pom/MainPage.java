package pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage {

    @FindBy(xpath = "//rz-main-page-sidebar/a[contains(@href,'retail')]")
    private WebElement deliveryPoints;


    public MainPage clickDeliveryPoints() {
        LOGGER.info("Click delivery points");
        deliveryPoints.click();
        return this;
    }
}
