package herokuapp.automation.pageobbject.helpers;

import org.openqa.selenium.*;

public interface Conditionable extends Waitable, Getable {

    default boolean elementIsVisible(By locator) {
        return findElement(locator).isDisplayed();
    }

    default boolean elementExists(By locator) {
        return !findElements(locator).isEmpty();
    }

    default boolean isAlertPresent(WebDriver driver) {
        boolean presentAlert;
        try {
            driver.switchTo().alert();
            presentAlert = true;
        } catch (NoAlertPresentException ex) {
            presentAlert = false;
        }
        return presentAlert;
    }

    default boolean isFullNamePresentInTable(By rowLocator, String expectedFullName) {
        return getFullNamesFromTable(rowLocator).contains(expectedFullName);
    }
}
