package bo;

import io.qameta.allure.Step;
import pom.FiltersPage;
import services.Waits;

import java.util.List;

public class FilterBO extends BaseBO {

    private final FiltersPage filtersPage = new FiltersPage();

    @Step("Select brand in the filter of brands")
    public FilterBO selectBrand(String brand) {
        LOGGER.info("Select brand " + brand);
        filtersPage.selectSpecificBrand(brand);
        Waits.waitForProgressBarDisappear();
        return this;
    }

    @Step("Select several brands in the filter of brands")
    public FilterBO selectSeveralBrand(List<String> listBrand) {
        for (String brand: listBrand) {
            LOGGER.info("Select brand " + brand);
            filtersPage.selectSpecificBrand(brand);
            Waits.waitForProgressBarDisappear();
        }
        return this;
    }
}
