package backend.service;

import entity.Position;
import enums.PositionName;
import java.util.List;

public interface IPositionService {
    void add(PositionName name);
    void deleteById(int id);
    void update(int id, PositionName newName);
    List<Position> findAll();
    List<Position> findByName(String name);
}
