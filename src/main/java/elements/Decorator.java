package elements;

import org.openqa.selenium.support.pagefactory.DefaultFieldDecorator;
import org.openqa.selenium.support.pagefactory.ElementLocator;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;

import java.lang.reflect.Field;

public class Decorator extends DefaultFieldDecorator {

    public Decorator(ElementLocatorFactory factory) {
        super(factory);
    }

    @Override
    public Object decorate(ClassLoader loader, Field field) {
        if(field.getType().equals(Button.class)) {
            ElementLocator locator = factory.createLocator(field);
            if(loader == null) {
                return null;
            }
            return new Button(proxyForLocator(loader, locator));
        } else if(field.getType().equals(Input.class)) {
            ElementLocator locator = factory.createLocator(field);
            if(loader == null) {
                return null;
            }
            return new Input(proxyForLocator(loader, locator));
        } if(field.getType().equals(Title.class)) {
            ElementLocator locator = factory.createLocator(field);
            if(loader == null) {
                return null;
            }
            return new Title(proxyForLocator(loader, locator));
        }
        return super.decorate(loader, field);
    }
}
