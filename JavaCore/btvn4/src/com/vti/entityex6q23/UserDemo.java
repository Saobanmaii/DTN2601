package com.vti.entityex6q23;

public class UserDemo {
    public static void main(String[] args) {
        User nv1 = new Employee("Nhân viên A", 1.5);
        User ql1 = new Manager("Quản lý B", 2.0);
        User pv1 = new Waiter("Phục vụ C", 1.2);

        nv1.displayInfor();
        ql1.displayInfor();
        pv1.displayInfor();
    }
}
