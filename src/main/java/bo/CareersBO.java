package bo;

import io.qameta.allure.Step;
import org.testng.Assert;
import pom.CareersPage;
import services.Constants;

public class CareersBO extends BaseBO {

    private final CareersPage careersPage = new CareersPage();

    @Step("Click button show vacancies")
    public CareersBO clickButtonShowVacancies() {
        careersPage.clickButtonShowVacancies();
        return this;
    }

    @Step("Verify title on Carrier page")
    public CareersBO verifyTitleCarrierPage() {
        Assert.assertEquals(careersPage.getTitleCarrier(), Constants.CARRIER_TITLE, "Wrong title of carrier is displayed");
        return this;
    }

    @Step("Verify list of vacancies on Carrier page")
    public CareersBO verifyListVacancyExists() {
        Assert.assertTrue(careersPage.getQuantityCarriers() > 0, "Quantity of vacancies is empty");
        return this;
    }
}
