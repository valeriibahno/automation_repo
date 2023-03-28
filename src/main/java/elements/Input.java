package elements;

import Services.Waits;
import org.openqa.selenium.WebElement;

public class Input extends AbstractElement {

    public Input(WebElement webElement) {
        super(webElement);
    }

    public void fillInput(WebElement webElementForWait, String searchText) {
        if(webElement.isDisplayed() && webElement.isEnabled()) {
            webElement.click();
            webElement.sendKeys(searchText);
        }
        Waits.waitForVisibleWebElement(webElementForWait);
    }
}
