package com.example.eltex.testlist;

import java.util.Arrays;

public class Manager extends User implements CSV {

    public static final String TYPE = "M";

    private Integer countProjects;

    public Manager() {}

    public Manager(String name, String phone, Integer countProjects) {
        super(name, phone);
        this.countProjects = countProjects;
    }

    public Manager(Integer id, String name, String phone, Integer countProjects) {
        super(id, name, phone);
        this.countProjects = countProjects;
    }

    @Override
    public String getType() {
        return TYPE;
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
