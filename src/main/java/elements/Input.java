package elements;

import services.Waits;
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

    @Override
    public void click() {
        if(webElement.isDisplayed() && webElement.isEnabled()) {
            webElement.click();
        }
    }
}
