package POM;

import Services.Waits;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CartPage extends BasePage {

    @FindBy(xpath = "//h3[@class='modal__heading']")
    private WebElement titleOfCart;

    @FindBy(xpath = "//div[contains(@class,'sum-price')]/span")
    private WebElement priceOfProduct;

    @FindBy(xpath = "//a[@class='cart-product__title']")
    private WebElement titleOfProduct;


    public String getCartHeader() {
        Waits.waitForVisibleWebElement(titleOfCart);
//        explicitWait.until(ExpectedConditions.visibilityOf(titleOfCart));
        return titleOfCart.getText();
    }

    public String getTitleOfProduct() {
        return titleOfProduct.getText();
    }

    public int getPriceOfProduct() {
        return Integer.parseInt(priceOfProduct.getText().replaceAll("\\s+","").replaceAll("₴",""));
    }
}
