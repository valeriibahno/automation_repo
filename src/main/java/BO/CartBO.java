package BO;

import POM.CartPage;
import Services.Constants;
import org.testng.Assert;

public class CartBO {

    private final CartPage cartPage = new CartPage();

    public CartBO verifyHeader() {
        Assert.assertEquals(cartPage.getCartHeader(), Constants.CART_TITLE, "Title of Cart is not displayed");
        return this;
    }

    public CartBO verifyTitleOfProductInCart(String nameOfProduct) {
        Assert.assertEquals(cartPage.getTitleOfProduct(), nameOfProduct, "Name of product is not equal");
        return this;
    }

    public CartBO verifyPriceOfProductLessThanMaxPrice(int maxPrice) {
        Assert.assertTrue( cartPage.getPriceOfProduct() < maxPrice, "Price of product is not less than max price of laptop (400000 ₴)");
        return this;
    }
}
