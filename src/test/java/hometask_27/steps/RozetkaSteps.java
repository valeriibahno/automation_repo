package hometask_27.steps;

import bo.*;
import com.github.javafaker.Faker;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import services.Constants;
import services.DriverManager;
import services.PropertyManager;

import java.util.List;

public class RozetkaSteps {

    private WebDriver driver;

    private CatalogGridBO catalogGridBO;
    private FilterBO filterBO;
    private HeaderBO headerBO;
    private CartBO cartBO;
    private LogInBO logInBO;
    private MainBO mainBO;
    private DeliveryPointsBO deliveryPointsBO;
    private CareersBO careersBO;

    @Before
    public void setUp() {
        catalogGridBO = new CatalogGridBO();
        filterBO = new FilterBO();
        headerBO = new HeaderBO();
        cartBO = new CartBO();
        logInBO = new LogInBO();
        mainBO = new MainBO();
        deliveryPointsBO = new DeliveryPointsBO();
        careersBO = new CareersBO();

        driver = DriverManager.getDriver();
    }

    @AfterAll
    public static void closeBrowser() {
        System.out.println("After hook");
        DriverManager.quit();
    }

    @Given("Open web-site Rozetka")
    public void openWebSiteRozetka() {
        driver.get(PropertyManager.getPropertyValue("base_url"));
    }

    @When("I search several brands of laptop")
    public void iSearchSeveralBrandsLaptop(List<String> listBrand) {

        catalogGridBO
                .searchItem(Constants.CATEGORY_LAPTOPS)
                .verifyHeaderCatalogGrid();
        filterBO
                .selectSeveralBrand(listBrand);
    }

    @And("Sorted by price and select first of found products")
    public void sorted_by_price() {

        int positionItemInGrid = 1;

        catalogGridBO
                .clickSortedByExpensive()
                .selectIconCartItemByPosition(positionItemInGrid);
        headerBO
                .clickIconCartWithSelectedProduct();
    }

    @Then("Verify information about product in Cart")
    public void verifyInformationAboutProductInCart() {
        String nameOfProduct = "Ноутбук HP ZBook Fury 16 G9 16\" 4K WQUXGA Ts,500n/i9-12950HX (5.0)/128Gb/SSD4Tb/RTX A5500,16GB/WWAN 5G/W11P";

        cartBO
                .verifyHeader()
                .verifyTitleOfProductInCart(nameOfProduct)
                .verifyPriceOfProductLessThanMaxPrice(Constants.MAX_PRICE_LAPTOP);
    }

    @When("I search only one {}")
    public void iSearchOnlyOneBrand(String brand) {

        catalogGridBO
                .searchItem(brand);
    }

    @When("Login with wrong (.*)$")
    public void loginWithWrongEmail(String email) {

        String password = "test1234";

        headerBO
                .clickUserIcon();
        logInBO
                .fillEmailAndPassword(email, password);
    }

    @Then("I see error message with invalid email")
    public void iSeeErrorMessageWithInvalidEmail() {

        logInBO
                .verifyErrorMessageInvalidEmail();
    }

    @Then("Verify title of result as (.*)$")
    public void verifyTitleOfResultAsBrand(String brand) {
        catalogGridBO
                .verifySearchHeaderCatalogGrid(brand);
    }

    @Then("I see quantity of selected brands of laptop")
    public void verifyQuantitySelectedBrandsOfLaptop(int count) {
        catalogGridBO
                .verifyQuantitySelectedBrands(count);
    }

    @When("Login with correct email and wrong password")
    public void loginWithCorrectEmailAndWrongPassword() {

        String emailFaker = new Faker().internet().emailAddress();
        String passwordFaker = new Faker().internet().password();

        headerBO
                .clickUserIcon();
        logInBO
                .fillEmailAndPassword(emailFaker, passwordFaker);
    }

    @Then("I see error message with invalid password")
    public void iSeeErrorMessageWithInvalidPassword() {

        logInBO
                .verifyErrorMessageWithCaptcha();
    }

    @When("Open delivery points")
    public void openDeliveryPoints() {

        mainBO
                .clickDeliveryPoints();

    }

    @Then("I filtered delivery points by city")
    public void iFilteredDeliveryPointsByCity(List<String> cities) {

        deliveryPointsBO
                .selectDeliveryPointsByCityAndVerifyTitles(cities);
    }

    @When("I open page with vacancies")
    public void iOpenPageWithVacancies() {

        headerBO
                .clickUserMenu()
                .clickCategoryVacancies();
    }

    @Then("I see list of vacancies")
    public void iSeeListOfVacancies() {

        careersBO
                .verifyTitleCarrierPage()
                .clickButtonShowVacancies()
                .verifyListVacancyExists();
    }
}
