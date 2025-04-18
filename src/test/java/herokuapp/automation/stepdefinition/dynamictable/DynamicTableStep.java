package herokuapp.automation.stepdefinition.dynamictable;

import herokuapp.automation.cucumber.TestContext;
import herokuapp.automation.pageobbject.dynamictable.DynamicTablePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

import java.util.List;


public class DynamicTableStep {

    private final DynamicTablePage dynamicTablePage;
    private final TestContext testContext;
    private List<String> extractedData;

    public DynamicTableStep(TestContext context) {
        testContext = context;
        dynamicTablePage = testContext.getPageObjectManager().getDynamicTablePage();
    }

    @Given("The user is on the dynamic table page")
    public void theUserIsOnTheDynamicTablePage() {
        dynamicTablePage.navigateToTablesPage();
    }

    @When("I extract all full names from the first table")
    public void iExtractAllFullNamesFromTheFirstTable() {
        extractedData = dynamicTablePage.getAllFullNames();
    }

    @Then("I print the full names in the console")
    public void iPrintTheFullNamesInTheConsole() {
        extractedData.forEach(System.out::println);
    }

    @Then("the first table should contain the full name {string}")
    public void theTableShouldContainTheFullName(String expectedFullName) {
        boolean found = dynamicTablePage.isFullNamePresent(expectedFullName);
        Assertions.assertTrue(found, "Full name not found: " + expectedFullName);
    }

    @When("I extract data from column {int} of the first table")
    public void iExtractDataFromColumnOfTheFirstTable(int columnIndex) {
        extractedData = dynamicTablePage.getColumnData(columnIndex);
    }

    @Then("I print the column values in the console")
    public void iPrintTheColumnValuesInTheConsole() {
        extractedData.forEach(System.out::println);
    }
}
