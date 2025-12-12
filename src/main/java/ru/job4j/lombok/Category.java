package ru.job4j.lombok;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Category {
    @Getter
    @EqualsAndHashCode.Include
    private int id;
    @Getter
    @Setter
    @EqualsAndHashCode.Exclude
    private String name;
}