package POM;

import Services.Waits;
import elements.Button;
import elements.Checkbox;
import elements.Input;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FiltersPage extends HeaderPage {

    @FindBy(xpath = "//a[@data-id='HP']")
    private Checkbox selectBrand;

//    @FindBy(xpath = "//rz-filter-searchline//input")
//    private Input inputSearchBrand;

//    @FindBy(xpath = "//rz-filter-stack")
//    private WebElement allFilters;

    @FindBy(xpath = "//rz-filter-searchline//button[@aria-label='Очистити пошук']")
    private Button buttonClearSearch;

    public FiltersPage selectHP() {
        LOGGER.info("Select brand 'HP' in the filter");
        selectBrand.click();
        //TODO new wait in Waits
        explicitWait.until(ExpectedConditions.titleContains("Ноутбуки HP")); // in Waits
        return this;
    }

//    public FiltersPage fillInputSearchBrand(String brand) {
//        LOGGER.info("Fill brand into search field");
//        explicitWait.until(ExpectedConditions.presenceOfElementLocated(new By.ByXPath("//rz-lazy")));
//        inputSearchBrand.fillInput(buttonClearSearch, brand);
////        explicitWait.until(ExpectedConditions.visibilityOf(selectBrand));
//        return this;
//    }
}
