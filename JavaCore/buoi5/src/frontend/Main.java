package frontend;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DepartmentFunction deptFunc = new DepartmentFunction(sc);
        AccountFunction accFunc = new AccountFunction(sc);
        PositionFunction posFunc = new PositionFunction(sc);

        int choice;
        do {
            System.out.println("\n===== MENU CHINH =====");
            System.out.println("1. Quan ly Phong ban");
            System.out.println("2. Quan ly Tai khoan");
            System.out.println("3. Quan ly Chuc vu");
            System.out.println("0. Thoat");
            System.out.print("Chon: ");
            choice = Integer.parseInt(sc.nextLine().trim());

            switch (choice) {
                case 1:
                    deptFunc.showMenu();
                    break;
                case 2:
                    accFunc.showMenu();
                    break;
                case 3:
                    posFunc.showMenu();
                    break;
                case 0:
                    System.out.println("Tam biet!");
                    break;
                default:
                    System.out.println("Lua chon khong hop le!");
            }
        } while (choice != 0);

        sc.close();
    }
}
