package backend.repository;

import entity.Department;
import java.util.List;

public interface IDepartmentRepository {
    List<Department> findAll();
    boolean save(Department dept);
    boolean update(int id, String newName);
    boolean deleteById(int id);
    List<Department> findByName(String name);
    boolean existsByName(String name);
    boolean existsById(int id);
    boolean existsByNameExcludingId(String name, int id);
    void findDepartmentWithMostEmployees();
    void findDepartmentWithLeastEmployees();
    void findPositionWithMostEmployees();
    void findPositionWithLeastEmployees();
}
