package bo;

import org.testng.Assert;

public class HeaderBO extends BaseBO {

    public HeaderBO clickIconCartWithSelectedProducts() {
        if(headerPage.getCountInCart() > 0) {
            headerPage.clickIconCart();
        } else {
            Assert.assertTrue(headerPage.getCountInCart() < 0, "Icon 'Cart' with zero value");
        }
        return this;
    }

    public HeaderBO clickUserIcon() {
        headerPage.clickUserIcon();
        return this;
    }

    public HeaderBO clickUserMenu() {
        headerPage.clickButtonUserMenu();
        return this;
    }

    public HeaderBO clickCategoryVacancies() {
        headerPage.clickCategoryVacancies();
        return this;
    }
    
    public HeaderBO clearSearchField() {
        headerPage.clearSearchField();
        return this;
    }
}
