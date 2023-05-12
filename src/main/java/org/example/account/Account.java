package org.example.account;

import java.util.Objects;

public class Account {

    private int money;
    private final String name;

    public Account(String name, int money) {
        this.money = money;
        this.name = name;
    }

    public boolean matches(String name){
        return this.name == name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Account)) return false;
        Account that = (Account) o;
        return money == that.money && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(money, name);
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
