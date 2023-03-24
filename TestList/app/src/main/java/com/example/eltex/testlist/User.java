package com.example.eltex.testlist;

import androidx.annotation.NonNull;

public abstract class User {

    private Integer id;
    private String name;
    private String phone;

    public User() {}

    public User(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public abstract String toString();
}
