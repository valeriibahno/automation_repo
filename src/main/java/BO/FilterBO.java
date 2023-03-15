package BO;

import POM.FiltersPage;

public class FilterBO extends BaseBO {

    private final FiltersPage filtersPage = new FiltersPage();

    public FilterBO searchAndSelectBrand(String brand) {
        LOGGER.info("Search brand 'HP' and select it");
        filtersPage
//                .fillInputSearchBrand(brand)
                .selectHP();
        return this;
    }
}
