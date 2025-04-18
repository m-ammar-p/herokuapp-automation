package herokuapp.automation.pageobbject.helpers;

public interface Utilable extends Findable {

    default void acceptAlert() {
        getDriver().switchTo().alert().accept();
    }
}
