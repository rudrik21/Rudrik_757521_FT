package com.example.rudrik_757521_ft.models;

import com.example.rudrik_757521_ft.Utils;

import java.io.Serializable;
import java.util.ArrayList;

public class User implements Serializable {

    private int avatar;
    private String name;
    private String email;
    private String phone;

    public static ArrayList<User> listUsers = new ArrayList<>();

    public User(String name, String email, String phone) {
        this.avatar = Utils.getShuffledUserImages().get(0);
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public int getAvatar() {
        return avatar;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
