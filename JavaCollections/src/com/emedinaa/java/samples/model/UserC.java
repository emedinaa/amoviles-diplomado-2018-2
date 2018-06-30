package com.emedinaa.java.samples.model;

import org.jetbrains.annotations.NotNull;

public class UserC implements Comparable{

    private int id;
    private String name;
    private int age;
    private String info;

    public UserC(int id, String name, int age, String info) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.info = info;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    /*@Override
    public int compareTo(@NotNull UserC userC) {
        int compareAge= userC.getAge();
        return this.age-compareAge;
    }*/

    @Override
    public int compareTo(@NotNull Object object) {
        int compareAge= ((UserC)(object)).getAge();
        return this.age-compareAge;
    }

    @Override
    public String toString() {
        return "UserC{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", info='" + info + '\'' +
                '}';
    }
}
