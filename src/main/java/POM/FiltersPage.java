package POM;

import Services.Waits;
import org.openqa.selenium.By;

public class FiltersPage extends HeaderPage {

    public FiltersPage selectSpecificBrand(String brand) {
        LOGGER.info("Select brand '" + brand + "' in the filter");
        driver.findElement(By.xpath(String.format("//a[@data-id='%s']", brand))).click();
        Waits.waitTitleContains("Ноутбуки " + brand);
        return this;
    }
}
