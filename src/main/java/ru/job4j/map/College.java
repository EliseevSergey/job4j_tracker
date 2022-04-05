package ru.job4j.map;

import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class College {
    private Map<Student, Set<Subject>> students;

    public College(Map<Student, Set<Subject>> students) {
        this.students = students;
    }

    public Optional<Student> findByAccount(String account) {
        Optional rsl = Optional.empty();
        for (Student stndt : students.keySet()) {
            if (stndt.getAccount().equals(account)) {
                rsl = Optional.of(stndt);
                break;
            }
        }
        return rsl;
    }

    public Optional<Subject> findBySubjectName(String account, String name) {
        Optional rsl = Optional.empty();
        Optional<Student> student = findByAccount(account);
        if (student.isPresent()) {
            Set<Subject> subjects = students.get(student.get());
            for (Subject sbjct : subjects) {
                System.out.println(sbjct);
                if (sbjct.getName().equals(name)) {
                    rsl = Optional.of(sbjct);
                    break;
                }
            }
        }
        return rsl;
    }
}

