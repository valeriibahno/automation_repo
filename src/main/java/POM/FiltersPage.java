package POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FiltersPage extends HeaderPage {

    @FindBy(xpath = "//a[@data-id='HP']")
    private WebElement selectBrand;

    @FindBy(xpath = "//rz-filter-stack")
    private WebElement allFilters;

    public FiltersPage selectHP() {
        LOGGER.info("Select brand 'HP' in the filter");
        explicitWait.until(ExpectedConditions.visibilityOf(allFilters));
        selectBrand.click();
        explicitWait.until(ExpectedConditions.titleContains("Ноутбуки HP"));
        return this;
    }
}
