package com.codejr.schedule.model;

import java.util.Date;
public class Contact {
    private Long id;
    private String name;
    private int age;
    private Date registerDate;

    public Contact(String name, int age, Date registerDate) {
        this.name = name;
        this.age = age;
        this.registerDate = registerDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", registerDate=" + registerDate +
                '}';
    }
}
