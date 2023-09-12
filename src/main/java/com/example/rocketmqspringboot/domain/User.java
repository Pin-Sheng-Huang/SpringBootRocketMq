package com.example.rocketmqspringboot.domain;

import java.io.Serializable;

/**
 * @program: rocketmqspringboot
 * @description:
 * @Creator: 阿昇
 * @CreateTime: 2023-08-30 19:34
 * @LastEditTime: 2023-08-30 19:34
 */

public class User implements Serializable {
    String username;
    int age;

    public User() {
    }

    public User(String username, int age) {
        this.username = username;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", age=" + age +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
