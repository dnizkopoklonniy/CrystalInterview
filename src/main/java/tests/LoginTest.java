package tests;

import data.User;
import tests.click.ClickOnLoginButton;

/**
 * LoginTest to mail server.
 */
public class LoginTest extends BaseTest {

    /**
     * Id for login field.
     */
    private static final String LOGIN_FIELD_ID = "hp.input.login";

    /**
     * Id for password field.
     */
    private static final String PASSWORD_FIELD_ID = "hp.input.password";

    /**
     * User.
     */
    private User user = null;

    public LoginTest(User user) {
        this.user = user;
    }

    @Override
    public void runTest() {
        EnterTextTest enterTextTest = new EnterTextTest();

        enterTextTest.setElementId(LOGIN_FIELD_ID);
        enterTextTest.setText(user.getLogin());
        enterTextTest.runTest();

        enterTextTest.setElementId(PASSWORD_FIELD_ID);
        enterTextTest.setText(user.getPassword());
        enterTextTest.runTest();

        new ClickOnLoginButton().runTest();
    }
}
