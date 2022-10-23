package com.example.oop.order04;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * packageName    : com.example.oop.order04
 * fileName       : CookingTest
 * author         : swch
 * date           : 2022-09-16
 * description    :
 * ===========================================================
 * NOTE
 * 최초 생성
 */
public class CookingTest {

    @DisplayName("메뉴에 있는 요리를 한다")
    @Test
    public void cookTest() {
        Chef chef = new Chef();
        MenuItem menuItem = new MenuItem("돈까스", 7000);
        Cook cook = chef.cook(menuItem);
        assertThat(cook).isEqualTo(new Cook("돈까스", 7000));
    }
}
