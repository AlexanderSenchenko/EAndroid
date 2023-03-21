package com.example.eltex.testlist;

import androidx.annotation.NonNull;

public class User {

    private static Integer counter = 1;
    private Integer id;
    private String name;
    private String phone;

    public User(String name, String phone) {
        this.id = counter++;
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
