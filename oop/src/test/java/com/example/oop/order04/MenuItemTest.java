package com.example.oop.order04;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;

/**
 * packageName    : com.example.oop.order04
 * fileName       : MenuTest
 * author         : swch
 * date           : 2022-09-16
 * description    :
 * ===========================================================
 * NOTE
 * 메뉴 항목 테스트
 */
public class MenuItemTest {

    @DisplayName("메뉴 항목을 생성")
    @Test
    public void createTest() {
        assertThatCode(() -> new MenuItem("만두", 5000))
                .doesNotThrowAnyException();
    }
}
