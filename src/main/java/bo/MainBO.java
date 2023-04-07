package bo;

import pom.MainPage;

public class MainBO extends BaseBO {

    private final MainPage mainPage = new MainPage();

    public MainBO clickDeliveryPoints() {
        mainPage
                .clickDeliveryPoints();
        return this;
    }
}
