package backend.service;

import entity.Account;
import java.util.List;

public interface IAccountService {
    void add(Account acc);
    void deleteById(int id);
    void updateUsernameById(int id, String newUsername);
    List<Account> findAll();
    List<Account> findByName(String name);
}
