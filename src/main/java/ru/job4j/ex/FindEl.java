package ru.job4j.ex;

public class FindEl {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int rsl = -1;
        for (int index = 0; index < value.length; index++) {
            if (value[index].equals(key)) {
                rsl = index;
                break;
            }
        }
            if (rsl == -1) {
                throw new ElementNotFoundException("Nothing was found");
            }
            return rsl;
        }

        public static void main (String[]args) {
            String[] pool = new String[]{"aa", "bb", "cc"};
            try {
                System.out.println(FindEl.indexOf(pool, "cc"));
            }
            catch (ElementNotFoundException e) {
                e.printStackTrace();
            }
    }
}



