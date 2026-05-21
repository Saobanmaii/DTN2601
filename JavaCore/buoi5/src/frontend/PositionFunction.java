package frontend;

import backend.controller.IPositionController;
import backend.controller.impl.PositionControllerImpl;
import enums.PositionName;
import utils.ScannerUtils;

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
            choice = ScannerUtils.readInt(sc, "Chon: ");

            switch (choice) {
                case 1:
                    controller.printAll();
                    break;
                case 2:
                    System.out.println("Cac chuc vu co the chon: " + Arrays.toString(PositionName.values()));
                    PositionName name2 = ScannerUtils.readEnum(sc, "Nhap ten chuc vu: ", PositionName.class);
                    if (name2 != null) controller.add(name2);
                    break;
                case 3:
                    int id3 = ScannerUtils.readInt(sc, "Nhap ID chuc vu can sua: ");
                    System.out.println("Cac chuc vu co the chon: " + Arrays.toString(PositionName.values()));
                    PositionName name3 = ScannerUtils.readEnum(sc, "Nhap ten chuc vu moi: ", PositionName.class);
                    if (name3 != null) controller.update(id3, name3);
                    break;
                case 4:
                    int id4 = ScannerUtils.readInt(sc, "Nhap ID chuc vu can xoa: ");
                    controller.deleteById(id4);
                    break;
                case 5:
                    String kw5 = ScannerUtils.readString(sc, "Nhap tu khoa tim kiem: ");
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
}
