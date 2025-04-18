package herokuapp.automation.pageobbject.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public interface Getable extends Findable {

    default String getTextElement(By locator) {
        return findElement(locator).getText();
    }

    default List<String> getColumnTextList(By rowLocator, int columnIndex) {
        List<String> columnData = new ArrayList<>();
        List<WebElement> rows = findElements(rowLocator);
        for (WebElement row : rows) {
            columnData.add(row.findElement(By.xpath("td[" + columnIndex + "]")).getText());
        }
        return columnData;
    }

    default List<String> getFullNamesFromTable(By rowLocator) {
        List<String> fullNames = new ArrayList<>();
        List<WebElement> rows = findElements(rowLocator);
        for (WebElement row : rows) {
            String firstName = row.findElement(By.xpath("td[2]")).getText();
            String lastName = row.findElement(By.xpath("td[1]")).getText();
            fullNames.add(firstName + " " + lastName);
        }
        return fullNames;
    }
}
