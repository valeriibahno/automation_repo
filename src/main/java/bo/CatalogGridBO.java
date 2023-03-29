package bo;

import pom.CatalogGridPage;
import services.Constants;
import org.testng.Assert;

public class CatalogGridBO extends BaseBO {

    private final CatalogGridPage catalogGridPage = new CatalogGridPage();

    public CatalogGridBO selectIconCartItemByPosition(int position) {
        LOGGER.info("Click on icon 'Cart' on the found item in grid with position: " + position);
        catalogGridPage.selectIconCartItemByPosition(position);
        return this;
    }

    public CatalogGridBO clickSortedByExpensive() {
        LOGGER.info("Sort from expensive to cheap'");
        catalogGridPage.clickOnSorting();
        return this;
    }

    public CatalogGridBO verifyHeaderCatalogGrid() {
        LOGGER.info("Verify header of catalog after search");
        Assert.assertEquals(catalogGridPage.getCatalogGridHeader(), Constants.CATEGORY_LAPTOPS, "Wrong category is displayed");
        return this;
    }
}
