package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book Mumu = new Book("Mumu", 20);
        Book Ustav = new Book("Ustav", 666);
        Book Idiot = new Book("Idiot", 444);
        Book CleanCode = new Book("Clean code",999);
        Book Shelf = new Book(null, 0);
        Book[] library = new Book[4];
        library[0] = Mumu;
        library[1] = Ustav;
        library[2] = Idiot;
        library[3] = CleanCode;
        for (int index = 0; index < library.length ; index++) {
            System.out.println("index " + index + " name: " + library[index].getName() + " page: " + library[index].getPage());
        }

        library[0] = Shelf; // можно и просто переназначить без временной переменной
        library[0] = library[3];
        library[3] = Shelf;

        for (int index = 0; index < library.length ; index++) {
            System.out.println("index " + index + " name: " + library[index].getName() + " page: " + library[index].getPage());
        }

        for (int index = 0; index < library.length ; index++) {
             if (library[index].getName().equals("Clean code"))
                 System.out.println(library[index].getName());
            }
        }
    }

