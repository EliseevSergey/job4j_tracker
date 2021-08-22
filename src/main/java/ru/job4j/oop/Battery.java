package ru.job4j.oop;

public class Battery {
    private int load;

    public Battery(int level) {
        this.load = level;
    }

    public void exchange(Battery another) {
       another.load = this.load + another.load;
       this.load = 0;
    }

    public static void main(String[] args) {
        Battery nokia = new Battery(97);
        Battery iPhone = new Battery(3);
        System.out.println("Nokia:" + nokia.load + " %" + " iPhone:" + iPhone.load + " %");
        nokia.exchange(iPhone);
        System.out.println("Nokia:" + nokia.load + " %" + " iPhone:" + iPhone.load + " %");
    }
}
