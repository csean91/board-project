package com.example.oop.gradeCalculator03;

import java.util.List;

/**
 * 일급 콜렉션
 */
public class Courses {
    private final List<Course> courses;

    public Courses(List<Course> courses) {
        this.courses = courses;
    }

    /**
     * 학점수×교과목 평점
     * @return
     */
    public double sumCreditAndCourseGrade() {
//        double sum = 0;
//        for (Course course : courses) {
////            sum += course.getCredit() * course.getGradeToNumber();  // 학점수 * 교과목의 평점(A+은 4.5 A면 4..)
//            sum += course.sumCreditAndCourseGrade();
//        }
//        return sumCreditAndCourseGrade();
        return courses.stream()
                .mapToDouble(Course::sumCreditAndCourseGrade)
                .sum();
    }

    /**
     * 수강신청 총학점 수
     * @return
     */
    public int getTotalCredit() {
        return courses.stream()
                .mapToInt(Course::getCredit)
                .sum();
    }
}
