package tests.verify;

import core.Browser;
import data.Repository;
import data.element.ElementModel;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import tests.BaseTest;

import static org.testng.AssertJUnit.assertTrue;

/**
 * Base class for verify email field.
 */
public class BaseVerifyEmailField extends BaseTest {

    /**
     * Id of message for null text.
     */
    private static final String NULL_TEXT_ID = "text.null";

    /**
     * Id of message for verify email text.
     */
    private static final String EMAIL_VERIFY_FIELD_TEXT_ID = "text.email.field.verify.text";

    /**
     * Id of message for email field not match.
     */
    private static final String TEXT_EMAIL_FIELD_NOT_MATCH_ID = "text.email.field.not.match";

    /**
     * Id for element for data store.
     */
    private String elementId = null;

    /**
     * Text of element.
     */
    private String text = null;

    @Override
    public void runTest() {
        Repository repository = Repository.getInstance();
        Logger logger = getLogger();

        checkElement(elementId);
        assertTrue(repository.getMessageTextById(NULL_TEXT_ID), text != null);

        ElementModel elementModel = repository.getElementById(elementId);
        WebElement element = Browser.getInstance().findElement(By.xpath(elementModel.getXpath()));

        logger.info(String.format(repository.getMessageTextById(EMAIL_VERIFY_FIELD_TEXT_ID), text, elementId));
        assertTrue(String.format(repository.getMessageTextById(TEXT_EMAIL_FIELD_NOT_MATCH_ID), text), text.trim().equals(element.getText()));
    }

    public void setElementId(String elementId) {
        this.elementId = elementId;
    }

    public void setText(String text) {
        this.text = text;
    }
}
