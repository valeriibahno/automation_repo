package bo;

import pom.FiltersPage;
import services.Waits;

import java.util.List;

public class FilterBO extends BaseBO {

    private final FiltersPage filtersPage = new FiltersPage();

    public FilterBO selectBrand(String brand) {
        LOGGER.info("Select brand " + brand);
        filtersPage.selectSpecificBrand(brand);
        Waits.waitForProgressBarDisappear();
        return this;
    }

    public FilterBO selectSeveralBrand(List<String> listBrand) {
        for (String brand: listBrand) {
            LOGGER.info("Select brand " + brand);
            filtersPage.selectSpecificBrand(brand);
            Waits.waitForProgressBarDisappear();
        }
        return this;
    }
}
