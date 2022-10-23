package com.example.oop.gradeCalculator03;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * packageName    : com.example.oop.gradeCalculator02
 * fileName       : GradeCalculatorTest
 * author         : swch
 * date           : 2022-09-15
 * description    :
 * ===========================================================
 * 요구사항
 *  평균학점 계산 방법 = (학점수×교과목 평점)의 합계/수강신청 총학점 수
 *  일급 컬렉션 사용
 */
public class GradeCalculatorTest {

    @DisplayName("평균 학점 계산")
    @Test
    public void gradeCalculateTest() {
        List<Course> courses = List.of(new Course("객체지향", 3, "A+"), new Course("자료구조", 3, "A+"));
        GradeCalculator calculator = new GradeCalculator(courses);
        double grade = calculator.calculate();
        assertThat(grade).isEqualTo(4.5);
    }

}
