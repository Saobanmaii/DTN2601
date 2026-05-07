package com.vti.backend;

import Entity.Department;

import java.util.Arrays;
import java.util.Comparator;

public class Ex5 {
    // Question1: In ra thông tin của phòng ban thứ 1 (sử dụng toString())
    public static void question1( Department department) {
        System.out.println("===== Question 1 =====");
        System.out.println(department);
    }

    public static void question2(Department[] departments) {
        System.out.println("\n===== Question 2 =====");
        for (Department department : departments) {
            System.out.println(department);
        }
    }
    // Question 3: In ra địa chỉ của phòng ban thứ 1
    public static void question3(Department department) {
        System.out.println("\n===== Question 3 =====");
        System.out.println(department.hashCode());
    }

    // Question 4: Kiểm tra xem phòng ban thứ 1 có tên là "Phòng A" không?
    public static void question4(Department department1) {
        System.out.println("\n===== Question 4 =====");
        if (department1.getDepartmentName().equals("Phòng A")) {
            System.out.println("Phòng ban thứ 1 có tên là 'Phòng A'");
        } else {
            System.out.println("Phòng ban thứ 1 không có tên là 'Phòng A', tên là: " + department1.getDepartmentName());
        }
    }

    // Question 5: So sánh 2 phòng ban thứ 1 và phòng ban thứ 2 xem có bằng nhau không
    // (bằng nhau khi tên của 2 phòng ban đó bằng nhau)
    public static void question5(Department department1, Department department2) {
        System.out.println("\n===== Question 5 =====");
        if (department1.getDepartmentName().equals(department2.getDepartmentName())) {
            System.out.println("Hai phòng ban bằng nhau (có cùng tên)");
        } else {
            System.out.println("Hai phòng ban không bằng nhau");
            System.out.println("Phòng ban 1: " + department1.getDepartmentName());
            System.out.println("Phòng ban 2: " + department2.getDepartmentName());
        }
    }

    // Question 6: Khởi tạo 1 array phòng ban gồm 5 phòng ban,
    // sau đó in ra danh sách phòng ban theo thứ tự tăng dần theo tên (sắp xếp theo vần ABCD)
    public static void question6() {
        System.out.println("Question 6: Danh sách phòng ban theo thứ tự ABCD");
        Department[] departments = new Department[5];
        departments[0] = new Department(1, "Sale");
        departments[1] = new Department(2, "Marketing");
        departments[2] = new Department(3, "Accounting");
        departments[3] = new Department(4, "Boss of director");
        departments[4] = new Department(5, "Waiting room");

        Arrays.sort(departments, Comparator.comparing(Department::getDepartmentName));
        for (Department department : departments) {
            System.out.println(department);
        }
    }

    public static void question7() {
        System.out.println("\n===== Question 7 =====");
        Department[] departments = new Department[5];
        departments[0] = new Department(1, "Sale");
        departments[1] = new Department(2, "Marketing");
        departments[2] = new Department(3, "Accounting");
        departments[3] = new Department(4, "Boss of director");
        departments[4] = new Department(5, "Waiting room");

        Arrays.sort(departments, (d1, d2) -> {
            String[] words1 = d1.getDepartmentName().trim().split(" +");
            String[] words2 = d2.getDepartmentName().trim().split(" +");
            char firstChar1 = words1[words1.length - 1].charAt(0);
            char firstChar2 = words2[words2.length - 1].charAt(0);
            return Character.compare(firstChar1, firstChar2);
        });

        for (Department department : departments) {
            System.out.println(department);
        }
    }
}
