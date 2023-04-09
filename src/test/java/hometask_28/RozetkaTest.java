package hometask_28;

import com.github.javafaker.Faker;
import io.qameta.allure.*;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import services.AllureListener;
import services.Constants;

import java.util.Arrays;
import java.util.List;

@Epic("Smoke testing of site Rozetka")
@Listeners(AllureListener.class)
@Owner("Valerii Bahno")
public class RozetkaTest extends BaseTest {

    @Test(priority = 1)
    @Story("Searching on site Rozetka")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Smoke test")
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

    @Test(priority = 2)
    @Story("Searching on site Rozetka")
    public void verifySearchingSeveralBrandsLaptop() {

        List<String> listBrands = Arrays.asList("HP", "Acer", "Apple");

        catalogGridBO
                .searchItem(Constants.CATEGORY_LAPTOPS)
                .verifyHeaderCatalogGrid();
        filterBO
                .selectSeveralBrand(listBrands);
        catalogGridBO
                .verifyQuantitySelectedBrands(listBrands.size());
    }

    @Test(priority = 3)
    @Story("Searching on site Rozetka")
    public void verifyTitleBrandInSearchingResult() {

        List<String> listBrands = Arrays.asList("Nokia", "Poco", "Realme");

        for (String brand: listBrands) {
            catalogGridBO
                    .searchItem(brand)
                    .verifySearchHeaderCatalogGrid(brand);
            headerBO
                    .clearSearchField();
        }
    }

    @Test(priority = 4)
    @Story("Login to site Rozetka")
    public void verifyLoginWithWrongEmail() {

        String email = "_te#st123";
        String password = "test1234";

        headerBO
                .clickUserIcon();
        logInBO
                .fillEmailAndPassword(email, password)
                .verifyErrorMessageInvalidEmail();
    }

    @Test(priority = 5)
    @Story("Login to site Rozetka")
    public void verifyErrorWithCaptchaForLogin() {

        String emailFaker = new Faker().internet().emailAddress();
        String passwordFaker = new Faker().internet().password();

        headerBO
                .clickUserIcon();
        logInBO
                .fillEmailAndPassword(emailFaker, passwordFaker)
                .verifyErrorMessageWithCaptcha();
    }

    @Test(priority = 6)
    @Story("Displaying delivery points")
    public void verifyOpenDeliveryPoints() {

        List<String> listCities = Arrays.asList("Дніпро", "Житомир", "Львів for failure");

        mainBO
                .clickDeliveryPoints();
        deliveryPointsBO
                .selectDeliveryPointsByCityAndVerifyTitles(listCities);
    }

    @Test(priority = 7)
    @Story("Searching vacancies")
    public void verifySearchingVacancies() {

        headerBO
                .clickUserMenu()
                .clickCategoryVacancies();
        careersBO
                .verifyTitleCarrierPage()
                .clickButtonShowVacancies()
                .verifyListVacancyExists();
    }
}
