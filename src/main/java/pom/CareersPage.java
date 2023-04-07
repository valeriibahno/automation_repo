package pom;

import elements.Button;
import elements.Title;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CareersPage extends BasePage {

    @FindBy(xpath = "//h5[contains(@class,'filter-vacancies')]")
    private Title titleCarriers;

    @FindBy(xpath = "//a[contains(@class,'filter-vacancies__show')]")
    private Button buttonShowVacancies;

    @FindBy(xpath = "//li[contains(@class,'vacancies__item')]")
    private List<WebElement> itemVacancy;

    public String getTitleCarrier() {
        return titleCarriers.getTitle();
    }

    public Integer getQuantityCarriers() {
        return itemVacancy.size();
    }

    public CareersPage clickButtonShowVacancies() {
        LOGGER.info("Click button show vacancies");
        buttonShowVacancies.click();
        return this;
    }
}
