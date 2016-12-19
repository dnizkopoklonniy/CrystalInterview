package tests.verify;

/**
 * Class for verify mail subject.
 */
public class VerifyMailSubject extends BaseVerifyEmailField {

    /**
     * Id for mail subject for data store.
     */
    private static final String MAIL_SUBJECT_ID = "hp.mail.subject";

    public VerifyMailSubject(String text) {
        setElementId(MAIL_SUBJECT_ID);
        setText(text);
    }
}
