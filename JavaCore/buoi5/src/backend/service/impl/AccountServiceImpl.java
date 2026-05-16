package backend.service.impl;

import backend.repository.IAccountRepository;
import backend.repository.impl.AccountRepositoryImpl;
import backend.service.IAccountService;
import entity.Account;

import java.util.List;

public class AccountServiceImpl implements IAccountService {
    private final IAccountRepository repo = new AccountRepositoryImpl();

    @Override
    public void add(Account acc) {
        String username = acc.getUsername();
        if (username == null || username.trim().isEmpty())
            throw new IllegalArgumentException("Username khong duoc de trong");
        if (repo.existsByUsername(username.trim()))
            throw new IllegalArgumentException("Username da ton tai");

        String fullName = acc.getFullName();
        if (fullName == null || fullName.trim().isEmpty())
            throw new IllegalArgumentException("Ho ten khong duoc de trong");

        String email = acc.getEmail();
        if (email == null || email.trim().isEmpty())
            throw new IllegalArgumentException("Email khong duoc de trong");
        int atIdx = email.indexOf('@');
        if (atIdx <= 0 || atIdx == email.length() - 1)
            throw new IllegalArgumentException("Email khong hop le (phai co @ o giua)");
        if (repo.existsByEmail(email.trim()))
            throw new IllegalArgumentException("Email da ton tai");

        if (acc.getDepartment() == null || !repo.departmentExists(acc.getDepartment().getDepartmentID()))
            throw new IllegalArgumentException("Phong ban khong ton tai");
        if (acc.getPosition() == null || !repo.positionExists(acc.getPosition().getPositionID()))
            throw new IllegalArgumentException("Chuc vu khong ton tai");

        repo.save(acc);
    }

    @Override
    public void deleteById(int id) {
        if (id <= 0)
            throw new IllegalArgumentException("ID phai > 0");
        if (!repo.existsById(id))
            throw new IllegalArgumentException("Tai khoan khong ton tai");
        repo.deleteById(id);
    }

    @Override
    public void updateUsernameById(int id, String newUsername) {
        if (id <= 0)
            throw new IllegalArgumentException("ID phai > 0");
        if (!repo.existsById(id))
            throw new IllegalArgumentException("Tai khoan khong ton tai");
        if (newUsername == null || newUsername.trim().isEmpty())
            throw new IllegalArgumentException("Username khong duoc de trong");
        if (repo.existsByUsernameExcludingId(newUsername.trim(), id))
            throw new IllegalArgumentException("Username da ton tai");
        repo.updateUsernameById(id, newUsername.trim());
    }

    @Override
    public List<Account> findAll() {
        return repo.findAll();
    }

    @Override
    public List<Account> findByName(String name) {
        return repo.findByName(name);
    }
}
