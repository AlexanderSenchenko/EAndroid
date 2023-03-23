package com.example.eltex.testlist;

import java.util.Arrays;
import java.util.List;

public class Developer extends User implements CSV {

    private List<String> languages;

    public Developer() {}

    public Developer(String name, String phone, List<String> languages) {
        super(name, phone);
        this.languages = languages;

        System.out.println(toCSV());
    }

    @Override
    public String toString() {
        return "Developer{" +
                "languages=" + languages +
                '}';
    }

    @Override
    public String toCSV() {
        return getName() + ";" + getPhone() + ";" + String.join(",", languages);
    }

    @Override
    public void fromCSV(String str) {
        String[] strings = str.split(";");

        setName(strings[0]);
        setPhone(strings[1]);
        languages = Arrays.asList(strings[2].split(","));
    }
}
