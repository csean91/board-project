package com.example.calculator;

import com.example.calculator.calculate.PositiveNumber;

import java.util.Arrays;

/**
 * packageName    : com.example.oop
 * fileName       : ArithmeticOperator
 * author         : swch
 * date           : 2022-09-13
 * description    :
 * ===========================================================
 * NOTE
 * 최초 생성
 */
public enum ArithmeticOperator {
    // 하단에 정의한 추상 메소드에 대해 정의해줘야 함
    ADDITION("+") {
        @Override
        public int arithmeticCalculate(int operand1, int operand2) {
            return operand1 + operand2;
        }
    },
    SUBTRACTION("-") {
        @Override
        public int arithmeticCalculate(int operand1, int operand2) {
            return operand1 - operand2;
        }
    },
    MULTIPLICATION("*") {
        @Override
        public int arithmeticCalculate(int operand1, int operand2) {
            return operand1 * operand2;
        }
    },
    DIVISION("/") {
        @Override
        public int arithmeticCalculate(int operand1, int operand2) {
            if (operand2 == 0) {
                throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
            }
            return operand1 / operand2;
        }
    };

    private final String operator;

    ArithmeticOperator(String operator) {
        this.operator = operator;
    }

    protected abstract int arithmeticCalculate(final int operand1, final int operand2);

    /**
     * 외부에 노출되는 함수
     * @param operand1
     * @param operator
     * @param operand2
     * @return
     */
    public static int calculate(PositiveNumber operand1, String operator, PositiveNumber operand2) {
        ArithmeticOperator arithmeticOperator = Arrays.stream(values()) // 모든 enum값
                .filter(v -> v.operator.equals(operator))    // 연산자 확인
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("올바른 사칙연산이 아닙니다."));
        return arithmeticOperator.arithmeticCalculate(operand1.toInt(), operand2.toInt());
    }
}
