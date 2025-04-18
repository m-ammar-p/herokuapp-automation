package herokuapp.automation.stepdefinition.login;

import herokuapp.automation.cucumber.TestContext;
import herokuapp.automation.exception.HerokuappException;
import herokuapp.automation.pageobbject.login.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;

public class LoginStep {

    private final LoginPage loginPage;
    private final TestContext testContext;

    public LoginStep(TestContext context) {
        testContext = context;
        loginPage = testContext.getPageObjectManager().getLoginPage();
    }

    @Given("The user is on the login page")
    public void theUserIsOnTheLoginPage() {
        loginPage.navigateToLoginPage();
    }

    @Given("^I log in with (.*) username$")
    public void iLogInWithUsername(String username) {
        loginPage.loginWithUsername(username);
    }

    @Then("I check login is correct")
    public void iCheckLoginIsCorrect() throws HerokuappException {
        Assertions.assertTrue(loginPage.checkLoginPerform());
    }

    @And("I logout")
    public void iLogOut() {
        loginPage.logOut();
    }

    @Then("I check logout is correct")
    public void iCheckLogoutIsCorrect() throws HerokuappException {
        Assertions.assertTrue(loginPage.checkLogoutPerform());
    }

    @Then("I check login is incorrect")
    public void iCheckLoginIsInCorrect() throws HerokuappException {
        Assertions.assertTrue(loginPage.checkInvalidLoginPerform());
    }
}
