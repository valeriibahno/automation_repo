package BO;

import POM.CatalogGridPage;
import Services.Constants;
import Services.Waits;
import org.testng.Assert;

public class CatalogGridBO extends BaseBO {

    private final CatalogGridPage catalogGridPage = new CatalogGridPage();

//    public CatalogGridBO clickSortedByType(String type) throws NoSuchFieldException {
//        LOGGER.info("Click filter 'Sorting by' and select by " + type);
//        Waits.waitForWebElementToBeClickable(catalogGridPage.getElementOnPage("filterSort"));
//        catalogGridPage.clickSortedByExpensive();
//
//        return this;
//    }

    public CatalogGridBO verifyHeaderCatalogGrid() {
        LOGGER.info("Verify header of catalog after searching");
        Assert.assertEquals(catalogGridPage.getCatalogGridHeader(), Constants.CATEGORY_LAPTOPS, "Wrong category is displayed");
        return this;
    }
}
