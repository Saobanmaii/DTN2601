package Ex;

import java.util.Random;
import java.util.Scanner;

public class Ex1 {
    // Question 1: Khai báo và làm tròn lương float sang int
    public static void question1() {

        float salary1 = 5240.5f;
        float salary2 = 10970.055f;

        int salaryRounded1 = (int) salary1;
        int salaryRounded2 = (int) salary2;

        System.out.println("Luong Account 1 (float): " + salary1);
        System.out.println("Luong Account 1 (int - lam tron): " + salaryRounded1);

        System.out.println("Luong Account 2 (float): " + salary2);
        System.out.println("Luong Account 2 (int - lam tron): " + salaryRounded2);
    }

    // Question 2: Lấy ngẫu nhiên 1 số có 5 chữ số (thêm số 0 ở đầu nếu thiếu)
    public static void question2() {
        Random random = new Random();
        int randomNum = random.nextInt(100000); // 0 -> 9999

        String formatted = String.format("%05d", randomNum);
        System.out.println("So ngau nhien 5 chu so: " + formatted);
    }

    // Question 3: Lấy 2 số cuối của số ở Question 2
    public static void question3() {
        int randomNum = (int) (Math.random()*10000);

        int lastTwoDigits = randomNum % 100;
        System.out.println("So cuoi cua so ngau nhien 5 chu so: " + lastTwoDigits);
    }

    // Question 4: Nhập 2 số nguyên a, b và trả về thương (a / b) dạng double
    public static void question4() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so a: ");
        int a = sc.nextInt();
        System.out.print("Nhap so b: ");
        int b = sc.nextInt();

        if(b == 0) {
            System.out.println("Khong the chia cho 0");
            return;
        }
        double result = (double) a / b;
        System.out.println("Ket qua: " + result);
    }
}
