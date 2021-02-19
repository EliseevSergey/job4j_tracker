package ru.job4j.prison;

public class Shooter {
    private Staff staff = new Staff();
    public void release() {
        staff.release(new Convicted());
    }

    public void close(Convicted convicted) {
        staff.close(new Convicted());
    }

    public void shoot() {
    }

    public static void main(String[] args) {
        Shooter zorki = new Shooter();
        zorki.close(new Convicted());
        zorki.shoot();
    }
}
