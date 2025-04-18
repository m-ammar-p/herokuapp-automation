package herokuapp.automation.pageobbject.helpers;

import herokuapp.automation.dataproviders.ConfigFileReader;
import herokuapp.automation.exception.HerokuappException;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.util.concurrent.TimeUnit.SECONDS;

public interface Waitable extends Findable {

    default void waitUntilElementIsVisible(By locator) throws HerokuappException {
        WebDriverWait wait = new WebDriverWait(getDriver(), ConfigFileReader.getImplicitlyWait());
        wait.ignoring(NoSuchElementException.class);
        wait.ignoring(InvalidArgumentException.class);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    default void waitUntilElementIsNotVisible(By locator) throws HerokuappException {
        WebDriverWait wait = new WebDriverWait(getDriver(), ConfigFileReader.getImplicitlyWait());
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    default void waitSeconds(int seconds) throws HerokuappException {
        try {
            SECONDS.sleep(seconds);
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
        }
    }

    default void waitSeconds() throws HerokuappException {
        try {
            SECONDS.sleep(ConfigFileReader.getWaitSeconds());
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
        }
    }
}
