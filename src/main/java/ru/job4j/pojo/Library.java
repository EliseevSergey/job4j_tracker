package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book mumu = new Book("Mumu", 20);
        Book ustav = new Book("Ustav", 666);
        Book idiot = new Book("Idiot", 444);
        Book cleanCode = new Book("Clean code", 999);
        Book shelf = new Book(null, 0);
        Book[] library = new Book[4];
        library[0] = mumu;
        library[1] = ustav;
        library[2] = idiot;
        library[3] = cleanCode;
        for (int index = 0; index < library.length; index++) {
            System.out.println("index " + index + " name: " + library[index].getName()
                    + " page: " + library[index].getPage());
        }
        library[0] = shelf;
        library[0] = library[3];
        library[3] = shelf;
        for (int index = 0; index < library.length; index++) {
            System.out.println("index " + index + " name: " + library[index].getName()
                    + " page: " + library[index].getPage());
        }
        for (int index = 0; index < library.length; index++) {
            if (library[index].getName().equals("Clean code")) {
                System.out.println(library[index].getName());
            }
        }
    }
}

