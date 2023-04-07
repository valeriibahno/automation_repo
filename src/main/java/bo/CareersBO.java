package bo;

import org.testng.Assert;
import pom.CareersPage;
import services.Constants;

public class CareersBO extends BaseBO {

    private final CareersPage careersPage = new CareersPage();

    public CareersBO clickButtonShowVacancies() {
        careersPage.clickButtonShowVacancies();
        return this;
    }

    public CareersBO verifyTitleCarrierPage() {
        Assert.assertEquals(careersPage.getTitleCarrier(), Constants.CARRIER_TITLE, "Wrong title of carrier is displayed");
        return this;
    }

    public CareersBO verifyListVacancyExists() {
        Assert.assertTrue(careersPage.getQuantityCarriers() > 0, "Quantity of vacancies is empty");
        return this;
    }
}
