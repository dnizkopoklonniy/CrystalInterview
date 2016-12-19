package tests.verify;

/**
 * Class for verify mail sender.
 */
public class VerifyMailSender extends BaseVerifyEmailField {

    /**
     * Id of message for email sender.
     */
    private static final String EMAIL_SENDER_ID = "hp.mail.sender";

    public VerifyMailSender(String text) {
        setElementId(EMAIL_SENDER_ID);
        setText(text);
    }
}
