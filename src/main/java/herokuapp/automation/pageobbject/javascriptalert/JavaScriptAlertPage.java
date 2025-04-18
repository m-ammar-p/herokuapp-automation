package herokuapp.automation.pageobbject.javascriptalert;

import herokuapp.automation.dataproviders.ConfigFileReader;
import herokuapp.automation.pageobbject.PageBase;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class JavaScriptAlertPage extends PageBase {

    public JavaScriptAlertPage(WebDriver driver) {
        super(driver);
    }

    private final By jsAlertButton = By.xpath("//button[text()='Click for JS Alert']");
    private final By jsConfirmButton = By.xpath("//button[text()='Click for JS Confirm']");
    private final By jsPromptButton = By.xpath("//button[text()='Click for JS Prompt']");
    private final By resultText = By.id("result");

    private final String javascriptAlertsUrl = ConfigFileReader.getBaseUrl() + "/javascript_alerts";

    public void navigateToJavascriptAlertPage() {
        driver.get(javascriptAlertsUrl);
    }

    public void clickJsAlert() {
        clickOnClickableElement(jsAlertButton);
    }

    public void clickJsConfirm() {
        clickOnClickableElement(jsConfirmButton);
    }

    public void clickJsPrompt() {
        clickOnClickableElement(jsPromptButton);
    }

    public String getAlertText() {
        Alert alert = getDriver().switchTo().alert();
        return alert.getText();
    }

    public void acceptAlert() {
        getDriver().switchTo().alert().accept();
    }

    public void dismissAlert() {
        getDriver().switchTo().alert().dismiss();
    }

    public void sendTextToAlert(String text) {
        Alert alert = getDriver().switchTo().alert();
        alert.sendKeys(text);
        alert.accept();
    }

    public String getResultMessage() {
        return getTextElement(resultText);
    }
}
