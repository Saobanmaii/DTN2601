package backend.repository;

import entity.Position;
import enums.PositionName;
import java.util.List;

public interface IPositionRepository {
    List<Position> findAll();
    boolean save(Position pos);
    boolean update(int id, PositionName newName);
    boolean deleteById(int id);
    List<Position> findByName(String name);
    boolean existsByName(PositionName name);
    boolean existsById(int id);
    boolean existsByNameExcludingId(PositionName name, int id);
}
