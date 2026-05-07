package com.vti.backend;
// Boxing, Unboxing
public class Ex3 {
    // Question 1: Integer -> float, hiển thị 2 số sau dấu thập phân
    public static void question1() {
        System.out.println("===== Question 1 =====");

        Integer salary = 5000;              // Boxing: int -> Integer
        float salaryFloat = salary;         // Unboxing Integer -> int, rồi widening -> float

        System.out.printf("Luong (float): %.2f%n", salaryFloat);
    }

    // Question 2: String "1234567" -> int
    public static void question2() {
        System.out.println("\n===== Question 2 =====");

        String value = "1234567";
        int number = Integer.parseInt(value);   // parse String -> int

        System.out.println("Gia tri String: " + value);
        System.out.println("Sau khi convert sang int: " + number);
    }

    // Question 3: Integer có value là chuỗi "1234567" -> int
    public static void question3() {
        System.out.println("\n===== Question 3 =====");

        Integer number = Integer.valueOf("1234567");  // String -> Integer (Boxing)
        int result = number;                          // Unboxing: Integer -> int

        System.out.println("Gia tri Integer: " + number);
        System.out.println("Sau khi convert sang int: " + result);
    }

}
