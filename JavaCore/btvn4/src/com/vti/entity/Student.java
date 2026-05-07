package com.vti.entity;

public class Student {
    private static int counter = 1;

    private int id;
    private String name;
    private String hometown;
    private double score;

    // (b) Constructor: nhận name, hometown — score mặc định = 0
    public Student(String name, String hometown) {
        this.id = counter++;
        this.name = name;
        this.hometown = hometown;
        this.score = 0;
    }

    // (c) Set điểm (thay thế toàn bộ)
    public void setScore(double score) {
        this.score = score;
    }

    // (d) Cộng thêm điểm
    public void addScore(double points) {
        this.score += points;
    }

    // (e) In thông tin kèm xếp loại học lực
    public void printInfo() {
        String rank;
        if (score < 4.0)       rank = "Yếu";
        else if (score < 6.0)  rank = "Trung bình";
        else if (score < 8.0)  rank = "Khá";
        else                   rank = "Giỏi";

        System.out.println("ID: " + id + " | Tên: " + name
                + " | Quê: " + hometown
                + " | Điểm: " + score + " (" + rank + ")");
    }
}
