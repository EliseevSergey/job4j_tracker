package ru.job4j.oop;

public class Battery {
    private int load;

    public Battery(int level) {
        this.load = level;
    }
    public void exchange(Battery another) {
       this.load = this.load + another.load;
       another.load = 0;
    }

    public static void main(String[] args) {
        Battery Nokia = new Battery(97);
        Battery iPhone = new Battery(3);
        System.out.println("Nokia:" + Nokia.load + " %" + " iPhone:" + iPhone.load + " %");
        iPhone.exchange(Nokia);
        System.out.println(iPhone.load + " %");
        System.out.println("Nokia:" + Nokia.load + " %" + " iPhone:" + iPhone.load + " %");
    }
}
