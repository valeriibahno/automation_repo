package bo;

import pom.FiltersPage;
import services.Waits;

public class FilterBO extends BaseBO {

    private final FiltersPage filtersPage = new FiltersPage();

    public FilterBO selectBrand(String brand) {
        LOGGER.info("Select brand " + brand);
        filtersPage.selectSpecificBrand(brand);
        Waits.waitForProgressBarDisappear();
        return this;
    }
}
