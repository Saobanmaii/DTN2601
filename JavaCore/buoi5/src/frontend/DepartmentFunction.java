package frontend;

import backend.controller.IDepartmentController;
import backend.controller.impl.DepartmentControllerImpl;
import utils.ScannerUtils;

import java.util.Scanner;

public class DepartmentFunction {
    private final IDepartmentController controller = new DepartmentControllerImpl();
    private final Scanner sc;

    public DepartmentFunction(Scanner sc) {
        this.sc = sc;
    }

    public void showMenu() {
        int choice;
        do {
            System.out.println("\n===== QUAN LY PHONG BAN =====");
            System.out.println("1. Xem tat ca phong ban");
            System.out.println("2. Them phong ban");
            System.out.println("3. Sua phong ban theo ID");
            System.out.println("4. Xoa phong ban theo ID");
            System.out.println("5. Tim kiem theo ten");
            System.out.println("6. Phong ban co nhieu nhan vien nhat");
            System.out.println("7. Phong ban co it nhan vien nhat");
            System.out.println("8. Chuc vu co nhieu nhan vien nhat");
            System.out.println("9. Chuc vu co it nhan vien nhat");
            System.out.println("0. Quay lai");
            choice = ScannerUtils.readInt(sc, "Chon: ");

            switch (choice) {
                case 1:
                    controller.printAll();
                    break;
                case 2:
                    String name2 = ScannerUtils.readString(sc, "Nhap ten phong ban: ");
                    controller.add(name2);
                    break;
                case 3:
                    int id3 = ScannerUtils.readInt(sc, "Nhap ID phong ban can sua: ");
                    String newName3 = ScannerUtils.readString(sc, "Nhap ten moi: ");
                    controller.update(id3, newName3);
                    break;
                case 4:
                    int id4 = ScannerUtils.readInt(sc, "Nhap ID phong ban can xoa: ");
                    controller.deleteById(id4);
                    break;
                case 5:
                    String kw5 = ScannerUtils.readString(sc, "Nhap tu khoa tim kiem: ");
                    controller.search(kw5);
                    break;
                case 6:
                    controller.findDepartmentWithMostEmployees();
                    break;
                case 7:
                    controller.findDepartmentWithLeastEmployees();
                    break;
                case 8:
                    controller.findPositionWithMostEmployees();
                    break;
                case 9:
                    controller.findPositionWithLeastEmployees();
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
