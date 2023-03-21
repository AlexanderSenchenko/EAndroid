package ru.eltex;

import java.util.List;

public class Developer extends User {

    private List<String> languages;

    public Developer() {}

    Developer(Integer id, String name, List<String> languages) {
        super(id, name);
        this.languages = languages;
    }

    public String toString() {
        return "Developer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", languages=" + languages.toString() +
                '}';
    }

    public List<String> getLanguages() {
        return languages;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }
}
