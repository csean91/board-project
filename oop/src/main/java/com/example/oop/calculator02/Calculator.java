package com.example.oop.calculator02;

import com.example.oop.calculator02.calculate.*;

import java.util.List;

/**
 * packageName    : com.example.oop.calculator02
 * fileName       : Calculator
 * author         : swch
 * date           : 2022-09-08
 * description    :
 * ===========================================================
 * NOTE
 * 최초 생성
 */
public class Calculator {
    private static final List<com.example.oop.calculator02.calculate.ArithmeticOperator> arithmeticOperators =
            List.of(new AdditionOperator(), new SubtractionOperator(), new MultiplicationOperator(), new DivisionOperator());

    public static int calculate(PositiveNumber operand1, String operator, PositiveNumber operand2) {
//        if ("+".equals(operator)) {
//            return operand1 + operand2;
//        }
//        else if ("-".equals(operator)) {
//            return operand1 - operand2;
//        }
//        else if ("*".equals(operator)) {
//            return operand1 * operand2;
//        }
//        else if ("/".equals(operator)) {
//            return operand1 / operand2;
//        }
//        return 0;

        // enum 사용할때
//        return ArithmeticOperator.calculate(operand1, operator, operand2);

        // interface 사용할때
        return arithmeticOperators.stream()
                .filter(arithmeticOperator -> arithmeticOperator.supports(operator))
                .map(arithmeticOperator -> arithmeticOperator.calculate(operand1, operand2))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("올바른 사칙연산이 아닙니다."));
    }
}
