package org.example.grades;

import java.util.List;

public class GradeCalculator {

    private final Courses course;
    //private final List<Course> courses;

    public GradeCalculator(List<Course> courses) {
        this.course = new Courses(courses);
    }

    public GradeCalculator(Courses course){
        this.course = course;
    }

    public double calcualteGrade() {
        return  course.multiplyCreditAndCourseGrade() / course.calculateTotalCompletedCredit();
    }

}
