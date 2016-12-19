package tests.verify;

import core.Browser;
import data.Repository;
import data.element.ElementModel;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import tests.BaseTest;

import static org.testng.AssertJUnit.assertTrue;

/**
 * Class for verify success auth.
 */
public class VerifyAuthSuccess extends BaseTest {

    /**
     * Id of message for null text.
     */
    private static final String NULL_TEXT_ID = "text.null";

    /**
     * Id for email user name label.
     */
    private static final String LABEL_LOGIN_TEXT_ID = "hp.label.login.text";

    /**
     * Id of message for auth fail.
     */
    private static final String AUTH_FAIL_ID = "auth.fail";

    /**
     * Message id for check email user name.
     */
    private static final String MESSAGE_CHECK_EMAIL_USER_NAME_ID = "text.email.user.name";

    /**
     * Email user name.
     */
    private String emailUserName = null;

    public VerifyAuthSuccess(String emailUserName) {
        this.emailUserName = emailUserName;
    }

    @Override
    public void runTest() {
        Repository repository = Repository.getInstance();
        Logger logger = getLogger();

        checkElement(LABEL_LOGIN_TEXT_ID);
        assertTrue(repository.getMessageTextById(NULL_TEXT_ID), emailUserName != null);

        logger.info(String.format(repository.getMessageTextById(MESSAGE_CHECK_EMAIL_USER_NAME_ID), emailUserName));

        ElementModel elementModel = repository.getElementById(LABEL_LOGIN_TEXT_ID);

        WebDriverWait wait = new WebDriverWait(Browser.getInstance(), 10000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementModel.getXpath())));
        WebElement element = Browser.getInstance().findElement(By.xpath(elementModel.getXpath()));

        assertTrue(repository.getMessageTextById(AUTH_FAIL_ID), emailUserName.equals(element.getText()));
    }
}
