package backend.controller;

public interface IDepartmentController {
    void add(String name);
    void deleteById(int id);
    void update(int id, String newName);
    void printAll();
    void search(String name);
    void findDepartmentWithMostEmployees();
    void findDepartmentWithLeastEmployees();
    void findPositionWithMostEmployees();
    void findPositionWithLeastEmployees();
}
