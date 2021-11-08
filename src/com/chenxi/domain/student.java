package com.chenxi.domain;

public class student {
    private String id;
    private String name;
    private int age;
    private String birthday;

    public student() {
    }

    public student(String id, String name, int age, String birthday) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getbirthday() {
        return this.birthday;
    }

    public void setbirthday(String birthday) {
        this.birthday = birthday;
    }

}
