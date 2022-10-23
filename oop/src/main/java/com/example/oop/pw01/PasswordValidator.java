package com.example.oop.pw01;

public class PasswordValidator {

    public static final String PASSWORD_LENGTH_EXCEPTION_MESSAGE = "비밀번호는 최소 8자 이상 12자 이하여야 한다.";

    public static void validate(String password) {
        int length = password.length();

        if (length < 8 || length > 12) {
            throw new IllegalArgumentException(PASSWORD_LENGTH_EXCEPTION_MESSAGE);
        }
    }
}
