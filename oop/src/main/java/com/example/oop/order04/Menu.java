package com.example.oop.order04;

import java.util.List;

/**
 * packageName    : com.example.oop.order04
 * fileName       : Menu
 * author         : swch
 * date           : 2022-09-16
 * description    :
 * ===========================================================
 * NOTE
 * 최초 생성
 */
public class Menu {
    private List<MenuItem> menuItems;
    public <E> Menu(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    public MenuItem choose(String name) {
        return menuItems.stream()
                .filter(menuItem -> menuItem.matches(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("잘못된 메뉴입니다."));
    }
}
