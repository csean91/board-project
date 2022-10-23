package com.example.oop.gradeCalculator03;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;

/**
 * packageName    : com.example.oop.gradeCalculator02
 * fileName       : CourseTest
 * author         : swch
 * date           : 2022-09-15
 * description    :
 * ===========================================================
 * NOTE
 * 최초 생성
 */
public class CourseTest {

    @DisplayName("코스(과목)를 생성")
    @Test
    public void courseCreateTest() {
        assertThatCode(() -> new Course("OOP", 3, "A+"))
                .doesNotThrowAnyException();    // 객체가 생성되면 Exception을 발생하지 않는 테스트
    }
}
