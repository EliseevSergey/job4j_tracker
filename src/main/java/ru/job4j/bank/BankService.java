package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();

    public void add (User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if(!users.get(user).contains(account)) {
            users.get(user).add(account);
        }
    }
    
    public User findByPassport(String passport) {
        User rsl = new User("-1", "-1");
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
        if (findByPassport(passport).getPassport() != "-1") {
            User user = findByPassport(passport);
            for (Account account : users.get(user)) {
                if (account.getRequisite().equals(requisite)) {
                    rsl = account;
                    break;
                }
            }
        }
        return rsl;
    }

    public boolean moneyTransfert(String srcPassport, String scrRequisite, String desPassport, String destRequsite, double amount){
       boolean rsl = false;
       User sender = findByPassport(srcPassport);
       Account senderAccount = findByRequisite(srcPassport, scrRequisite);
       User receiver = findByPassport(desPassport);
       Account receiverAccount = findByRequisite(desPassport, destRequsite);
       if (users.containsKey(sender) && users.containsKey(receiver) && (senderAccount.getBalance() >= amount)) {
           receiverAccount.setBalance(receiverAccount.getBalance() + amount);
           senderAccount.setBalance(senderAccount.getBalance() - amount);
           rsl = true;
       }
       return rsl;
    }
}
