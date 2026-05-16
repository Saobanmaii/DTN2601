package backend.service;

import entity.Department;
import java.util.List;

public interface IDepartmentService {
    void add(String name);
    void deleteById(int id);
    void update(int id, String newName);
    List<Department> findAll();
    List<Department> findByName(String name);
    void findDepartmentWithMostEmployees();
    void findDepartmentWithLeastEmployees();
    void findPositionWithMostEmployees();
    void findPositionWithLeastEmployees();
}
