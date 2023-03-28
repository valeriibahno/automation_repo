package elements;

import org.openqa.selenium.*;

public class Button extends AbstractElement {

    public Button(WebElement webElement) {
        super(webElement);
    }

    @Override
    public void click() {
        if(webElement.isDisplayed() && webElement.isEnabled()) {
            webElement.click();
        }
    }
}
