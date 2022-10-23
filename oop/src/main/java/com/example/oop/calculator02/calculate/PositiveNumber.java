package com.example.oop.calculator02.calculate;

/**
 * packageName    : com.example.oop.calculator01.calculate
 * fileName       : PositiveNumber
 * author         : swch
 * date           : 2022-09-14
 * description    :
 * ===========================================================
 * NOTE
 * 최초 생성
 */
public class PositiveNumber {
    private final int value;

    public PositiveNumber(int value) {
        validate(value);
        this.value = value;
    }

    private void validate(int value) {
        if (isNotPositiveNumber(value)) {
            throw new IllegalArgumentException("0보다 커야 합니다.");
        }
    }

    /**
     * 0과 음수를 체크하는 함수
     * @param value
     * @return
     */
    private boolean isNotPositiveNumber(int value) {
        return value <= 0;
    }

    /**
     * 양수값이면 return
     * @return
     */
    public int toInt() {
        return value;
    }
}
