package com.example.oop.order04;

/**
 * packageName    : com.example.oop.order04
 * fileName       : Customer
 * author         : swch
 * date           : 2022-09-16
 * description    :
 * ===========================================================
 * NOTE
 * 최초 생성
 */
public class Customer {
    /**
     *
     * @param menuName 선택한 메뉴 이름
     * @param menu 메뉴판
     * @param chef 요리사
     */
    public void order(String menuName, Menu menu, Chef chef) {
        MenuItem menuItem = menu.choose(menuName);  // 메뉴 항목에 요리가 있는지
        chef.cook(menuItem);    // 요리사에게 요리 부탁
    }
}
