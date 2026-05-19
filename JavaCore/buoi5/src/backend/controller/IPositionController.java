package backend.controller;

import enums.PositionName;

public interface IPositionController {
    void add(PositionName name);
    void deleteById(int id);
    void update(int id, PositionName newName);
    void printAll();
    void search(String name);
}
