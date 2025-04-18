package herokuapp.automation.pageobbject.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public interface Fillable extends Waitable {

    default void fillElement(String value, By locator) {
        if (!value.isEmpty()) {
            WebElement element = findElement(locator);
            element.clear();
            element.sendKeys(value);
        }
    }

    default void fillElement(String value, WebElement element) {
        if (!value.isEmpty()) {
            element.clear();
            element.sendKeys(value);
        }
    }
}
