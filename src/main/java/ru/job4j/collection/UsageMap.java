package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> rockLegends = new HashMap<>();
        rockLegends.put("stranger@gmail.com", "Morrison Jim");
        rockLegends.put("leftfender@gmail.com", "Hendrix Jimmy");
        rockLegends.put("ledbaloon@gmail.com", "Page Jimmy");
        for (String keyMail : rockLegends.keySet()) {
            String person = rockLegends.get(keyMail);
            System.out.println("key(@Mail): " + keyMail + ". Value(Person): " + person);
        }
    }
}
