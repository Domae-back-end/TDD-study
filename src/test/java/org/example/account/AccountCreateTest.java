package org.example.account;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * 1. 계좌생성하는 기능이 필요하며 생성과 동시에 입금을 하는 경우가 빈번합니다.
 * 2. 계좌에 입금, 출금을 할 수 있어야합니다.
 * 3. 잔고조회가 가능해야합니다.
 * 계좌
 */
public class AccountCreateTest {

    @DisplayName("계좌를 생성하고 입금한다.")
    @Test
    void createAccount() {
        //given
        List<Account> list = List.of(
                new Account("켈빈",1000),
                new Account("이수",20000),
                new Account("수빈",5000)
        );
        AccountList accountList = new AccountList(list);

        //when
        accountList.sendAccount("켈빈",100);

        //given
        Assertions.assertThat(accountList.choose("켈빈").getMoney())
                .isEqualTo(1100);

    }

    @DisplayName("계좌 입금 출금")
    @Test
    void accountInputAndOutput() {

        //given
        List<Account> list = List.of(
                new Account("켈빈",1000),
                new Account("이수",20000),
                new Account("수빈",5000)
        );
        AccountList accountList = new AccountList(list);

        //when
        accountList.outAccount("켈빈",100); //켈빈 계좌 출금
        accountList.sendAccount("이수",100); //이수 계좌 입금.

        //given
        Assertions.assertThat(accountList.choose("켈빈").getMoney())
                .isEqualTo(900);
        Assertions.assertThat(accountList.choose("이수").getMoney())
                .isEqualTo(20100);
    }

    @DisplayName("계좌 잔액 확인.")
    @Test
    void accountCheck() {

        //given
        List<Account> list = List.of(
                new Account("켈빈",1000),
                new Account("이수",20000),
                new Account("수빈",5000)
        );
        AccountList accountList = new AccountList(list);

        //when
        int checkMoney = accountList.choose("이수").getMoney();

        //given
        Assertions.assertThat(checkMoney)
                .isEqualTo(20000);
    }
}
