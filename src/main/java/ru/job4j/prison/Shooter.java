package ru.job4j.prison;

public class Shooter {
    private Staff staff = new Staff();
    public void release() {
        staff.release(new Convicted());
    }

    public void release(Convicted convicted) {
        staff.release(new Convicted());
    }

    public void shoot() {
    }

    public static void main(String[] args) {
        Shooter zorki = new Shooter();
        zorki.release(new Convicted());
        zorki.shoot();
    }
}
