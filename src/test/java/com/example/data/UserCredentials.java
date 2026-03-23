package com.example.data;

/**
 * Enum with user credentials for testing.
 * Gives easy access to different login scenarios like valid, invalid, or empty credentials.
 *
 * Each constant is a different scenario:
 * - VALID: correct username and password
 * - INVALID_PASSWORD: correct username, wrong password
 * - INVALID_USER: wrong username, correct password format
 * - EMPTY: empty username and password
 */
public enum UserCredentials {

    // Demo credentials for tests
    VALID("walton.goggins", "A9b!X@r2"),
    INVALID_PASSWORD("walton.goggins", "wrongPass"),
    INVALID_USER("wrong.user", "A9b!X@r2"),
    EMPTY("", "");

    private final String username;
    private final String password;

    /**
     * Creates a credential set with username and password.
     */
    UserCredentials(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /**
     * Gets the username.
     */
    public String username() {
        return username;
    }

    /**
     * Gets the password.
     */
    public String password() {
        return password;
    }
}

