package com.example.oop.order04;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatCode;

/**
 * packageName    : com.example.oop.order04
 * fileName       : OrderTest
 * author         : swch
 * date           : 2022-09-16
 * description    :
 * ===========================================================
 * 요구사항
 *  음식점에서 음식 주문하는 과정 구현
 *  1. 도메인을 구성하는 객체에는 어떤 것들이 있는지 고민
 *      - 손님, 메뉴판, 음식(돈까스, 냉면), 요리사, 요리
 * 2. 객체들 간의 관계를 고민
 *      - 손님 - 메뉴판, 손님 - 요리사, 요리사 - 요리
 * 3. 동적인 객체를 정적인 타입으로 추상화해서 도메인 모델링 하기
 *      - 손님 - 손님 타입, 돈까스, 냉면 - 요리 타입, 메뉴판 - 메뉴판 타입, 메뉴 - 메뉴 타입
 * 4. 협력을 설계
 * 5. 객체들을 포괄하는 타입에 적절한 책임을 할당
 * 6. 구현하기
 */
public class OrderTest {
    @DisplayName("메뉴판에서 요리를 주문")
    @Test
    public void orderTest() {
        Menu menu = new Menu(List.of(new MenuItem("돈까스", 7000), new MenuItem("냉면", 5000)));
        Chef chef = new Chef();
        Customer customer = new Customer();
        assertThatCode(() -> customer.order("돈까스", menu, chef))
                .doesNotThrowAnyException();
    }
}
