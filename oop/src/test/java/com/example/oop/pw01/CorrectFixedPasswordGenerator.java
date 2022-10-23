package com.example.oop.pw01;

public class CorrectFixedPasswordGenerator implements PasswordGenerator {
    @Override
    public String generatePassword() {
        return "abcdefgh"; //8글자의 패스워드 설정
    }
}
