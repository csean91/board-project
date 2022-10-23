package com.example;

import com.example.ws01.RequestLine;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * packageName    : com.example
 * fileName       : RequestLineTest
 * author         : swch
 * date           : 2022-09-22
 * description    :
 */
public class RequestLineTest {

    @Test
    void createTest() {
        RequestLine requestLine = new RequestLine("GET /calculate?operand1=11&operator=+&operand2=33 HTTP/1.1");
        assertThat(requestLine).isNotNull();
        // 객체가 같은지 확인
        assertThat(requestLine).isEqualTo(new RequestLine("GET", "/calculate", "operand1=11&operator=+&operand2=33"));
    }
}
