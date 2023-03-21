package com.example.eltex.testlist;

import java.util.Arrays;
import java.util.List;

public class Developer extends User {

    private List<String> languages;

    public Developer(String name, String phone, List<String> languages) {
        super(name, phone);
        this.languages = languages;
    }

    @Override
    public String toString() {
        return "Developer{" +
                "languages=" + languages +
                '}';
    }
}
