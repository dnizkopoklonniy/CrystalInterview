package tests.click;

import core.Browser;
import data.Repository;
import data.element.ElementModel;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import tests.BaseTest;

/**
 * Click on found email id. Action via java script.
 */
public class ClickOnFoundEmail extends BaseTest {

    /**
     * Js code for click on first found email.
     */
    private static final String jsFoundEmailClick = "$('.mail-MessageSnippet-Wrapper > a')[0].click();";

    /**
     * Id of message for email sender.
     */
    private static final String EMAIL_SENDER_ID = "hp.mail.sender";

    @Override
    public void runTest() {
        Repository repository = Repository.getInstance();

        WebDriver driver = Browser.getInstance();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript(jsFoundEmailClick);

        ElementModel elementModel = repository.getElementById(EMAIL_SENDER_ID);
        WebDriverWait wait = new WebDriverWait(Browser.getInstance(), 10000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementModel.getXpath())));
    }
}
