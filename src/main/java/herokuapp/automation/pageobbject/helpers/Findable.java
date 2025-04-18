package herokuapp.automation.pageobbject.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public interface Findable extends WebDriverContainer {

    default WebElement findElement(By locator) {
        return getDriver().findElement(locator);
    }

    default List<WebElement> findElements(By locator) {
        return getDriver().findElements(locator);
    }
}
