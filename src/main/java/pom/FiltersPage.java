package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import services.Waits;

public class FiltersPage extends HeaderPage {

    @FindBy(xpath = "//rz-filter-stack")
    private WebElement filterBrands;

    public FiltersPage selectSpecificBrand(String brand) {
        LOGGER.info("Select brand '" + brand + "' in the filter");
        Waits.waitForProgressBarDisappear();
        driver.findElement(By.xpath(String.format("//a[@data-id='%s']", brand))).click();
        Waits.waitForProgressBarDisappear();
        return this;
    }
}
