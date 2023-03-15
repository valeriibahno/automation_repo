package hometask_25;

import Services.Constants;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RozetkaTest extends BaseTest {

    @Test
    public void verifyPossibilityAddExpensiveLaptopHPInCart() {

//        String nameOfProduct = "Ноутбук HP ZBook Fury 16 G9 (609M2AV_V1) Silver";
        String nameOfProduct = "Ноутбук HP ZBook Fury 16 G9 16\" 4K WQUXGA Ts,500n/i9-12950HX (5.0)/128Gb/SSD4Tb/RTX A5500,16GB/WWAN 5G/W11P";
        String brand = "HP";

        catalogGridBO
                .searchItem(Constants.CATEGORY_LAPTOPS)
                .verifyHeaderCatalogGrid();

//        headerPage
//                .clickOnSearchField()
//                .fillSearchField(Constants.CATEGORY_LAPTOPS)
//                .clickButtonSubmit();
//
//        catalogGridBO
//                .verifyHeaderCatalogGrid();
//
//        Assert.assertEquals(catalogGridPage.getCatalogGridHeader(), Constants.CATEGORY_LAPTOPS, "Wrong category is displayed");

        filterBO
                .searchAndSelectBrand(brand);
//        filtersPage
//                .selectHP()
//                .selectStatusProduct();

        catalogGridPage                                                 // ???
                .clickSortedByExpensive()
                .selectIconCartFirstItemInCategory();

        headerPage                                                      // ???  create HeaderBO
                .clickIconCartWithSelectedProducts();

        cartBO
                .verifyHeader()
                .verifyTitleOfProductInCart(nameOfProduct)
                .verifyPriceOfProductLessThanMaxPrice(Constants.MAX_PRICE_LAPTOP);

//        Assert.assertEquals(cartPage.getCartHeader(), Constants.CART_TITLE, "Title of Cart is not displayed");
//        Assert.assertEquals(cartPage.getTitleOfProduct(), nameOfProduct, "Name of product is not equal");
//        Assert.assertTrue( cartPage.getPriceOfProduct() < Constants.MAX_PRICE_LAPTOP, "Amount of product is not less than max price of laptop (400000 ₴)");
    }
}
