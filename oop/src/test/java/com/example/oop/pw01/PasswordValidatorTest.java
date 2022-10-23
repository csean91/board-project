package com.example.oop.pw01;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;

public class PasswordValidatorTest {

    @DisplayName("비밀번호는 8자 이상, 12자 이하")
    @Test
    void validatePasswordTest() {
        assertThatCode(() -> PasswordValidator.validate("aabbccdd"))
                .doesNotThrowAnyException();
    }

    @DisplayName("비밀번호가 8자~12자가 아니면 IllegalArgumentException 예외 발생")
    @Test
    void validatePasswordTest2() {
        assertThatCode(() -> PasswordValidator.validate("aabb"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("비밀번호는 최소 8자 이상 12자 이하여야 한다.");
    }

    @DisplayName("경계조건 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"aabbccd", "aaabbbcccddde"})
    void validatePasswordTest3(String value) {
        assertThatCode(() -> PasswordValidator.validate(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("비밀번호는 최소 8자 이상 12자 이하여야 한다.");
    }


}
