package backend.service.impl;

import backend.repository.IPositionRepository;
import backend.repository.impl.PositionRepositoryImpl;
import backend.service.IPositionService;
import entity.Position;
import enums.PositionName;

import java.util.List;

public class PositionServiceImpl implements IPositionService {
    private final IPositionRepository repo = new PositionRepositoryImpl();

    @Override
    public void add(PositionName name) {
        if (repo.existsByName(name))
            throw new IllegalArgumentException("Chuc vu da ton tai");
        repo.save(new Position(0, name));
    }

    @Override
    public void deleteById(int id) {
        if (id <= 0)
            throw new IllegalArgumentException("ID phai > 0");
        if (!repo.existsById(id))
            throw new IllegalArgumentException("Chuc vu khong ton tai");
        repo.deleteById(id);
    }

    @Override
    public void update(int id, PositionName newName) {
        if (id <= 0)
            throw new IllegalArgumentException("ID phai > 0");
        if (!repo.existsById(id))
            throw new IllegalArgumentException("Chuc vu khong ton tai");
        if (repo.existsByNameExcludingId(newName, id))
            throw new IllegalArgumentException("Chuc vu da ton tai");
        repo.update(id, newName);
    }

    @Override
    public List<Position> findAll() {
        return repo.findAll();
    }

    @Override
    public List<Position> findByName(String name) {
        return repo.findByName(name);
    }
}
