package herokuapp.automation.managers;

import herokuapp.automation.pageobbject.dynamictable.DynamicTablePage;
import herokuapp.automation.pageobbject.fileupload.FileUploadPage;
import herokuapp.automation.pageobbject.javascriptalert.JavaScriptAlertPage;
import herokuapp.automation.pageobbject.login.LoginPage;
import org.openqa.selenium.WebDriver;


public class PageObjectManager {

    private final WebDriver driver;
    private LoginPage LoginPage;
    private DynamicTablePage DynamicTablePage;
    private JavaScriptAlertPage JavascriptAlertPage;
    private FileUploadPage FileUploadPage;

    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage getLoginPage() {
        if (LoginPage == null) {
            LoginPage = new LoginPage(driver);
        }
        return LoginPage;
    }

    public DynamicTablePage getDynamicTablePage() {
        if (DynamicTablePage == null) {
            DynamicTablePage = new DynamicTablePage(driver);
        }
        return DynamicTablePage;
    }

    public JavaScriptAlertPage getJavascriptAlertPage() {
        if (JavascriptAlertPage == null) {
            JavascriptAlertPage = new JavaScriptAlertPage(driver);
        }
        return JavascriptAlertPage;
    }

    public FileUploadPage getFileUploadPage() {
        if (FileUploadPage == null) {
            FileUploadPage = new FileUploadPage(driver);
        }
        return FileUploadPage;
    }
}
