package pom;

import elements.Button;
import elements.Input;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HeaderPage extends BasePage {

    @FindBy(xpath = "//img[@alt='Rozetka Logo']")
    private WebElement logo;

    @FindBy(xpath = "//input[@name='search']")
    private Input searchField;

    @FindBy(xpath = "//button[contains(@class,'submit')]")
    private Button buttonSubmit;

    @FindBy(xpath = "//rz-icon-badge/span")
    private WebElement countInCart;

    @FindBy(xpath = "//rz-cart/button")
    private Button iconCart;

    @FindBy(xpath = "//rz-user")
    private Button userIcon;

    @FindBy(xpath = "//rz-mobile-user-menu")
    private Button buttonUserMenu;

    @FindBy(xpath = "//a[@class='ng-tns-c63-2' and contains((.),'Вакансії')]")
    private WebElement categoryVacancies;

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
        searchField.fillInput(searchField, text);
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

    public HeaderPage clickIconCart() {
        LOGGER.info("Click icon 'Cart'");
        iconCart.click();
        return this;
    }

    public HeaderPage clickUserIcon() {
        LOGGER.info("Click on user icon");
        userIcon.click();
        return this;
    }

    public HeaderPage clickButtonUserMenu() {
        LOGGER.info("Click button Menu");
        buttonUserMenu.click();
        return this;
    }

    public HeaderPage clickCategoryVacancies() {
        LOGGER.info("Click category vacancies");
        categoryVacancies.click();
        return this;
    }

    public HeaderPage clearSearchField() {
        LOGGER.info("Clear search field");
        searchField.clear();
        return this;
    }
}
