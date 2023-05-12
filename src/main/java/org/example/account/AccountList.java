package org.example.account;

import java.util.List;

public class AccountList {

    List<Account> accountList;

    public AccountList(List<Account> accountList) {
        this.accountList = accountList;
    }

    public void sendAccount(String name, int money){
        Account account = choose(name);
        account.setMoney(account.getMoney()+money);
    }

    public void outAccount(String name, int money){
        Account account = choose(name);
        account.setMoney(account.getMoney()-money);
    }

    public Account choose(String name){
        return accountList.stream()
                .filter(account -> account.matches(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("잘못된 계좌 이름입니다."));
    }

}
