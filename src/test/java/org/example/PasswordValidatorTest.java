package org.example;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


/**
 * 비밀번호는 최소 8자 이상 12자 이하여야 한다.
 * 비밀번호가 8자 미만 또는 12자 초과인 경우 IllegalArgumentException 예외를 발생.
 * NBSP 경계조건에 대해 테스트 코드를 작성해야 한다.
 */
public class PasswordValidatorTest {

    @DisplayName("비밀번호는 최소 8자 이상 12자 이하면 예외가 발생하지 않는다.")
    @Test
    void validatePasswordTest() {
        //메인에 있는 매서드를 통해 접근하여 값을 주고 오류가 나오는지 확인.
        Assertions.assertThatCode(() -> PasswordValidator.validate("12345678912"))
                .doesNotThrowAnyException();
    }

    @DisplayName("비밀번호가 8자 미만 또는 12자 초과인 경우 IllegalArgumentException 예외를 발생.")
    @Test
    void validatePasswordTest2() {
        //만약 오류 발생시 IllegalArgumentException 라는 객체의 오류 인지? 확인후
        //그 문자가 만약 비밀번호는 최소 8자 이상 12자 이하여야 한다. 인지도 확인.
        Assertions.assertThatCode(() -> PasswordValidator.validate("1234567"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("비밀번호는 최소 8자 이상 12자 이하여야 한다.");
    }

    @DisplayName("비밀번호가 8자 미만 또는 12자 초과인 경우 IllegalArgumentException 예외를 발생.")
    @ParameterizedTest //다른것들은 주소 참고. -> https://www.petrikainulainen.net/programming/testing/junit-5-tutorial-writing-parameterized-tests/
    @ValueSource(strings = {"123456", "123456789123"})
    void validatePasswordTest3(String password) {
        //ParameterizedTest 는
        //ValueSource 에 있는 값들을 validatePasswordTest3 매서드의 매개변수로 넣어줘서 테스트 진행.
        Assertions.assertThatCode(() -> PasswordValidator.validate(password))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("비밀번호는 최소 8자 이상 12자 이하여야 한다.");
    }


}
