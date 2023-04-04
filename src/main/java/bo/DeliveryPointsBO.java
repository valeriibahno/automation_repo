package bo;

import org.testng.Assert;
import pom.DeliveryPointsPage;

import java.util.List;

public class DeliveryPointsBO extends BaseBO {

    private final DeliveryPointsPage deliveryPointsPage = new DeliveryPointsPage();

    public DeliveryPointsBO selectDeliveryPointsByCityAndVerifyTitles(List<String> listCities) {

        for (String city: listCities) {
            deliveryPointsPage
                    .selectDeliveryPointsBYCity(city);
            Assert.assertTrue(deliveryPointsPage.getTitleDeliveryPoints().contains(city), "Title contains wrong city");
        }
        return this;
    }
}
