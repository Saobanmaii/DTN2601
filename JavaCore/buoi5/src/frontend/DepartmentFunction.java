package frontend;

import backend.controller.DepartmentController;

import java.util.Scanner;

public class DepartmentFunction {
    private final DepartmentController controller = new DepartmentController();
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
            System.out.print("Chon: ");
            choice = Integer.parseInt(sc.nextLine().trim());

            switch (choice) {
                case 1:
                    controller.printAll();
                    break;
                case 2:
                    System.out.print("Nhap ten phong ban: ");
                    String name2 = sc.nextLine();
                    controller.add(name2);
                    break;
                case 3:
                    System.out.print("Nhap ID phong ban can sua: ");
                    int id3 = Integer.parseInt(sc.nextLine().trim());
                    System.out.print("Nhap ten moi: ");
                    String newName3 = sc.nextLine();
                    controller.update(id3, newName3);
                    break;
                case 4:
                    System.out.print("Nhap ID phong ban can xoa: ");
                    int id4 = Integer.parseInt(sc.nextLine().trim());
                    controller.deleteById(id4);
                    break;
                case 5:
                    System.out.print("Nhap tu khoa tim kiem: ");
                    String kw5 = sc.nextLine();
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
