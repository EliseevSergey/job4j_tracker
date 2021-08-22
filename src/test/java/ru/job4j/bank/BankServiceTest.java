package ru.job4j.bank;

import org.junit.Assert;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;

public class BankServiceTest {
    @Test
    public void addUser() {
        BankService bank = new BankService();
        User user = new User("4702 123", "Ivanov Ivan");
        bank.add(user);
        Assert.assertThat(bank.findByPassport("4702 123"), is(user));
    }

    @Test
    public void whenEnterInvalidPassport() {
        BankService bank = new BankService();
        User user = new User("3434", "Petr Arsentev");
        bank.add(user);
        bank.addAccount(user.getPassport(), new Account("5546", 150D));
        assertNull(bank.findByRequisite("34", "5546"));
    }

    @Test
    public void addAccount() {
        User user = new User("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.add(user);
        bank.addAccount(user.getPassport(), new Account("5546", 150D));
        Assert.assertThat(bank.findByRequisite("3434", "5546").getBalance(), is(150D));
    }

    @Test
    public void transferMoney() {
        User user = new User("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.add(user);
        bank.addAccount(user.getPassport(), new Account("5546", 150D));
        bank.addAccount(user.getPassport(), new Account("113", 50D));
        bank.moneyTransfert(user.getPassport(), "5546", user.getPassport(), "113", 150D);
        Assert.assertThat(bank.findByRequisite(user.getPassport(), "113").getBalance(), is(200D));
        Assert.assertThat(bank.findByRequisite(user.getPassport(), "5546").getBalance(), is(0D));
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
        Assert.assertThat(bank.findByRequisite("3434", "666").getBalance(), is(777D));
    }
}