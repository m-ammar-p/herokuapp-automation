package herokuapp.automation.stepdefinition.javascriptalert;

import herokuapp.automation.cucumber.TestContext;
import herokuapp.automation.pageobbject.javascriptalert.JavaScriptAlertPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JavaScriptAlertStep {

    private final JavaScriptAlertPage javaScriptAlertPage;
    private final TestContext testContext;

    public JavaScriptAlertStep(TestContext context) {
        testContext = context;
        javaScriptAlertPage = testContext.getPageObjectManager().getJavascriptAlertPage();
    }
    @Given("The user is on the javaScript alerts page")
    public void theUserIsOnTheJavaScriptAlertsPage() {
        javaScriptAlertPage.navigateToJavascriptAlertPage();
    }

    @When("I click the JS Alert button")
    public void clickJsAlert() {
        javaScriptAlertPage.clickJsAlert();
    }

    @When("I click the JS Confirm button")
    public void clickJsConfirm() {
        javaScriptAlertPage.clickJsConfirm();
    }

    @When("I click the JS Prompt button")
    public void clickJsPrompt() {
        javaScriptAlertPage.clickJsPrompt();
    }

    @Then("I should see alert message {string}")
    public void verifyAlertMessage(String expectedMessage) {
        String actual = javaScriptAlertPage.getAlertText();
        assertEquals(expectedMessage, actual, "Alert message mismatch");
    }

    @And("I accept the alert")
    public void acceptAlert() {
        javaScriptAlertPage.acceptAlert();
    }

    @And("I dismiss the alert")
    public void dismissAlert() {
        javaScriptAlertPage.dismissAlert();
    }

    @And("I enter {string} in the alert and accept")
    public void enterTextAndAccept(String input) {
        javaScriptAlertPage.sendTextToAlert(input);
    }

    @Then("the result message should be {string}")
    public void verifyResultMessage(String expectedMessage) {
        assertEquals(expectedMessage, javaScriptAlertPage.getResultMessage(), "Result message mismatch");
    }
}
