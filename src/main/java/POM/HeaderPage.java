package POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HeaderPage extends BasePage {

    @FindBy(xpath = "//img[@alt='Rozetka Logo']")
    private WebElement logo;

    @FindBy(xpath = "//input[@name='search']")
    private WebElement searchField;

    @FindBy(xpath = "//button[contains(@class,'submit')]")
    private WebElement buttonSubmit;

    @FindBy(xpath = "//rz-icon-badge/span")
    private WebElement countInCart;

    @FindBy(xpath = "//rz-cart/button")
    private WebElement iconCart;

    public boolean isDisplayedLogo() {
        return logo.isDisplayed();
    }

    public HeaderPage clickSearchField() {
        LOGGER.info("Click into search field");
        searchField.click();
        return this;
    }

    public HeaderPage fillSearchField(String text) {
        LOGGER.info("Fill text for searching");
        searchField.sendKeys(text);
        return this;
    }

    public HeaderPage clickButtonSubmit() {
        LOGGER.info("Click on the button 'Submit' for search");
        buttonSubmit.click();
        return this;
    }

    public int getCountInCart() {
        return Integer.parseInt(countInCart.getText());
    }

    public HeaderPage clickIconCartWithSelectedProducts() {
        if(getCountInCart() > 0) {
            LOGGER.info("Click icon 'Cart'");
            iconCart.click();
        } else {
            LOGGER.warn("Icon 'Cart' with zero value");
        }
        return this;
    }
}
