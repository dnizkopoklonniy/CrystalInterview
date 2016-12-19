package tests;

import tests.click.ClickOnAvatarIcon;
import tests.click.ClickOnLogoutMenuItem;

/**
 * Logout from mail server page.
 */
public class LogoutTest extends BaseTest {

    @Override
    public void runTest() {
        new ClickOnAvatarIcon().runTest();
        new ClickOnLogoutMenuItem().runTest();
    }
}
