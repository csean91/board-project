package com.example.calculator.calculate;

/**
 * packageName    : com.example.oop.calculator01.calculate
 * fileName       : AdditionOperator
 * author         : swch
 * date           : 2022-09-13
 * description    :
 * ===========================================================
 * NOTE
 * 최초 생성
 */
public class AdditionOperator implements ArithmeticOperator{
    @Override
    public boolean supports(String operator) {
        return "+".equals(operator);
    }

    @Override
    public int calculate(PositiveNumber operand1, PositiveNumber operand2) {
        return operand1.toInt() + operand2.toInt();
    }
}
