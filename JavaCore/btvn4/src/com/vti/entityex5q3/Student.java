package com.vti.entityex5q3;

public abstract class Student extends Person {
    private int id;

    public Student(int id, String name) {
        super(name); // Gọi constructor của class Person
        this.id = id;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
}
