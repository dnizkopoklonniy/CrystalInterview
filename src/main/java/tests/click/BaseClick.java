package tests.click;

import core.Browser;
import data.Repository;
import data.element.ElementModel;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import tests.BaseTest;

/**
 * Base class for click action.
 */
public abstract class BaseClick extends BaseTest {

    /**
     * Id message for click.
     */
    private static final String CLICK_MESSAGE_ID = "element.click";

    /**
     * Id of element for click from data store.
     */
    private String elementId = null;

    @Override
    public void runTest() {
        Repository repository = Repository.getInstance();

        checkElement(elementId);
        ElementModel elementModel = repository.getElementById(elementId);

        WebDriverWait wait = new WebDriverWait(Browser.getInstance(), 10000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementModel.getXpath())));

        getLogger().info(String.format(repository.getMessageTextById(CLICK_MESSAGE_ID), elementModel.getId()));
        Browser.getInstance().findElement(By.xpath(elementModel.getXpath())).click();
    }

    public void setElementId(String elementId) {
        this.elementId = elementId;
    }
}
