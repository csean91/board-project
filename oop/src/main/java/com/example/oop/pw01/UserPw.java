package com.example.oop.pw01;

public class UserPw {

    private String password;

//    public void initPassword() {
//        RandomPasswordGenerator passwordGenerator = new RandomPasswordGenerator();
//        String randomPassword = passwordGenerator.generatePassword();
//        // 비밀번호가 8~12자 일때만 세팅
//        if (randomPassword.length() >= 8 && randomPassword.length() <= 12) {
//            this.password = randomPassword;
//        }
//    }

    public void initPassword(PasswordGenerator passwordGenerator) {
//        RandomPasswordGenerator passwordGenerator = new RandomPasswordGenerator();
        String password = passwordGenerator.generatePassword();
        // 비밀번호가 8~12자 일때만 세팅
        if (password.length() >= 8 && password.length() <= 12) {
            this.password = password;
        }
    }

    public String getPassword() {
        return password;
    }
}
