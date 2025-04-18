package herokuapp.automation.pageobbject.dynamictable;

import herokuapp.automation.dataproviders.ConfigFileReader;
import herokuapp.automation.pageobbject.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class DynamicTablePage extends PageBase {

    private final By firstTableRows = By.xpath("//table[1]//tbody/tr");

    private final String tablesUrl = ConfigFileReader.getBaseUrl() + "/tables";

    public DynamicTablePage(WebDriver driver) {
        super(driver);
    }

    public void navigateToTablesPage() {
        driver.get(tablesUrl);
    }

    public List<String> getAllFullNames() {
        return getFullNamesFromTable(firstTableRows);
    }

    public boolean isFullNamePresent(String expectedName) {
        return isFullNamePresentInTable(firstTableRows, expectedName);
    }

    public List<String> getColumnData(int columnIndex) {
        return getColumnTextList(firstTableRows, columnIndex);
    }
}
