package org.example.grades;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

/*
* • 요구사항
• 평균학점 계산 방법 = (학점수×교과목 평점)의 합계/수강신청 총학점 수
• MVC패턴(Model-View-Controller) 기반으로 구현한다.
• 일급 컬렉션 사용
* */
public class GradeCalculatorTest {
    //학점 계산기 도메인 : 이수한 과목들, 학점 계산기
    //이수한 과목을 가지고 학점계산기로 계산하면 될것같다.
    //이수한 과목 : 수학, 과학
    //학점 계산기 : 학점계산
    //이수한 과목을 전달하여 평균학점 계산 요청 ----> 학점 계산기 ----> (학점수×교과목 평점)의 합계
    //                                                   ---->  수강신청 총학점 수


    @Test
    @DisplayName("데이터를 주고 계산한 결과값 확인")
    void calculateGradeTest(){
        List<Course> courses = List.of(
                new Course("OOP",3,"A+"),
                new Course("자료구조",3,"A+")
        );

        GradeCalculator gradeCalculator = new GradeCalculator(courses);
        double gradeResult = gradeCalculator.calcualteGrade();

        Assertions.assertThat(gradeResult).isEqualTo(4.5);

    }

}
