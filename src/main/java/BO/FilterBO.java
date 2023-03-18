package BO;

import POM.FiltersPage;
import Services.Waits;

public class FilterBO extends BaseBO {

    private final FiltersPage filtersPage = new FiltersPage();

    public FilterBO selectBrand(String brand) {
        LOGGER.info("Select brand " + brand);
        filtersPage.selectSpecificBrand(brand);
        Waits.waitForProgressBarDisappear();
        return this;
    }
}
