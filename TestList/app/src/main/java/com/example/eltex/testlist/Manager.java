package com.example.eltex.testlist;

public class Manager extends User {

    Integer countProjects;

    public Manager(String name, String phone, Integer countProjects) {
        super(name, phone);
        this.countProjects = countProjects;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "countProjects=" + countProjects +
                '}';
    }
}
