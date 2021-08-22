package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();

    public void add(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null && !users.get(user).contains(account)) {
            users.get(user).add(account);
        }
    }

    public User findByPassport(String passport) {
        User rsl = null;
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                rsl = user;
                break;
            }
        }
        return rsl;
    }

    public Account findByRequisite(String passport, String requisite) {
        Account rsl = null;
        User user = findByPassport(passport);
        if (user != null) {
            for (Account account : users.get(user)) {
                if (account.getRequisite().equals(requisite)) {
                    rsl = account;
                    break;
                }
            }
        }
        return rsl;
    }

    public boolean moneyTransfert(String srcPassport, String scrRequisite, String desPassport,
                                  String destRequsite, double amount) {
        boolean rsl = false;
        Account sender = findByRequisite(srcPassport, scrRequisite);
        Account receiver = findByRequisite(desPassport, destRequsite);
        if (sender != null && receiver != null && sender.getBalance() >= amount) {
            receiver.setBalance(receiver.getBalance() + amount);
            sender.setBalance(sender.getBalance() - amount);
            rsl = true;
        }
        return rsl;
    }
}
