package com.example.oop.order04;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

/**
 * packageName    : com.example.oop.order04
 * fileName       : MenuTest
 * author         : swch
 * date           : 2022-09-16
 * description    :
 * ===========================================================
 * NOTE
 * 최초 생성
 */
public class MenuTest {

    @DisplayName("메뉴판에서 메뉴 항목에 있는 메뉴를 반환")
    @Test
    public void chooseTest() {
        Menu menu = new Menu(List.of(new MenuItem("돈까스", 7000), new MenuItem("냉면", 5000)));
        MenuItem menuItem = menu.choose("돈까스");
        assertThat(menuItem).isEqualTo(new MenuItem("돈까스", 7000));
    }

    @DisplayName("메뉴판에 없는 메뉴를 주문하면 예외 발생")
    @Test
    public void chooseError() {
        Menu menu = new Menu(List.of(new MenuItem("돈까스", 7000), new MenuItem("냉면", 5000)));
        assertThatCode(() -> menu.choose("치킨"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
