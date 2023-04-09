package bo;

import io.qameta.allure.Step;
import org.testng.Assert;
import pom.CartPage;
import services.Constants;
import services.ParseText;

public class CartBO {

    private final CartPage cartPage = new CartPage();

    @Step("Verify header of cart")
    public CartBO verifyHeader() {
        Assert.assertEquals(cartPage.getCartHeader(), Constants.CART_TITLE, "Title of Cart is not displayed");
        return this;
    }

    @Step("Verify title of product in cart")
    public CartBO verifyTitleOfProductInCart(String nameOfProduct) {
        Assert.assertEquals(cartPage.getTitleOfProduct(), nameOfProduct, "Name of product is not equal");
        return this;
    }

    @Step("Verify price of selected product is less than max price")
    public CartBO verifyPriceOfProductLessThanMaxPrice(int maxPrice) {
        Assert.assertTrue(ParseText.clearPrice(cartPage.getPriceOfProduct()) < maxPrice, "Price of product is not less than max price of laptop (400000 ₴)");
        return this;
    }
}
