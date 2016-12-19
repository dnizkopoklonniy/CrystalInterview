package tests;

import core.Browser;
import data.Repository;

/**
 *  Open mail server page.
 */
public class OpenYandexPage extends BaseTest {

    /**
     * Url for mail server.
     */
    private static final String MAIL_SERVER_URL = "https://yandex.ru/";

    /**
     * Message id for open page.
     */
    private static final String OPEN_PAGE_MESSAGE_ID = "page.open";

    @Override
    public void runTest() {
        getLogger()
                .info(String.format(Repository.getInstance().getMessageTextById(OPEN_PAGE_MESSAGE_ID),
                MAIL_SERVER_URL));
        Browser.getInstance().get(MAIL_SERVER_URL);
    }
}
