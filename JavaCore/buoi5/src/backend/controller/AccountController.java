package backend.controller;

import backend.service.IAccountService;
import backend.service.impl.AccountServiceImpl;
import entity.Account;

import java.util.List;

public class AccountController {
    private final IAccountService service = new AccountServiceImpl();

    public void add(Account acc) {
        try {
            service.add(acc);
            System.out.println("Them thanh cong!");
        } catch (IllegalArgumentException e) {
            System.out.println("Loi: " + e.getMessage());
        }
    }

    public void deleteById(int id) {
        try {
            service.deleteById(id);
            System.out.println("Xoa thanh cong!");
        } catch (IllegalArgumentException e) {
            System.out.println("Loi: " + e.getMessage());
        }
    }

    public void updateUsernameById(int id, String newUsername) {
        try {
            service.updateUsernameById(id, newUsername);
            System.out.println("Sua thanh cong!");
        } catch (IllegalArgumentException e) {
            System.out.println("Loi: " + e.getMessage());
        }
    }

    public void printAll() {
        List<Account> list = service.findAll();
        System.out.println("===== DANH SACH TAI KHOAN =====");
        list.forEach(System.out::println);
    }

    public void search(String name) {
        List<Account> list = service.findByName(name);
        if (list.isEmpty()) System.out.println("Khong tim thay ket qua.");
        else list.forEach(System.out::println);
    }
}
