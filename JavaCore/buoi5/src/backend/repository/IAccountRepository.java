package backend.repository;

import entity.Account;
import java.util.List;

public interface IAccountRepository {
    List<Account> findAll();
    boolean save(Account acc);
    boolean updateUsernameById(int id, String newUsername);
    boolean deleteById(int id);
    List<Account> findByName(String name);
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
    boolean existsById(int id);
    boolean existsByUsernameExcludingId(String username, int id);
    boolean departmentExists(int departmentId);
    boolean positionExists(int positionId);
}
