package utils;

import java.util.Scanner;

public class ScannerUtils {

    public static int readInt(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Vui long nhap so nguyen hop le!");
            }
        }
    }

    public static String readString(Scanner sc, String prompt) {
        System.out.print(prompt);
        return sc.nextLine().trim();
    }

    public static Integer readOptionalInt(Scanner sc, String prompt) {
        System.out.print(prompt);
        String input = sc.nextLine().trim();
        if (input.isEmpty()) return null;
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("Gia tri khong hop le, bo qua.");
            return null;
        }
    }

    public static <E extends Enum<E>> E readEnum(Scanner sc, String prompt, Class<E> enumClass) {
        System.out.print(prompt);
        String input = sc.nextLine().trim().toUpperCase();
        try {
            return Enum.valueOf(enumClass, input);
        } catch (IllegalArgumentException e) {
            System.out.println("Gia tri khong hop le!");
            return null;
        }
    }
}
