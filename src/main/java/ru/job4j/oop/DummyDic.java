package ru.job4j.oop;

public class DummyDic {
    public String engToRus(String eng) {
        String result = "Неизвестное слово" + eng;
        return result;
    }

    public static void main(String[] args) {
        DummyDic dictionary = new DummyDic();
        String word = dictionary.engToRus("lolka");
        System.out.println(word);
    }
}
