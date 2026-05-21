package frontend;

import backend.controller.IAccountController;
import backend.controller.impl.AccountControllerImpl;
import entity.Account;
import entity.Department;
import entity.Position;
import utils.ScannerUtils;

import java.util.Scanner;

public class AccountFunction {
    private final IAccountController controller = new AccountControllerImpl();
    private final Scanner sc;

    public AccountFunction(Scanner sc) {
        this.sc = sc;
    }

    public void showMenu() {
        int choice;
        do {
            System.out.println("\n===== QUAN LY TAI KHOAN =====");
            System.out.println("1. Xem tat ca tai khoan");
            System.out.println("2. Them tai khoan");
            System.out.println("3. Sua username theo ID");
            System.out.println("4. Xoa tai khoan theo ID");
            System.out.println("5. Tim kiem theo ten");
            System.out.println("6. Import account tu file CSV");
            System.out.println("0. Quay lai");
            choice = ScannerUtils.readInt(sc, "Chon: ");

            switch (choice) {
                case 1:
                    controller.printAll();
                    break;
                case 2:
                    Account acc2 = inputAccount();
                    controller.add(acc2);
                    break;
                case 3:
                    int id3 = ScannerUtils.readInt(sc, "Nhap ID tai khoan can sua: ");
                    String newUsername3 = ScannerUtils.readString(sc, "Nhap username moi: ");
                    controller.updateUsernameById(id3, newUsername3);
                    break;
                case 4:
                    int id4 = ScannerUtils.readInt(sc, "Nhap ID tai khoan can xoa: ");
                    controller.deleteById(id4);
                    break;
                case 5:
                    String kw5 = ScannerUtils.readString(sc, "Nhap tu khoa tim kiem: ");
                    controller.search(kw5);
                    break;
                case 6:
                    String path6 = ScannerUtils.readString(sc, "Nhap duong dan file CSV: ");
                    controller.importFromFile(path6);
                    break;
                case 0:
                    System.out.println("Quay lai menu chinh...");
                    break;
                default:
                    System.out.println("Lua chon khong hop le!");
            }
        } while (choice != 0);
    }

    private Account inputAccount() {
        String username = ScannerUtils.readString(sc, "Username: ");
        String fullName = ScannerUtils.readString(sc, "Full Name: ");
        String email = ScannerUtils.readString(sc, "Email: ");

        Integer deptId = ScannerUtils.readOptionalInt(sc, "Department ID (bo trong neu khong co): ");
        Department dept = deptId != null ? new Department(deptId, "") : null;

        Integer posId = ScannerUtils.readOptionalInt(sc, "Position ID (bo trong neu khong co): ");
        Position pos = posId != null ? new Position(posId, null) : null;

        Account acc = new Account();
        acc.setUsername(username);
        acc.setFullName(fullName);
        acc.setEmail(email);
        acc.setDepartment(dept);
        acc.setPosition(pos);
        return acc;
    }
}
