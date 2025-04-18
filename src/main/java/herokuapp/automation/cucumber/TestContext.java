package herokuapp.automation.cucumber;

import herokuapp.automation.exception.HerokuappException;
import herokuapp.automation.managers.PageObjectManager;
import org.openqa.selenium.WebDriver;

public class TestContext {
    
    private PageObjectManager pageObjectManager;
    private final ScenarioContext scenarioContext;

    public TestContext() throws HerokuappException {
        scenarioContext = new ScenarioContext();
    }

    public void setDriver(WebDriver driver) {
        pageObjectManager = new PageObjectManager(driver);
    }

    public PageObjectManager getPageObjectManager() {
        return pageObjectManager;
    }

    public ScenarioContext getScenarioContext() {
        return scenarioContext;
    }
}
