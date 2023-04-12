package bo;

import io.qameta.allure.Step;
import org.testng.Assert;
import pom.CatalogGridPage;
import services.Constants;
import services.Waits;

public class CatalogGridBO extends BaseBO {

    private final CatalogGridPage catalogGridPage = new CatalogGridPage();

    @Step("Select icon cart of the product by position")
    public CatalogGridBO selectIconCartItemByPosition(int position) {
        LOGGER.info("Click on icon 'Cart' on the found item in grid with position: " + position);
        catalogGridPage.selectIconCartItemByPosition(position);
        return this;
    }

    @Step("Click sorting from expensive to cheap")
    public CatalogGridBO clickSortedByExpensive() {
        LOGGER.info("Sort from expensive to cheap'");
        catalogGridPage.clickOnSorting();
        return this;
    }

    @Step("Verify header of catalog grid")
    public CatalogGridBO verifyHeaderCatalogGrid() {
        LOGGER.info("Verify header of catalog after search");
        Waits.waitTitleContains(Constants.CATEGORY_LAPTOPS);
        Assert.assertEquals(catalogGridPage.getCatalogGridHeader(), Constants.CATEGORY_LAPTOPS, "Wrong category is displayed");
        return this;
    }

    @Step("Verify search header of catalog grid")
    public CatalogGridBO verifySearchHeaderCatalogGrid(String title) {
        LOGGER.info("Verify search header of catalog after search");
        Assert.assertEquals(catalogGridPage.getCatalogGridHeader(), String.format("«" + title + "»"), "Wrong category is displayed");
        return this;
    }

    @Step("Verify quantity of selected brands on catalog grid")
    public void verifyQuantitySelectedBrands(int count) {
        LOGGER.info("Verify quantity selected brands: " + count);
         Assert.assertEquals(catalogGridPage.getQuantitySelectedBrands(), count, "Wrong quantity of selected brands is displayed");
    }
}
