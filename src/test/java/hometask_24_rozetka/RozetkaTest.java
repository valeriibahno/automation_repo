package hometask_24_rozetka;

import Services.Constants;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RozetkaTest extends BaseTest {

    @Test
    public void verifyPossibilityAddExpensiveLaptopHPInCart() {

        String nameOfProduct = "Ноутбук HP ZBook Fury 16 G9 (609M2AV_V1) Silver";

        headerPage
                .clickSearchField()
                .fillSearchField(Constants.CATEGORY_LAPTOPS)
                .clickButtonSubmit();

        Assert.assertEquals(catalogGridPage.getCatalogGridHeader(), Constants.CATEGORY_LAPTOPS, "Wrong category is displayed");

        filtersPage
                .selectHP();

        catalogGridPage
                .clickSortedByExpensive()
                .selectIconCartFirstItemInCategory();

        headerPage
                .clickIconCartWithSelectedProducts();

        Assert.assertEquals(cartPage.getCartHeader(), Constants.CART_TITLE, "Title of Cart is not displayed");
        Assert.assertEquals(cartPage.getTitleOfProduct(), nameOfProduct, "Name of product is not equal");
        Assert.assertTrue( cartPage.getPriceOfProduct() < 400000, "Amount of product is not less 400000");
    }
}
