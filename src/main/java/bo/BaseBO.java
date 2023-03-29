package bo;

import pom.HeaderPage;
import org.apache.log4j.Logger;

public abstract class BaseBO {

    protected static final Logger LOGGER = Logger.getLogger(BaseBO.class);
    protected final HeaderPage headerPage = new HeaderPage();

    public CatalogGridBO searchItem(String nameItemToSearch) {
        LOGGER.info("Click on search field, fill " + nameItemToSearch + " and click button 'Submit'");
        headerPage
//                .clickOnSearchField()
//                .fillSearchField(nameItemToSearch)
                .fillSearchField(nameItemToSearch)
                .clickButtonSubmit();
        return new CatalogGridBO();
    }
}
