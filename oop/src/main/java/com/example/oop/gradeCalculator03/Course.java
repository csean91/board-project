package com.example.oop.gradeCalculator03;

/**
 * packageName    : com.example.oop.gradeCalculator02
 * fileName       : Course
 * author         : swch
 * date           : 2022-09-15
 * description    :
 * ===========================================================
 * NOTE
 * 최초 생성
 */
public class Course {
    private String subject;     // 과목명
    private int credit;         // 학점
    private String grade;       // 성적
    public Course(String subject, int credit, String grade) {
        this.subject = subject;
        this.credit = credit;
        this.grade = grade;
    }

    public int getCredit() {
        return credit;
    }

    public double getGradeToNumber() {
        double grade = 0;
        switch (this.grade) {
            case "A+":  grade = 4.5; break;
            case "A":   grade = 4.0; break;
            case "B+":  grade = 3.5; break;
            case "B":   grade = 3.0; break;
            case "C+":  grade = 2.5; break;
            case "C":   grade = 2.0; break;
        }
        return grade;
    }

    /**
     * 학점수 * 교과목의 평점
     * @return
     */
    public double sumCreditAndCourseGrade() {
        return credit * getGradeToNumber();
    }
}
