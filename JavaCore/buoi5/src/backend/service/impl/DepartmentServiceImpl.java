package backend.service.impl;

import backend.repository.IDepartmentRepository;
import backend.repository.impl.DepartmentRepositoryImpl;
import backend.service.IDepartmentService;
import entity.Department;

import java.util.List;

public class DepartmentServiceImpl implements IDepartmentService {
    private final IDepartmentRepository repo = new DepartmentRepositoryImpl();

    @Override
    public void add(String name) {
        if (name == null || name.trim().isEmpty())
            throw new IllegalArgumentException("Ten phong ban khong duoc de trong");
        if (repo.existsByName(name.trim()))
            throw new IllegalArgumentException("Ten phong ban da ton tai");
        repo.save(new Department(name.trim()));
    }

    @Override
    public void deleteById(int id) {
        if (id <= 0)
            throw new IllegalArgumentException("ID phai > 0");
        if (!repo.existsById(id))
            throw new IllegalArgumentException("Phong ban khong ton tai");
        repo.deleteById(id);
    }

    @Override
    public void update(int id, String newName) {
        if (id <= 0)
            throw new IllegalArgumentException("ID phai > 0");
        if (!repo.existsById(id))
            throw new IllegalArgumentException("Phong ban khong ton tai");
        if (newName == null || newName.trim().isEmpty())
            throw new IllegalArgumentException("Ten phong ban khong duoc de trong");
        if (repo.existsByNameExcludingId(newName.trim(), id))
            throw new IllegalArgumentException("Ten phong ban da ton tai");
        repo.update(id, newName.trim());
    }

    @Override
    public List<Department> findAll() {
        return repo.findAll();
    }

    @Override
    public List<Department> findByName(String name) {
        return repo.findByName(name);
    }

    @Override
    public void findDepartmentWithMostEmployees() {
        repo.findDepartmentWithMostEmployees();
    }

    @Override
    public void findDepartmentWithLeastEmployees() {
        repo.findDepartmentWithLeastEmployees();
    }

    @Override
    public void findPositionWithMostEmployees() {
        repo.findPositionWithMostEmployees();
    }

    @Override
    public void findPositionWithLeastEmployees() {
        repo.findPositionWithLeastEmployees();
    }
}
