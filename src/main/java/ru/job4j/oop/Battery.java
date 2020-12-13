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
        Battery Nokia = new Battery(97);
        Battery iPhone = new Battery(3);
        System.out.println("Nokia:" + Nokia.load + " %" + " iPhone:" + iPhone.load + " %");
        Nokia.exchange(iPhone);
        System.out.println(iPhone.load + " %");
        System.out.println("Nokia:" + Nokia.load + " %" + " iPhone:" + iPhone.load + " %");
    }
}
