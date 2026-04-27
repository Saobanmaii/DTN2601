package Ex;

import java.util.Scanner;

public class Ex4 {

        static Scanner scanner = new Scanner(System.in);

        // Question 1: Đếm số từ trong chuỗi (các từ có thể cách nhau nhiều khoảng trắng)
        public static void question1() {
            System.out.println("===== Question 1 =====");
            System.out.print("Nhap chuoi: ");
            String input = scanner.nextLine().trim();

            if (input.isEmpty()) {
                System.out.println("So tu: 0");
                return;
            }

            String[] words = input.split("\\s+"); // tách theo 1 hoặc nhiều khoảng trắng
            System.out.println("So tu trong chuoi: " + words.length);
        }

        // Question 2: Nối s2 vào sau s1
        public static void question2() {
            System.out.println("\n===== Question 2 =====");
            System.out.print("Nhap chuoi s1: ");
            String s1 = scanner.nextLine();
            System.out.print("Nhap chuoi s2: ");
            String s2 = scanner.nextLine();

            String result = s1.concat(s2); // hoặc s1 + s2
            System.out.println("Ket qua: " + result);
        }

        // Question 3: Kiểm tra và viết hoa chữ cái đầu mỗi từ nếu chưa viết hoa
        public static void question3() {
            System.out.println("\n===== Question 3 =====");
            System.out.print("Nhap ten: ");
            String name = scanner.nextLine().trim();

            String[] words = name.split("\\s+");
            StringBuilder result = new StringBuilder();

            for (String word : words) {
                if (!word.isEmpty()) {
                    result.append(Character.toUpperCase(word.charAt(0)))
                            .append(word.substring(1))
                            .append(" ");
                }
            }

            System.out.println("Ten sau chuan hoa: " + result.toString().trim());
        }

        // Question 4: In từng ký tự trong tên
        public static void question4() {
            System.out.println("\n===== Question 4 =====");
            System.out.print("Nhap ten: ");
            String name = scanner.nextLine();

            for (int i = 0; i < name.length(); i++) {
                System.out.println("Ky tu thu " + (i + 1) + " la: " + Character.toUpperCase(name.charAt(i)));
            }
        }

        // Question 5: Nhập họ và tên riêng, in ra họ tên đầy đủ
        public static void question5() {
            System.out.println("\n===== Question 5 =====");
            System.out.print("Nhap ho: ");
            String lastName = scanner.nextLine();
            System.out.print("Nhap ten: ");
            String firstName = scanner.nextLine();

            System.out.println("Ho va ten day du: " + lastName + " " + firstName);
        }

        // Question 6: Tách họ, tên đệm, tên từ họ tên đầy đủ
        public static void question6() {
            System.out.println("\n===== Question 6 =====");
            System.out.print("Nhap ho va ten day du: ");
            String fullName = scanner.nextLine().trim();

            String[] parts = fullName.split("\\s+");

            if (parts.length < 2) {
                System.out.println("Vui long nhap day du ho va ten!");
                return;
            }

            String ho = parts[0];
            String ten = parts[parts.length - 1];

            System.out.println("Ho la: " + ho);

            if (parts.length > 2) {
                StringBuilder tenDem = new StringBuilder();
                for (int i = 1; i < parts.length - 1; i++) {
                    tenDem.append(parts[i]);
                    if (i < parts.length - 2) tenDem.append(" ");
                }
                System.out.println("Ten dem la: " + tenDem);
            } else {
                System.out.println("Ten dem la: (khong co)");
            }

            System.out.println("Ten la: " + ten);
        }

        // Question 7: Chuẩn hóa họ tên (xóa khoảng trắng thừa + viết hoa chữ cái đầu)
        public static void question7() {
            System.out.println("\n===== Question 7 =====");
            System.out.print("Nhap ho va ten: ");
            String input = scanner.nextLine();

            String normalized = input.trim().replaceAll("\\s+", " ");
            String[] words = normalized.split(" ");
            StringBuilder result = new StringBuilder();
            for (String word : words) {
                if (!word.isEmpty()) {
                    result.append(Character.toUpperCase(word.charAt(0)))
                            .append(word.substring(1))
                            .append(" ");
                }
            }
            System.out.println("Ten sau chuan hoa la: " + result.toString().trim());
        }

        // Question 8: In tất cả group có chứa chữ "Java"
        public static void question8() {
            System.out.println("\n===== Question 8 =====");
            String[] groups = {
                    "Java Basic", "C# Advanced", "Java OOP",
                    "Python ML", "Java Web", "ReactJS", "Java Spring Boot"
            };

            System.out.println("Cac group co chua chu 'Java':");
            for (String group : groups) {
                if (group.contains("Java")) {
                    System.out.println("- " + group);
                }
            }
        }

        // Question 9: In tất cả group "Java" (tên đúng là "Java")
        public static void question9() {
            System.out.println("\n===== Question 9 =====");
            String[] groups = {
                    "Java Basic", "C# Advanced", "Java OOP",
                    "Python ML", "Java", "ReactJS", "Java"
            };

            System.out.println("Cac group co ten la 'Java':");
            for (String group : groups) {
                if (group.equals("Java")) {
                    System.out.println("- " + group);
                }
            }
        }

        // Question 10: Kiểm tra 2 chuỗi có là đảo ngược của nhau không
        public static void question10() {
            System.out.println("\n===== Question 10 =====");
            System.out.print("Nhap chuoi 1: ");
            String s1 = scanner.nextLine();
            System.out.print("Nhap chuoi 2: ");
            String s2 = scanner.nextLine();

            String reversed = new StringBuilder(s1).reverse().toString();
            System.out.println(reversed.equals(s2) ? "OK" : "KO");
        }

        // Question 11: Đếm số lần xuất hiện ký tự 'a' trong chuỗi
        public static void question11() {
            System.out.println("\n===== Question 11 =====");
            System.out.print("Nhap chuoi: ");
            String input = scanner.nextLine();

            int count = 0;
            for (char c : input.toCharArray()) {
                if (c == 'a') count++;
            }

            System.out.println("So lan xuat hien ky tu 'a': " + count);
        }

        // Question 12: Đảo ngược chuỗi bằng vòng lặp
        public static void question12() {
            System.out.println("\n===== Question 12 =====");
            System.out.print("Nhap chuoi: ");
            String input = scanner.nextLine();

            String reversed = "";
            for (int i = input.length() - 1; i >= 0; i--) {
                reversed += input.charAt(i);
            }

            System.out.println("Chuoi dao nguoc: " + reversed);
        }

        // Question 13: Kiểm tra chuỗi có chứa chữ số không (true nếu không có, false nếu có)
        public static void question13() {
            System.out.println("\n===== Question 13 =====");
            System.out.print("Nhap chuoi: ");
            String input = scanner.nextLine();

            boolean result = stringNotContainsDigit(input);
            System.out.println(result);
        }

        private static boolean stringNotContainsDigit(String s) {
            if (s == null) return false;
            for (char c : s.toCharArray()) {
                if (Character.isDigit(c)) return false;
            }
            return true;
        }

        // Question 14: Thay ký tự 'e' sang '*'
        public static void question14() {
            System.out.println("\n===== Question 14 =====");
            System.out.print("Nhap chuoi: ");
            String input = scanner.nextLine();
            System.out.print("Nhap ky tu can thay: ");
            char oldChar = scanner.nextLine().charAt(0);
            System.out.print("Nhap ky tu thay the: ");
            char newChar = scanner.nextLine().charAt(0);

            String result = input.replace(oldChar, newChar);
            System.out.println("Ket qua: " + result);
        }

        // Question 15: Đảo ngược các từ trong chuỗi không dùng thư viện
        public static void question15() {
            System.out.println("\n===== Question 15 =====");
            System.out.print("Nhap chuoi: ");
            String input = scanner.nextLine().trim();

            // Tách các từ theo khoảng trắng
            String[] words = input.split(" ");

            // Đảo ngược thứ tự các từ
            String result = "";
            for (int i = words.length - 1; i >= 0; i--) {
                if (!words[i].isEmpty()) {
                    result += words[i];
                    if (i > 0) result += " ";
                }
            }

            System.out.println("Ket qua: " + result.trim());
        }

        // Question 16: Chia chuỗi thành các phần bằng nhau n ký tự
        public static void question16() {
            System.out.println("\n===== Question 16 =====");
            System.out.print("Nhap chuoi: ");
            String input = scanner.nextLine();
            System.out.print("Nhap so nguyen n: ");
            int n = scanner.nextInt();
            scanner.nextLine();

            if (n <= 0 || input.length() % n != 0) {
                System.out.println("KO");
                return;
            }

            System.out.print("Ket qua: ");
            for (int i = 0; i < input.length(); i += n) {
                System.out.print("[" + input.substring(i, i + n) + "] ");
            }
            System.out.println();
        }
}
