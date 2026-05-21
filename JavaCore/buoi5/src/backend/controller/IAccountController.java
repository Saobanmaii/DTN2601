package backend.controller;

import entity.Account;

public interface IAccountController {
    void add(Account acc);
    void deleteById(int id);
    void updateUsernameById(int id, String newUsername);
    void printAll();
    void search(String name);
    void importFromFile(String filePath);
}
