package tests.click;

/**
 * Click on logout menu item.
 */
public class ClickOnLogoutMenuItem extends BaseClick {

    /**
     * Id for logout menu item for data store.
     */
    private static final String LOGOUT_MENU_ITEM_ID = "hp.user.menu.item.logout";

    public ClickOnLogoutMenuItem() {
        setElementId(LOGOUT_MENU_ITEM_ID);
    }
}
