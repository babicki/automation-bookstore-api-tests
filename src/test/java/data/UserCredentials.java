package data;

public enum UserCredentials {

    VALID("walton.goggins", "A9b!X@r2"),
    INVALID_PASSWORD("walton.goggins", "wrongPass"),
    INVALID_USER("wrong.user", "A9b!X@r2"),
    EMPTY("", "");

    private final String username;
    private final String password;

    UserCredentials(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String username() {
        return username;
    }

    public String password() {
        return password;
    }
}
