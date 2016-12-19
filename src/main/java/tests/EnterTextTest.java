package tests;

import core.Browser;
import data.Repository;
import data.element.ElementModel;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.testng.AssertJUnit.assertTrue;

/**
 * Base class for enter text to input field.
 */
public class EnterTextTest extends BaseTest {

    /**
     * Id of message for null text.
     */
    private static final String NULL_TEXT_ID = "text.null";

    /**
     * Id of message for text enter to field.
     */
    private static final String TEXT_ENTER_ID = "text.enter";

    /**
     * Id element for data store.
     */
    private String elementId = null;

    /**
     * Text for enter to field.
     */
    private String text = null;

    public EnterTextTest() {
    }

    public EnterTextTest(String elementId, String text) {
        this.elementId = elementId;
        this.text = text;
    }

    @Override
    public void runTest() {
        Repository repository = Repository.getInstance();

        checkElement(elementId);
        assertTrue(repository.getMessageTextById(NULL_TEXT_ID), text!=null);

        getLogger().info(String.format(repository.getMessageTextById(TEXT_ENTER_ID), text, elementId));

        // Enter text to field.
        ElementModel elementModel = Repository.getInstance().getElementById(elementId);

        WebDriverWait wait = new WebDriverWait(Browser.getInstance(), 10000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementModel.getXpath())));
        Browser.getInstance().findElement(By.xpath(elementModel.getXpath())).sendKeys(text.trim());
    }

    public void setElementId(String elementId) {
        this.elementId = elementId;
    }

    public void setText(String text) {
        this.text = text;
    }
}
