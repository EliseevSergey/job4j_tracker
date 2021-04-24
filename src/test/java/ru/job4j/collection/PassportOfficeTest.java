package ru.job4j.collection;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PassportOfficeTest {

@Test
    public void add() {
    PassportOffice office = new PassportOffice();
    HashMap<String, Citizen> citizens = new HashMap<>();
    Citizen ivanov = new Citizen("123123", "Ivanov Stepan");
    office.add(ivanov);
    assertThat(office.get(ivanov.getPassport()), is(ivanov));
    }

    @Test
    public void duplication() {
        PassportOffice office = new PassportOffice();
        HashMap<String, Citizen> citizens = new HashMap<>();
        Citizen ivanov = new Citizen("123123", "Ivanov Stepan");
        office.add(ivanov);
        Assert.assertFalse(office.add(ivanov));
    }
}