package bo;

import io.qameta.allure.Step;
import org.testng.Assert;
import pom.DeliveryPointsPage;

import java.util.List;

public class DeliveryPointsBO extends BaseBO {

    private final DeliveryPointsPage deliveryPointsPage = new DeliveryPointsPage();

    @Step("Select delivery points by city and verify titles for it")
    public DeliveryPointsBO selectDeliveryPointsByCityAndVerifyTitles(List<String> listCities) {

        for (String city: listCities) {
            deliveryPointsPage
                    .selectDeliveryPointsByCity(city);
            Assert.assertTrue(deliveryPointsPage.getTitleDeliveryPoints().contains(city), "Title contains wrong city");
        }
        return this;
    }
}
