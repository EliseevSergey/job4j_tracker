package ru.job4j.search;

import java.util.LinkedList;

public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();

    public void put(Task in) {
        int index = 0;
        for (Task element : tasks) {
            if (in.getPriority() < element.getPriority()) {
                this.tasks.add(index,in);
                break;
            } index++;
        }
        this.tasks.add(index,in);
    }

    public Task take() {
        return tasks.poll();
    }
}