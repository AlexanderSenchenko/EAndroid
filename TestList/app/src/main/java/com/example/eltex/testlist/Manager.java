package com.example.eltex.testlist;

public class Manager extends User implements CSV {

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

    @Override
    public String toCSV() {
        return null;
    }

    @Override
    public void fromCSV(String str) {

    }
}
