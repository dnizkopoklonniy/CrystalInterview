import core.Browser;
import data.ExcelUtils;
import data.User;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import tests.*;
import tests.click.ClickOnFoundEmail;
import tests.click.EnterOnSearchEmailField;
import tests.click.ClickOnSearchEmailField;
import tests.verify.VerifyAuthSuccess;
import tests.verify.VerifyMailContent;
import tests.verify.VerifyMailSender;
import tests.verify.VerifyMailSubject;

import java.util.HashMap;

/**
 * Test for interview.
 */
public class InterviewTest extends BaseTest {

    /**
     * Id for search email for data store.
     */
    private static final String SEARCH_EMAIL_ID = "hp.input.search.email";

    /**
     * Test data.
     */
    private HashMap<String, String> testData = null;

    @BeforeClass
    public void doBeforeTest() {
        try {
            ExcelUtils.prepare("src/main/resources/InterviewTest.xlsx","Data");
            testData = ExcelUtils.getData(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void runTest() {
        String user = testData.get("User");
        String password = testData.get("Password");
        String login = testData.get("Login");
        String subject = testData.get("Subject");
        String sender = testData.get("Sender");
        String content = testData.get("Content");

        User validUser = new User();
        validUser.setLogin(user);
        validUser.setPassword(password);

        new OpenYandexPage().runTest();
        new LoginTest(validUser).runTest();
        new VerifyAuthSuccess(login).runTest();

        new ClickOnSearchEmailField().runTest();
        new EnterTextTest(SEARCH_EMAIL_ID, subject).runTest();
        new EnterOnSearchEmailField().runTest();

        new ClickOnFoundEmail().runTest();

        new VerifyMailSender(sender).runTest();
        new VerifyMailSubject(subject).runTest();
        new VerifyMailContent(content).runTest();

        new LogoutTest().runTest();
    }

    @AfterClass
    public void doAfterTest() {
        Browser.close();
    }
}
