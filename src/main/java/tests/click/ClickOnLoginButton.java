package tests.click;

/**
 * Click on login button.
 */
public class ClickOnLoginButton extends BaseClick {

    /**
     * Id for login button for data store.
     */
    private static final String LOGIN_BUTTON_ID = "hp.button.login";

    public ClickOnLoginButton() {
        setElementId(LOGIN_BUTTON_ID);
    }
}
