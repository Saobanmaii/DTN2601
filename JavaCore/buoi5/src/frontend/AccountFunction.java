package frontend;

import backend.controller.AccountController;
import entity.Account;
import entity.Department;
import entity.Position;

import java.util.Scanner;

public class AccountFunction {
    private final AccountController controller = new AccountController();
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
            System.out.println("0. Quay lai");
            System.out.print("Chon: ");
            choice = Integer.parseInt(sc.nextLine().trim());

            switch (choice) {
                case 1:
                    controller.printAll();
                    break;
                case 2:
                    Account acc2 = inputAccount();
                    controller.add(acc2);
                    break;
                case 3:
                    System.out.print("Nhap ID tai khoan can sua: ");
                    int id3 = Integer.parseInt(sc.nextLine().trim());
                    System.out.print("Nhap username moi: ");
                    String newUsername3 = sc.nextLine();
                    controller.updateUsernameById(id3, newUsername3);
                    break;
                case 4:
                    System.out.print("Nhap ID tai khoan can xoa: ");
                    int id4 = Integer.parseInt(sc.nextLine().trim());
                    controller.deleteById(id4);
                    break;
                case 5:
                    System.out.print("Nhap tu khoa tim kiem: ");
                    String kw5 = sc.nextLine();
                    controller.search(kw5);
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
        System.out.print("Username: ");
        String username = sc.nextLine();
        System.out.print("Full Name: ");
        String fullName = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();

        System.out.print("Department ID: ");
        String deptInput = sc.nextLine().trim();
        Department dept = deptInput.isEmpty() ? null : new Department(Integer.parseInt(deptInput), "");

        System.out.print("Position ID: ");
        String posInput = sc.nextLine().trim();
        Position pos = posInput.isEmpty() ? null : new Position(Integer.parseInt(posInput), null);

        Account acc = new Account();
        acc.setUsername(username);
        acc.setFullName(fullName);
        acc.setEmail(email);
        acc.setDepartment(dept);
        acc.setPosition(pos);
        return acc;
    }
}
