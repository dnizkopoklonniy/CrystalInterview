package data;

/**
 * User data model.
 */
public class User {

    /**
     * Default constructor.
     */
    public User() {
    }

    /**
     * LoginTest.
     */
    private String login = null;

    /**
     * Password.
     */
    private String password = null;

    public void setLogin(String login) {
        this.login = login;
    }

    public String getLogin() {
        return login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
}
