package hometask_25;

import org.testng.annotations.Test;
import services.Constants;

public class RozetkaTest extends BaseTest {

    @Test
    public void verifyPossibilityAddExpensiveLaptopHPInCart() {

        String nameOfProduct = "Ноутбук HP ZBook Fury 16 G9 16\" 4K WQUXGA Ts,500n/i9-12950HX (5.0)/128Gb/SSD4Tb/RTX A5500,16GB/WWAN 5G/W11P";
        String brandLaptop = "HP";
        int positionItemInGrid = 1;

        catalogGridBO
                .searchItem(Constants.CATEGORY_LAPTOPS)
                .verifyHeaderCatalogGrid();
        filterBO
                .selectBrand(brandLaptop);
        catalogGridBO
                .clickSortedByExpensive()
                .selectIconCartItemByPosition(positionItemInGrid);
        headerBO
                .clickIconCartWithSelectedProduct();
        cartBO
                .verifyHeader()
                .verifyTitleOfProductInCart(nameOfProduct)
                .verifyPriceOfProductLessThanMaxPrice(Constants.MAX_PRICE_LAPTOP);
    }
}
