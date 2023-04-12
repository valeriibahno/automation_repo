package bo;

import io.qameta.allure.Step;
import org.apache.log4j.Logger;
import pom.HeaderPage;

public abstract class BaseBO {

    protected static final Logger LOGGER = Logger.getLogger(BaseBO.class);
    protected final HeaderPage headerPage = new HeaderPage();

    @Step("Click on search field, fill it and click button 'Submit'")
    public CatalogGridBO searchItem(String nameItemToSearch) {
        LOGGER.info("Click on search field, fill " + nameItemToSearch + " and click button 'Submit'");
        headerPage
                .fillSearchField(nameItemToSearch)
                .clickButtonSubmit();
        return new CatalogGridBO();
    }
}
