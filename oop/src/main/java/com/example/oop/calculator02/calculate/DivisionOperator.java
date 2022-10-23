package com.example.oop.calculator02.calculate;

/**
 * packageName    : com.example.oop.calculator01.calculate
 * fileName       : DivisionOperator
 * author         : swch
 * date           : 2022-09-13
 * description    :
 * ===========================================================
 * NOTE
 * 최초 생성
 */
public class DivisionOperator implements ArithmeticOperator{
    @Override
    public boolean supports(String operator) {
        return "/".equals(operator);
    }

    @Override
    public int calculate(PositiveNumber operand1, PositiveNumber operand2) {
//        PositiveNumber 객체에서 처리해줌으로 필요가 없어짐
//        if (operand2.toInt() == 0) {
//            throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
//        }
        return operand1.toInt() / operand2.toInt();
    }
}
