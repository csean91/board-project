package com.example.oop.order04;

import javax.swing.*;
import java.util.Objects;

/**
 * packageName    : com.example.oop.order04
 * fileName       : MenuItem
 * author         : swch
 * date           : 2022-09-16
 * description    :
 * ===========================================================
 * NOTE
 * 메뉴항목
 */
public class MenuItem {
    private String name;
    private int price;

    public MenuItem(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    /**
     * 메뉴 이름이 일치하는지 확인
     * @param name
     * @return
     */
    public boolean matches(String name) {
        return this.name.equals(name);
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MenuItem menuItem = (MenuItem) o;
        return price == menuItem.price && Objects.equals(name, menuItem.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }

}
