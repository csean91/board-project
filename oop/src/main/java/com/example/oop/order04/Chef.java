package com.example.oop.order04;

/**
 * packageName    : com.example.oop.order04
 * fileName       : Chef
 * author         : swch
 * date           : 2022-09-16
 * description    :
 * ===========================================================
 * NOTE
 * 요리사 객체
 */
public class Chef {
    public Cook cook(MenuItem menuItem) {
        Cook cook = new Cook(menuItem);
        return cook;
    }
}
