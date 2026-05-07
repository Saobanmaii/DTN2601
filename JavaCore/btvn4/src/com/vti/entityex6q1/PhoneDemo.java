package com.vti.entityex6q1;

public class PhoneDemo {
    public static void main(String[] args) {
        VietnamesePhone myPhone = new VietnamesePhone();
        
        System.out.println("--- Thêm danh bạ ---");
        myPhone.insertContact("Nguyen Van A", "0987654321");
        myPhone.insertContact("Tran Thi B", "0123456789");
        
        System.out.println("\n--- Tìm kiếm ---");
        myPhone.searchContact("A");
        
        System.out.println("\n--- Cập nhật ---");
        myPhone.updateContact("Nguyen Van A", "0999999999");
        myPhone.searchContact("A"); // In lại để kiểm tra
        
        System.out.println("\n--- Xóa ---");
        myPhone.removeContact("Tran Thi B");
    }
}
