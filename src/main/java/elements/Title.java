package elements;

import org.openqa.selenium.WebElement;

public class Title extends AbstractElement {

    public Title(WebElement webElement) {
        super(webElement);
    }

    public String getTitle() {
        if(webElement.isDisplayed()) {
            return webElement.getText();
        }
        return null;
    }
}
