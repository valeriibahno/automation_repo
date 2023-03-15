package elements;

import org.openqa.selenium.WebElement;

public class Checkbox extends AbstractElement {

    public Checkbox(WebElement webElement) {
        super(webElement);
    }

    @Override
    public void click() {
        if(webElement.isDisplayed() && webElement.isEnabled()) {
            webElement.click();
        }
    }
}
