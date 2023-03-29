package POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class CatalogGridPage extends HeaderPage {

    @FindBy(xpath = "//h1[contains(@class,'catalog-heading')]")
    private WebElement catalogHeader;

    @FindBy(xpath = "//rz-sort/select")
    private WebElement filterSort;

    @FindBy(xpath = "//rz-sort[@class='catalog-settings__sorting']/select")
    private WebElement dropDownSorting;

    @FindBy(xpath = "//rz-sort[@class='catalog-settings__sorting']//option[contains(normalize-space(.),'Від дорогих до дешевих')]")
    private WebElement sortFromExpensiveToCheap;

    @FindBy(xpath = "//button[contains(@class,'buy-button')]")
    private List<WebElement> listIconCartFoundProducts;

    public String getCatalogGridHeader() {
        return catalogHeader.getText();
    }

    public CatalogGridPage clickSortedByExpensive() {
        LOGGER.info("Click filter 'Sorting by' and select by 'From expensive to cheap'");
        explicitWait.until(ExpectedConditions.elementToBeClickable(filterSort));
        dropDownSorting.click();
        explicitWait.until(ExpectedConditions.elementToBeClickable(sortFromExpensiveToCheap));
        sortFromExpensiveToCheap.click();
        explicitWait.until(ExpectedConditions.urlContains("sort=expensive"));
        return this;
    }

    public CatalogGridPage selectIconCartFirstItemInCategory() {
        LOGGER.info("Click on icon 'Cart' in the first found item in grid");
        listIconCartFoundProducts.get(0).click();
        return this;
    }
}
