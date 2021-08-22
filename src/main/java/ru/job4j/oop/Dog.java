package ru.job4j.oop;

public class Dog {
    private String name;
    private String food;

    public void givenNick(String nick) {
        this.name = nick;
    }

    public void eat(String choice) {
        this.food = choice;
    }

    public void show() {
        System.out.println(this.name + " eat " + this.food);
    }

    public static void main(String[] args) {
            Dog polkan = new Dog();
            polkan.givenNick("Polkan");
            polkan.eat("bone");
            polkan.show();
            Dog sharik = new Dog();
            sharik.givenNick("Sharik");
            sharik.eat("sosisku");
            sharik.show();
    }
}
