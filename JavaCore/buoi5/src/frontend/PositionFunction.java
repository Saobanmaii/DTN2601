package frontend;

import backend.controller.IPositionController;
import backend.controller.impl.PositionControllerImpl;
import enums.PositionName;

import java.util.Arrays;
import java.util.Scanner;

public class PositionFunction {
    private final IPositionController controller = new PositionControllerImpl();
    private final Scanner sc;

    public PositionFunction(Scanner sc) {
        this.sc = sc;
    }

    public void showMenu() {
        int choice;
        do {
            System.out.println("\n===== QUAN LY CHUC VU =====");
            System.out.println("1. Xem tat ca chuc vu");
            System.out.println("2. Them chuc vu");
            System.out.println("3. Sua chuc vu theo ID");
            System.out.println("4. Xoa chuc vu theo ID");
            System.out.println("5. Tim kiem theo ten");
            System.out.println("0. Quay lai");
            System.out.print("Chon: ");
            choice = Integer.parseInt(sc.nextLine().trim());

            switch (choice) {
                case 1:
                    controller.printAll();
                    break;
                case 2:
                    PositionName name2 = inputPositionName();
                    if (name2 != null) {
                        controller.add(name2);
                    }
                    break;
                case 3:
                    System.out.print("Nhap ID chuc vu can sua: ");
                    int id3 = Integer.parseInt(sc.nextLine().trim());
                    PositionName name3 = inputPositionName();
                    if (name3 != null) {
                        controller.update(id3, name3);
                    }
                    break;
                case 4:
                    System.out.print("Nhap ID chuc vu can xoa: ");
                    int id4 = Integer.parseInt(sc.nextLine().trim());
                    controller.deleteById(id4);
                    break;
                case 5:
                    System.out.print("Nhap tu khoa tim kiem: ");
                    String kw5 = sc.nextLine().trim();
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

    private PositionName inputPositionName() {
        System.out.println("Cac chuc vu co the chon: " + Arrays.toString(PositionName.values()));
        System.out.print("Nhap ten chuc vu: ");
        String input = sc.nextLine().trim().toUpperCase();
        try {
            return PositionName.valueOf(input);
        } catch (IllegalArgumentException e) {
            System.out.println("Ten chuc vu khong hop le!");
            return null;
        }
    }
}
