package com.example;

import com.example.ws01.QueryString;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * packageName    : com.example
 * fileName       : QueryStringTest
 * author         : swch
 * date           : 2022-09-22
 * description    :
 */
public class QueryStringTest {

    @Test
    void createTest() {
        // queryString은 operand1=11을 갖는 객체. 이 queryString이 여러개일 수 있기 때문에 일급 컬렉션을 생성
        QueryString queryString = new QueryString("operand1", "11");
        assertThat(queryString).isNotNull();
    }
}
