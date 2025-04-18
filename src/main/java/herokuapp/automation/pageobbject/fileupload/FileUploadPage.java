package herokuapp.automation.pageobbject.fileupload;

import herokuapp.automation.dataproviders.ConfigFileReader;
import herokuapp.automation.pageobbject.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.logging.Logger;

public class FileUploadPage extends PageBase {

    private static final Logger LOGGER = Logger.getLogger(FileUploadPage.class.getName());

    public FileUploadPage(WebDriver driver) {
        super(driver);
    }

    private final String fileUploadUrl = ConfigFileReader.getBaseUrl() + "/upload";

    private final By chooseFileButton = By.id("file-upload");
    private final By uploadButton = By.id("file-submit");
    private final By uploadedFileText = By.id("uploaded-files");

    public void navigateToFileUploadPage() {
        driver.get(fileUploadUrl);
    }

    public void clickChooseFileButton() {
        waitUntilElementIsVisible(chooseFileButton);
        clickOnClickableElement(chooseFileButton);
    }

    public void clickUploadButton() {
        waitUntilElementIsVisible(uploadButton);
        clickOnClickableElement(uploadButton);
    }

    public void uploadFileWithSendKeys(String fullPath) {
        waitUntilElementIsVisible(chooseFileButton);
        fillElement(fullPath, chooseFileButton);
    }

    public boolean isUploadedFileDisplayed(String expectedFileName) {
        String actualFileName = getTextElement(uploadedFileText).trim();
        boolean match = actualFileName.equalsIgnoreCase(expectedFileName);

        if (!match) {
            LOGGER.warning("File upload mismatch! Expected: '" + expectedFileName + "', but found: '" + actualFileName + "'");
        }
        return match;
    }
}
