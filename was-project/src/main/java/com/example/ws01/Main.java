package com.example.ws01;

import com.example.ws01.CustomWebApplicationServer;

import java.io.IOException;

/**
 * packageName    : com.example
 * fileName       : Main
 * author         : swch
 * date           : 2022-09-20
 * description    :
 * 요구사항
 *  Step 1 - 사용자 요청을 메인 Thread가 처리하도록 한다.
 *  Step 2 - 사용자 요청이 들어올 때마다 Thread를 새로 생성해서 사용자 요청을 처리하도록 한다.
 *  Step 3 - Thread Pool을 적용해 안정적인 서비스가 가능하도록 한다.
 */
public class Main {

    public static void main(String[] args) throws IOException {
        new CustomWebApplicationServer(8080).start();
    }
}
