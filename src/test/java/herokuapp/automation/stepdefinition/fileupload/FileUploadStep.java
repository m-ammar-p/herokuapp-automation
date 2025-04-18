package herokuapp.automation.stepdefinition.fileupload;

import herokuapp.automation.cucumber.TestContext;
import herokuapp.automation.pageobbject.fileupload.FileUploadPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;

public class FileUploadStep {

    private final FileUploadPage fileUploadPage;
    private final TestContext testContext;
    private final String fileName = "sample.txt";
    private final String filePath = System.getProperty("user.dir") + "/upload/" + fileName;

    public FileUploadStep(TestContext context) {
        testContext = context;
        fileUploadPage = testContext.getPageObjectManager().getFileUploadPage();
    }

    @Given("The user is on the file upload page")
    public void theUserIsOnTheFileUploadPage() {
        fileUploadPage.navigateToFileUploadPage();
    }

    @When("the user uploads a file using the system dialog")
    public void uploadFileUsingRobot() throws Exception {
        fileUploadPage.clickChooseFileButton();
        uploadFileWithRobot(filePath);
        fileUploadPage.clickUploadButton();
    }

    @When("the user uploads a file using Selenium")
    public void uploadFileUsingSendKeys() {
        File file = new File(filePath);
        Assertions.assertTrue(file.exists(), "Upload file does not exist: " + filePath);

        fileUploadPage.uploadFileWithSendKeys(filePath);
        fileUploadPage.clickUploadButton();
    }

    @Then("the uploaded file name should be visible on the page")
    public void validateUploadedFile() {
        Assertions.assertTrue(fileUploadPage.isUploadedFileDisplayed(fileName));
    }

    private void uploadFileWithRobot(String path) throws AWTException {
        Robot robot = new Robot();
        robot.delay(2000);

        StringSelection selection = new StringSelection(path);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);

        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);

        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);

        robot.delay(1000);

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }
}
