package ru.job4j.bank;

import org.junit.Assert;
import org.junit.Test;

import java.util.Optional;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;

public class BankServiceTest {
    @Test
    public void addUser() {
        var bank = new BankService();
        User user = new User("4702 123", "Ivanov Ivan");
        bank.add(user);
        Assert.assertThat(bank.findByPassport("4702 123").get(), is(user));
    }

    @Test
    public void whenEnterInvalidPassport() {
        var bank = new BankService();
        var user = new User("3434", "Petr Arsentev");
        bank.add(user);
        bank.addAccount(user.getPassport(), new Account("5546", 150D));
        Assert.assertThat(bank.findByRequisite("34", "5546"), is(Optional.empty()));
    }

    @Test
    public void addAccount() {
        var user = new User("3434", "Petr Arsentev");
        var bank = new BankService();
        bank.add(user);
        bank.addAccount(user.getPassport(), new Account("5546", 150D));
        Assert.assertThat(bank.findByRequisite("3434", "5546").get().getBalance(), is(150D));
    }

    @Test
    public void transferMoney() {
        var user = new User("3434", "Petr Arsentev");
        var bank = new BankService();
        bank.add(user);
        bank.addAccount(user.getPassport(), new Account("5546", 150D));
        bank.addAccount(user.getPassport(), new Account("113", 50D));
        bank.moneyTransfert(
                user.getPassport(), "5546", user.getPassport(), "113", 150D);
        Assert.assertThat(
                bank.findByRequisite(user.getPassport(), "113").get().getBalance(), is(200D));
        Assert.assertThat(
                bank.findByRequisite(user.getPassport(), "5546").get().getBalance(), is(0D));
    }

    @Test
    public void lowMoney() {
        User user = new User("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.add(user);
        bank.addAccount(user.getPassport(), new Account("5546", 150D));
        bank.addAccount(user.getPassport(), new Account("113", 50D));
        assertFalse(bank.moneyTransfert(user.getPassport(), "5546", user.getPassport(), "113",
                200D));
    }

    @Test
    public void addSecondAccount() {
        User user = new User("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.add(user);
        bank.addAccount(user.getPassport(), new Account("5546", 150D));
        bank.addAccount(user.getPassport(), new Account("666", 777D));
        Assert.assertThat(bank.findByRequisite("3434", "666").get().getBalance(), is(777D));
    }
}