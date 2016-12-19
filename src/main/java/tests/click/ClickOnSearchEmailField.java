package tests.click;

/**
 * Click on search email field.
 */
public class ClickOnSearchEmailField extends BaseClick {

    /**
     * Id for search email input field for data store.
     */
    private static final String SEARCH_EMAIL_INPUT_FIELD_ID = "hp.input.search.email";

    public ClickOnSearchEmailField() {
        setElementId(SEARCH_EMAIL_INPUT_FIELD_ID);
    }
}
