package ru.job4j.oop;

public class Jukebox {
    public void music(int position) {
        if (position == 1) {
            System.out.println("Let it runs awkwardly");
        }
        if (position == 2) {
            System.out.println("Good night");
        }
        else {
            System.out.println("Song was not found");
        }
    }

    public static void main(String[] args) {
        Jukebox Player = new Jukebox();
        Player.music(1);
        Player.music(2);
        Player.music(13);
    }
}
