package pom;

import services.Waits;
import elements.Title;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage {

    @FindBy(xpath = "//h3[@class='modal__heading']")
    private Title titleOfCart;

    @FindBy(xpath = "//a[@class='cart-product__title']")
    private Title titleOfProduct;

    @FindBy(xpath = "//div[contains(@class,'sum-price')]/span")
    private WebElement priceOfProduct;

    public String getCartHeader() {
        Waits.waitForVisibleWebElement(titleOfCart);
        return titleOfCart.getTitle();
    }

    public String getTitleOfProduct() {
        return titleOfProduct.getText();
    }

    public String getPriceOfProduct() {
        return priceOfProduct.getText();
    }
}
