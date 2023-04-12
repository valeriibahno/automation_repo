package pom;

import elements.Title;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import services.Constants;
import services.DriverManager;
import services.Waits;

import java.util.List;

public class CatalogGridPage extends HeaderPage {

    @FindBy(xpath = "//h1[contains(@class,'catalog-heading')]")
    private Title catalogHeader;

    @FindBy(xpath = "//rz-sort/select")
    private WebElement filterSort;

    @FindBy(xpath = "//rz-sort[@class='catalog-settings__sorting']/select")
    private WebElement dropDownSorting;

    @FindBy(xpath = "//rz-sort[@class='catalog-settings__sorting']//option[contains(normalize-space(.),'Від дорогих до дешевих')]")
    private WebElement sortFromExpensiveToCheap;

    @FindBy(xpath = "//button[contains(@class,'buy-button')]")
    private List<WebElement> listIconCartFoundProducts;

    @FindBy(xpath = "//a[@class='catalog-selection__link']")
    private List<WebElement> listSelectedBrands;

    @FindBy(xpath = "//rz-filter-searchline")
    private WebElement searchFieldByBrand;

    public String getCatalogGridHeader() {
        String title = null;
        if(DriverManager.getDriver().getPageSource().contains(Constants.CATEGORY_LAPTOPS)) {
            Waits.waitForProgressBarDisappear();
            Waits.waitForWebElementToBeClickable(searchFieldByBrand);
            title = catalogHeader.getTitle();
        }
        return title;
    }

    public int getQuantitySelectedBrands() {
        return listSelectedBrands.size();
    }

    public CatalogGridPage clickOnSorting() {
        LOGGER.info("Click filter 'Sorting by' and select by 'From expensive to cheap'");
        Waits.waitForWebElementToBeClickable(filterSort);
        dropDownSorting.click();
        Waits.waitForWebElementToBeClickable(sortFromExpensiveToCheap);
        sortFromExpensiveToCheap.click();
        Waits.waitForUrlChanged("sort=expensive");
        return this;
    }

    public CatalogGridPage selectIconCartItemByPosition(int position) {
        LOGGER.info("Click on icon 'Cart' on the found item in grid");
        listIconCartFoundProducts.get(position - 1).click();
        return this;
    }
}
