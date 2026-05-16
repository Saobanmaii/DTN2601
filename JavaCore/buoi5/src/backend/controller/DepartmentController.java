package backend.controller;

import backend.service.IDepartmentService;
import backend.service.impl.DepartmentServiceImpl;
import entity.Department;

import java.util.List;

public class DepartmentController {
    private final IDepartmentService service = new DepartmentServiceImpl();

    public void add(String name) {
        try {
            service.add(name);
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

    public void update(int id, String newName) {
        try {
            service.update(id, newName);
            System.out.println("Sua thanh cong!");
        } catch (IllegalArgumentException e) {
            System.out.println("Loi: " + e.getMessage());
        }
    }

    public void printAll() {
        List<Department> list = service.findAll();
        System.out.println("===== DANH SACH PHONG BAN =====");
        list.forEach(System.out::println);
    }

    public void search(String name) {
        List<Department> list = service.findByName(name);
        if (list.isEmpty()) System.out.println("Khong tim thay ket qua.");
        else list.forEach(System.out::println);
    }

    public void findDepartmentWithMostEmployees() {
        service.findDepartmentWithMostEmployees();
    }

    public void findDepartmentWithLeastEmployees() {
        service.findDepartmentWithLeastEmployees();
    }

    public void findPositionWithMostEmployees() {
        service.findPositionWithMostEmployees();
    }

    public void findPositionWithLeastEmployees() {
        service.findPositionWithLeastEmployees();
    }
}
