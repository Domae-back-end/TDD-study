package org.example;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UserTest {

    @DisplayName("비밀번호가 요구사항에 부합되어 초기화 한다.")
    @Test
    void passwordTest() {
        //given
        User user = new User();

        //when
        user.initPassword(new CorrectFixedPasswordGenerator());

        //then
        Assertions.assertThat(user.getPassword()).isNotNull();
    }

    @DisplayName("비밀번호가 요구사항에 부합되지 않아 초기화가 되지 않는다.")
    @Test
    void passwordTest2() {
        //given
        User user = new User();

        //when
        user.initPassword(new WrongCorrectFixedPasswordGenerator());

        //then
        Assertions.assertThat(user.getPassword()).isNull();
    }


}
