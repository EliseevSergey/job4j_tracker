package ru.job4j.poly;

public interface Transport {
    void go();

    void passagers(int passagers);

    int price(int fuel);
}
