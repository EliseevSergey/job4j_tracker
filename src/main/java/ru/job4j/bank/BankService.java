package ru.job4j.bank;

import java.util.*;

/**
 * Класс описывает работу элементарного банковского сервиса для
 * - учета клиентов и их счетов.
 * - денежных операции со счетами клиентов
 * @author ELISEEV
 * @version 1.0
 */
public class BankService {
    /**
     * Хранение пар данных(пользователь и его счета) производится
     * в поле users ввиде коллеции типа Map.
     * Список счетов клиента хранится в коллекции List
     */
    private Map<User, List<Account>> users = new HashMap<>();

    /**
     * метод добавляет Клиента банка в базу, если ранее он отсутвовал.
     *
     * @param user Добавляемый Клиент
     */
    public void add(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    /**
     * метод добавляет новый счет пользователя, предварительно проверив,
     * что такого счета у клиента нет.
     *
     * @param passport номер паспорта клиента
     * @param account  добавляемый счет
     */
    public void addAccount(String passport, Account account) {
        Optional<User> user = findByPassport(passport);
        if (user.isPresent() && !users.get(user.get()).contains(account)) {
            users.get(user.get()).add(account);
        }
    }
    /**
     * метод выполняет поиск Клиента по номеру паспорта
     *
     * @param passport номер паспорта клиента
     * @return возвращает обьект Клиент
     */

/*    public User findByPassport(String passport) {
*//*        User rsl = null;
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                rsl = user;
                break;
            }
        }
        return rsl;
    }*//*
        return users.keySet().stream()
                .filter(user -> user.getPassport().equals(passport))
                .findFirst()
                .orElse(null);
    }*/

    public Optional<User> findByPassport(String passport) {
        return users.keySet().stream()
                .filter(user -> user.getPassport().equals(passport))
                .findFirst();
    }
    /**
     * метод выполняет поиск счета по номеру паспорта клиента и реквизитам счета
     *
     * @param passport
     * @param requisite
     * @return счет пользователя
     */

/*    public Account findByRequisite(String passport, String requisite) {
*//*        Account rsl = null;
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
    }*//*
        User user = findByPassport(passport);
        if (user != null) {
            return users.get(user)
                    .stream()
                    .filter(account -> account.getRequisite().equals(requisite))
                    .findFirst().orElse(null);
        }
        return null;
    }*/

    public Optional<Account> findByRequisite(String passport, String requisite) {
        Optional<User> user = findByPassport(passport);
        if (user.isPresent()) {
            return users.get(user.get())
                    .stream()
                    .filter(account -> account.getRequisite().equals(requisite))
                    .findFirst();
        }
        return Optional.empty();
    }

    /**
     * метод осуществляет перевод денежных средств между Клиентами банка
     * и счетами отдельного клиента
     * @param srcPassport номер паспорта отправителя
     * @param scrRequisite номер счета отправителя
     * @param desPassport номер паспорта получятеля
     * @param destRequsite номер счета получателя
     * @param amount сумма для перевода
     * @return результат перевода
     * True если перевод выполнен успешно
     * False в случаях
     * - на счету отправителя недостаточно средств
     * - не найдены клиенты по номеру паспортов или их счета
     */

    public boolean moneyTransfert(String srcPassport, String scrRequisite, String desPassport,
                                  String destRequsite, double amount) {
        boolean rsl = false;
        Optional<Account> sender = findByRequisite(srcPassport, scrRequisite);
        Optional<Account> receiver = findByRequisite(desPassport, destRequsite);
        if (sender.isPresent() && receiver.isPresent() && sender.get().getBalance() >= amount) {
            receiver.get().setBalance(receiver.get().getBalance() + amount);
            sender.get().setBalance(sender.get().getBalance() - amount);
            rsl = true;
        }
        return rsl;
    }
}
