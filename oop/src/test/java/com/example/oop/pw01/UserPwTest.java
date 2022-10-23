package com.example.oop.pw01;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UserPwTest {

    @DisplayName("패스워드 초기화 확인")
    @Test
    public void passwordInitTest() {
        // given
        UserPw userPw = new UserPw();
        // when
//        userPw.initPassword(new CorrectFixedPasswordGenerator());
        userPw.initPassword(()->"abcdefgh");
        // then
        assertThat(userPw.getPassword()).isNotNull();
    }
}
