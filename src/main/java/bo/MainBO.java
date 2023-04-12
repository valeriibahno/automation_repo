package bo;

import io.qameta.allure.Step;
import pom.MainPage;

public class MainBO extends BaseBO {

    private final MainPage mainPage = new MainPage();

    @Step("Click delivery points")
    public MainBO clickDeliveryPoints() {
        mainPage
                .clickDeliveryPoints();
        return this;
    }
}
