package pom;

import elements.Title;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
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

    public String getCatalogGridHeader() {
        return catalogHeader.getTitle();
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
