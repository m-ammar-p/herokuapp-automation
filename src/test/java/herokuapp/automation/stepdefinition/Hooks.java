package herokuapp.automation.stepdefinition;

import herokuapp.automation.cucumber.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.logging.Logger;

public class Hooks {

    private WebDriver driver;
    private final TestContext testContext;
    private static final Logger LOGGER = Logger.getLogger(Hooks.class.getName());

    public Hooks(TestContext testContext) {
        this.testContext = testContext;
    }

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        testContext.setDriver(driver);
    }

    @After
    public void tearDown(Scenario scenario) {
        try {
            if (scenario.isFailed() && driver instanceof TakesScreenshot) {
                LOGGER.warning("Scenario FAILED: " + scenario.getName());

                // Capture screenshot and save it
                File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                File destFile = new File("target/allure-results/" + scenario.getName() + ".png");
                Files.copy(screenshotFile.toPath(), destFile.toPath(), StandardCopyOption.REPLACE_EXISTING);

                // Attach screenshot to Allure report
                byte[] screenshotBytes = Files.readAllBytes(destFile.toPath());
                scenario.attach(screenshotBytes, "image/png", "Failure Screenshot");
                Allure.addAttachment("Failure Screenshot", new ByteArrayInputStream(screenshotBytes));
            }
        } catch (IOException e) {
            LOGGER.severe("Failed to capture or attach screenshot: " + e.getMessage());
        } finally {
            if (driver != null) {
                driver.quit();
            }
        }
    }
}
