package com.example.oop.order04;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;

/**
 * packageName    : com.example.oop.order04
 * fileName       : CookTest
 * author         : swch
 * date           : 2022-09-16
 * description    :
 * ===========================================================
 * NOTE
 *  요리 테스트
 */
public class CookTest {

    @DisplayName("요리 생성")
    @Test
    public void createTest() {
        assertThatCode(() -> new Cook("만두", 5000))
                .doesNotThrowAnyException();
    }
}
