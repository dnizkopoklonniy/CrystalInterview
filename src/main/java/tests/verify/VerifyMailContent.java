package tests.verify;

/**
 * Class for verify mail content.
 */
public class VerifyMailContent extends BaseVerifyEmailField {

    /**
     * Id for mail content for data store.
     */
    private static final String MAIL_CONTENT_ID = "hp.mail.content";

    public VerifyMailContent(String text) {
        setElementId(MAIL_CONTENT_ID);
        setText(text);
    }
}
