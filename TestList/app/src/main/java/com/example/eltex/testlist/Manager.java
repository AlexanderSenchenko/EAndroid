package com.example.eltex.testlist;

import java.util.Arrays;

public class Manager extends User implements CSV {

    private Integer countProjects;

    public Manager() {}

    public Manager(String name, String phone, Integer countProjects) {
        super(name, phone);
        this.countProjects = countProjects;

        System.out.println(toCSV());
    }

    @Override
    public String toString() {
        return "Manager{" +
                "countProjects=" + countProjects +
                '}';
    }

    @Override
    public String toCSV() {
        return getName() + ";" + getPhone() + ";" + countProjects;
    }

    @Override
    public void fromCSV(String str) {
        String[] strings = str.split(";");

        setName(strings[0]);
        setPhone(strings[1]);
        countProjects = Integer.valueOf(strings[2]);
    }
}
