package bo;

import io.qameta.allure.Step;
import org.testng.Assert;

public class HeaderBO extends BaseBO {

    @Step("Click icon cart with selected product")
    public HeaderBO clickIconCartWithSelectedProduct() {
        if(headerPage.getCountInCart() > 0) {
            headerPage.clickIconCart();
        } else {
            Assert.assertTrue(headerPage.getCountInCart() < 0, "Icon 'Cart' with zero value");
        }
        return this;
    }

    @Step("Click user icon")
    public HeaderBO clickUserIcon() {
        headerPage.clickUserIcon();
        return this;
    }

    @Step("Click user menu")
    public HeaderBO clickUserMenu() {
        headerPage.clickButtonUserMenu();
        return this;
    }

    @Step("Click category vacancies")
    public HeaderBO clickCategoryVacancies() {
        headerPage.clickCategoryVacancies();
        return this;
    }

    @Step("Clear search field")
    public HeaderBO clearSearchField() {
        headerPage.clearSearchField();
        return this;
    }
}
