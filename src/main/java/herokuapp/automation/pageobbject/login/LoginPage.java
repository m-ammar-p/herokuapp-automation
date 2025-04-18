package herokuapp.automation.pageobbject.login;

import herokuapp.automation.dataproviders.ConfigFileReader;
import herokuapp.automation.exception.HerokuappException;
import herokuapp.automation.pageobbject.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends PageBase {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private final By usernameId = By.id("username");
    private final By passwordId = By.id("password");
    private final By loginBtnXpath = By.xpath("//button[.//i[normalize-space()='Login']]");
    private final By logoutLinkText = By.partialLinkText("Logout");
    private final By errorAlert = By.id("flash-messages");

    private final String loginUrl = ConfigFileReader.getBaseUrl() + "/login";
    private static final String PASSWORD = "SuperSecretPassword!";

    public void navigateToLoginPage() {
        driver.get(loginUrl);
    }

    public void loginWithUsername(String username) {
        waitUntilElementIsVisible(usernameId);
        fillElement(username, usernameId);
        fillElement(PASSWORD, passwordId);
        clickOnClickableElement(loginBtnXpath);
    }

    public boolean checkLoginPerform() throws HerokuappException {
        waitUntilElementIsNotVisible(loginBtnXpath);
        return elementExists(logoutLinkText);
    }

    public boolean checkInvalidLoginPerform() throws HerokuappException {
        waitUntilElementIsVisible(errorAlert);
        return elementExists(errorAlert);
    }

    public void logOut() {
        clickOnClickableElement(logoutLinkText);
    }

    public boolean checkLogoutPerform() throws HerokuappException {
        waitUntilElementIsNotVisible(logoutLinkText);
        return elementExists(loginBtnXpath);
    }
}
