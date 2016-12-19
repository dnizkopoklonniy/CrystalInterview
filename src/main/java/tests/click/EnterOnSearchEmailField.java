package tests.click;

import core.Browser;
import data.Repository;
import data.element.ElementModel;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import tests.BaseTest;

/**
 * Type enter on search email button.
 */
public class EnterOnSearchEmailField extends BaseTest {

    /**
     * Id for search email input field for data store.
     */
    private static final String SEARCH_EMAIL_INPUT_ID = "hp.input.search.email";

    /**
     * Id for mail message info block for data store.
     */
    private static final String MAIL_MESSAGE_INFO_ID = "hp.mail.message.info";

    /**
     * Id message for click.
     */
    private static final String CLICK_MESSAGE_ID = "element.click";

    @Override
    public void runTest() {
        Repository repository = Repository.getInstance();

        checkElement(SEARCH_EMAIL_INPUT_ID);
        ElementModel elementModel = repository.getElementById(SEARCH_EMAIL_INPUT_ID);

        WebDriverWait wait = new WebDriverWait(Browser.getInstance(), 10000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementModel.getXpath())));

        getLogger().info(String.format(repository.getMessageTextById(CLICK_MESSAGE_ID), elementModel.getId()));
        Browser.getInstance().findElement(By.xpath(elementModel.getXpath())).sendKeys(Keys.ENTER);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementModel.getXpath())));
    }
}

