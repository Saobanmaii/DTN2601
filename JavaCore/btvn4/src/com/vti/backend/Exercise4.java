package com.vti.backend;

import com.vti.entity.Student;

public class Exercise4 {
    public void question1() {
        Student s1 = new Student("Nguyen Van A", "Ha Noi");
        Student s2 = new Student("Tran Thi B", "Ho Chi Minh");
        Student s3 = new Student("Le Van C", "Da Nang");

        s1.setScore(3.5);   
        s2.setScore(5.0);      
        s3.setScore(6.5);       
        s3.addScore(2.0);      

        s1.printInfo();
        s2.printInfo();
        s3.printInfo();
    }
}
