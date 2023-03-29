package hometask_24_rozetka;

import services.Constants;
import org.testng.Assert;
import org.testng.annotations.Test;
import services.ParseText;

public class RozetkaTest extends BaseTest {

    @Test
    public void verifyPossibilityAddExpensiveLaptopHPInCart() {

        String brandLaptop = "HP";
        int positionItemInGrid = 1;
        String nameOfProduct = "Ноутбук HP ZBook Fury 16 G9 16\" 4K WQUXGA Ts,500n/i9-12950HX (5.0)/128Gb/SSD4Tb/RTX A5500,16GB/WWAN 5G/W11P";

        headerPage
                .clickSearchField()
                .fillSearchField(Constants.CATEGORY_LAPTOPS)
                .clickButtonSubmit();

        Assert.assertEquals(catalogGridPage.getCatalogGridHeader(), Constants.CATEGORY_LAPTOPS, "Wrong category is displayed");

        filtersPage
                .selectSpecificBrand(brandLaptop);

        catalogGridPage
                .clickOnSorting()
                .selectIconCartItemByPosition(positionItemInGrid);

        headerPage
                .clickIconCart();

        Assert.assertEquals(cartPage.getCartHeader(), Constants.CART_TITLE, "Title of Cart is not displayed");
        Assert.assertEquals(cartPage.getTitleOfProduct(), nameOfProduct, "Name of product is not equal");
        Assert.assertTrue( ParseText.clearPrice(cartPage.getPriceOfProduct()) < 400000, "Amount of product is not less 400000");
    }
}
