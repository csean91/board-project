package com.example.oop.calculator02;

import com.example.oop.calculator02.calculate.PositiveNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

/**
 * packageName    : com.example.oop.calculator02
 * fileName       : CalculatorTest
 * author         : swch
 * date           : 2022-09-08
 * description    :
 * ===========================================================
 * 요구사항
 *  1. 간단한 사칙연산을 할 수 있다.
 *  2. 양수로만 계산할 수 있다.
 *  3. 나눗셈에서 0으로 나누는 경우 IllegalArgument 예외를 발생시킨다.
 *  4. MVC패턴(Model-View-Controller) 기반으로 구현한다.
 */
public class CalculatorTest {

    @DisplayName("덧셈연산")
    @Test
    public void additionTest() {
        int result = Calculator.calculate(new PositiveNumber(2), "+", new PositiveNumber(3));
        assertThat(result).isEqualTo(5);
    }
    @DisplayName("뺄셈연산")
    @Test
    public void subtractionTest() {
        int result = Calculator.calculate(new PositiveNumber(5), "-", new PositiveNumber(3));
        assertThat(result).isEqualTo(2);
    }

    @DisplayName("사칙연산 리팩토링")
    @ParameterizedTest
    @MethodSource("formularAndResult")
    public void fourFundamentalArithmetic(int operand1, String operator, int operand2, int result) {
        int calculatedResult = Calculator.calculate(new PositiveNumber(operand1), operator, new PositiveNumber(operand2));
        assertThat(calculatedResult).isEqualTo(result);
    }

    /**
     * paramter로 값을 차례 차례 던져주는 method
     * @return
     */
    private static Stream<Arguments> formularAndResult() {
        return Stream.of(
                Arguments.arguments(1, "+", 2, 3),
                Arguments.arguments(2, "-", 3, -1),
                Arguments.arguments(3, "*", 2, 6),
                Arguments.arguments(9, "/", 3, 3)
        );
    }

    @DisplayName("나눗셈에서 0으로 나누는 경우 테스트")
    @Test
    public void calculateExceptionTest() {
        assertThatCode(() -> Calculator.calculate(new PositiveNumber(10), "/", new PositiveNumber(0)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("0과 음수 테스트")
    @ParameterizedTest
    @ValueSource(ints = {0, -10})
    public void noPositiveTest(int no) {
        assertThatCode(() -> new PositiveNumber(no))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
