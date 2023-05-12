package org.example.grades;

import java.util.List;

public class Courses {
    //일급 컬렉션.
    private final List<Course> courses;

    public Courses(List<Course> courses) {
        this.courses = courses;
    }

    public double multiplyCreditAndCourseGrade() {
        return courses.stream()
                .mapToDouble(Course::multiplyCreditAndCourseGrade)
                .sum();
        //아래에 있느 내용을 위에 있는 내용으로 줄일수 있다.
        //double multipliedCreditAndCourseGrade = 0;

        //for (Course course : courses) {
         //   multipliedCreditAndCourseGrade += course.multiplyCreditAndCourseGrade();
        //}
        //return multipliedCreditAndCourseGrade;
    }

    public int calculateTotalCompletedCredit() {
        //수강신청 총학점 수
        int totalCompletedCredit = courses.stream()
                .mapToInt(Course::getCredit)
                .sum();
        return totalCompletedCredit;
    }

}
