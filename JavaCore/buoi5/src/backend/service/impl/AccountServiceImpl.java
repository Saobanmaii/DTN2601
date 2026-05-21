package backend.service.impl;

import backend.repository.IAccountRepository;
import backend.repository.impl.AccountRepositoryImpl;
import backend.service.IAccountService;
import entity.Account;
import entity.Department;
import entity.Position;

import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;
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

    @Override
    public void importFromFile(String filePath) {
        List<Account> validList = new ArrayList<>();
        List<String> errorList = new ArrayList<>();
        int lineNumber = 1;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            br.readLine(); // skip header
            String line;
            while ((line = br.readLine()) != null) {
                lineNumber++;
                String trimmed = line.trim();
                if (trimmed.isEmpty()) continue;

                String[] parts = trimmed.split(",", -1);
                if (parts.length < 5) {
                    errorList.add("[Line " + lineNumber + "] " + trimmed + " - Loi: Sai dinh dang (can 5 truong: username,fullName,email,departmentID,positionID)");
                    continue;
                }

                String username = parts[0].trim();
                String fullName = parts[1].trim();
                String email    = parts[2].trim();
                String deptStr  = parts[3].trim();
                String posStr   = parts[4].trim();
                String prefix   = "[Line " + lineNumber + "] username=" + username + " email=" + email;

                if (username.isEmpty()) { errorList.add(prefix + " - Loi: Username khong duoc de trong"); continue; }
                if (fullName.isEmpty()) { errorList.add(prefix + " - Loi: Ho ten khong duoc de trong"); continue; }
                if (email.isEmpty())    { errorList.add(prefix + " - Loi: Email khong duoc de trong"); continue; }
                int atIdx = email.indexOf('@');
                if (atIdx <= 0 || atIdx == email.length() - 1) { errorList.add(prefix + " - Loi: Email khong hop le"); continue; }
                if (repo.existsByUsername(username)) { errorList.add(prefix + " - Loi: Username da ton tai"); continue; }
                if (repo.existsByEmail(email))       { errorList.add(prefix + " - Loi: Email da ton tai"); continue; }

                Department dept = null;
                if (!deptStr.isEmpty()) {
                    try {
                        int deptId = Integer.parseInt(deptStr);
                        if (!repo.departmentExists(deptId)) { errorList.add(prefix + " - Loi: Department ID " + deptId + " khong ton tai"); continue; }
                        dept = new Department(deptId, "");
                    } catch (NumberFormatException e) {
                        errorList.add(prefix + " - Loi: Department ID khong hop le: " + deptStr); continue;
                    }
                }

                Position pos = null;
                if (!posStr.isEmpty()) {
                    try {
                        int posId = Integer.parseInt(posStr);
                        if (!repo.positionExists(posId)) { errorList.add(prefix + " - Loi: Position ID " + posId + " khong ton tai"); continue; }
                        pos = new Position(posId, null);
                    } catch (NumberFormatException e) {
                        errorList.add(prefix + " - Loi: Position ID khong hop le: " + posStr); continue;
                    }
                }

                Account acc = new Account();
                acc.setUsername(username);
                acc.setFullName(fullName);
                acc.setEmail(email);
                acc.setDepartment(dept);
                acc.setPosition(pos);
                validList.add(acc);
            }
        } catch (IOException e) {
            System.out.println("Loi doc file: " + e.getMessage());
            return;
        }

        int successCount = 0;
        if (!validList.isEmpty()) {
            try {
                repo.batchInsert(validList);
                successCount = validList.size();
            } catch (SQLException e) {
                errorList.add("[SQL Error] Loi insert batch, da rollback toan bo: " + e.getMessage());
            }
        }

        if (!errorList.isEmpty()) {
            int dot = filePath.lastIndexOf('.');
            String errorPath = (dot > 0 ? filePath.substring(0, dot) : filePath) + "_errors.txt";
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(errorPath))) {
                for (String err : errorList) {
                    bw.write(err);
                    bw.newLine();
                }
                System.out.println("Da ghi file loi: " + errorPath);
            } catch (IOException e) {
                System.out.println("Loi ghi file loi: " + e.getMessage());
            }
        }

        int totalRead = lineNumber - 1;
        System.out.println("===== KET QUA IMPORT =====");
        System.out.println("Tong dong doc : " + totalRead);
        System.out.println("Them thanh cong: " + successCount);
        System.out.println("Loi           : " + errorList.size());
    }
}
