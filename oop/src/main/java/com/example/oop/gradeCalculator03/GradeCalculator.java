package com.example.oop.gradeCalculator03;

import java.util.List;

/**
 * packageName    : com.example.oop.gradeCalculator02
 * fileName       : GradeCalculator
 * author         : swch
 * date           : 2022-09-15
 * description    :
 * ===========================================================
 * NOTE
 * 최초 생성
 */
public class GradeCalculator {
//    private List<Course> courses;
    private Courses courses;

    public GradeCalculator(List<Course> courses) {
        this.courses = new Courses(courses);
    }

    /**
     * 요구사항
     *   평균학점 계산 방법 = (학점수×교과목 평점)의 합계/수강신청 총 학점 수
     *   일급 컬렉션 사용
     * @return
     */

    public double calculate() {
//        double sum = 0;
//        for (Course course : courses) {
////            sum += course.getCredit() * course.getGradeToNumber();  // 학점수 * 교과목의 평점(A+은 4.5 A면 4..)
//            sum += course.sumCreditAndCourseGrade();
//        }
        // 학점수×교과목 평점
        double sum = courses.sumCreditAndCourseGrade();

        // 수강신청 총 학점 수
//        int totalCredit = courses.stream()
//                .mapToInt(Course::getCredit)
//                .sum();
        int totalCredit = courses.getTotalCredit();
        return sum/totalCredit;
    }
}
