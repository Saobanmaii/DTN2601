package com.vti.entityex6q1;

public class VietnamesePhone extends Phone {

    @Override
    public void insertContact(String name, String phone) {
        // Kiểm tra xem tên đã tồn tại chưa, nếu chưa thì mới thêm
        for (Contact c : contacts) {
            if (c.getName().equals(name)) {
                System.out.println("Danh bạ đã tồn tại tên: " + name);
                return;
            }
        }
        contacts.add(new Contact(name, phone));
        System.out.println("Đã thêm liên hệ: " + name);
    }

    @Override
    public void removeContact(String name) {
        boolean removed = contacts.removeIf(c -> c.getName().equals(name));
        if (removed) {
            System.out.println("Đã xóa liên hệ: " + name);
        } else {
            System.out.println("Không tìm thấy liên hệ để xóa.");
        }
    }

    @Override
    public void updateContact(String name, String newPhone) {
        for (Contact c : contacts) {
            if (c.getName().equals(name)) {
                c.setNumber(newPhone);
                System.out.println("Đã cập nhật số mới cho: " + name);
                return;
            }
        }
        System.out.println("Không tìm thấy liên hệ để cập nhật.");
    }

    @Override
    public void searchContact(String name) {
        for (Contact c : contacts) {
            if (c.getName().toLowerCase().contains(name.toLowerCase())) {
                System.out.println("Kết quả tìm kiếm: " + c.toString());
                return;
            }
        }
        System.out.println("Không tìm thấy tên trong danh bạ.");
    }
}


