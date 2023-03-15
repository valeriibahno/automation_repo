package POM;

import elements.Button;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HeaderPage extends BasePage {

    @FindBy(xpath = "//img[@alt='Rozetka Logo']")
    private WebElement logo;

    @FindBy(xpath = "//input[@name='search']")
    private WebElement searchField;

    @FindBy(xpath = "//button[contains(@class,'submit')]")
    private Button buttonSubmit;

    @FindBy(xpath = "//rz-icon-badge/span")
    private WebElement countInCart;

    @FindBy(xpath = "//rz-cart/button")
    private Button iconCart;

    public boolean isDisplayedLogo() {
        return logo.isDisplayed();
    }

    public HeaderPage clickOnSearchField() {
        LOGGER.info("Click on search field");
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

    public HeaderPage clickIconCartWithSelectedProducts() {     // BO
        if(getCountInCart() > 0) {
            LOGGER.info("Click icon 'Cart'");
            iconCart.click();
        } else {
            LOGGER.warn("Icon 'Cart' with zero value");     // Assert in BO
        }
        return this;
    }
}
