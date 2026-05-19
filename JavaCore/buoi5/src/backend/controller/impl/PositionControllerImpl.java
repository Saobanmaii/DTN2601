package backend.controller.impl;

import backend.controller.IPositionController;
import backend.service.IPositionService;
import backend.service.impl.PositionServiceImpl;
import entity.Position;
import enums.PositionName;

import java.util.List;

public class PositionControllerImpl implements IPositionController {
    private final IPositionService service = new PositionServiceImpl();

    @Override
    public void add(PositionName name) {
        try {
            service.add(name);
            System.out.println("Them thanh cong!");
        } catch (IllegalArgumentException e) {
            System.out.println("Loi: " + e.getMessage());
        }
    }

    @Override
    public void deleteById(int id) {
        try {
            service.deleteById(id);
            System.out.println("Xoa thanh cong!");
        } catch (IllegalArgumentException e) {
            System.out.println("Loi: " + e.getMessage());
        }
    }

    @Override
    public void update(int id, PositionName newName) {
        try {
            service.update(id, newName);
            System.out.println("Sua thanh cong!");
        } catch (IllegalArgumentException e) {
            System.out.println("Loi: " + e.getMessage());
        }
    }

    @Override
    public void printAll() {
        List<Position> list = service.findAll();
        System.out.println("===== DANH SACH CHUC VU =====");
        list.forEach(System.out::println);
    }

    @Override
    public void search(String name) {
        List<Position> list = service.findByName(name);
        if (list.isEmpty()) System.out.println("Khong tim thay ket qua.");
        else list.forEach(System.out::println);
    }
}
