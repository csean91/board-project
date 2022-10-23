package com.example.oop.calculator02.calculate;

/**
 * packageName    : com.example.oop.calculator01
 * fileName       : ArithmeticOperator2
 * author         : swch
 * date           : 2022-09-13
 * description    :
 * ===========================================================
 * NOTE
 * 최초 생성
 */
public interface ArithmeticOperator {
    public boolean supports(String operator);   // operator 지원 여부 판단
    public int calculate(PositiveNumber operand1, PositiveNumber operand2);
}
