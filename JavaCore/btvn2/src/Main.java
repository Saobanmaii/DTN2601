import com.vti.backend.Ex1;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
            DataInitializer data = new DataInitializer();
            data.initData();

            Ex1 exercise = new Ex1();

            // Chạy Question 1
            System.out.println("--- Chạy Question 1 ---");
            exercise.question1(data.accounts[1]); // acc2

            // Chạy Question 2
            System.out.println("\n--- Chạy Question 2 ---");
            exercise.question2(data.accounts[1]); // acc2

            // Chạy Question 3
            System.out.println("\n--- Chạy Question 3 ---");
            exercise.question3(data.accounts[2]); // acc3 (test trường hợp null department)

            // Chạy Question 4
            System.out.println("\n--- Chạy Question 4 ---");
            exercise.question4(data.accounts[0]); // acc1

            // Chạy Question 5
            System.out.println("\n--- Chạy Question 5 ---");
            exercise.question5(data.groups[0]); // grp1

            // Chạy Question 6
            System.out.println("\n--- Chạy Question 6 ---");
            exercise.question6(data.accounts[1]); // acc2

            // Chạy Question 7
            System.out.println("\n--- Chạy Question 7 ---");
            exercise.question7(data.accounts[0]); // acc1

            // Chạy Question 8
            System.out.println("\n--- Chạy Question 8 ---");
            exercise.question8(data.accounts);

            // Chạy Question 9
            System.out.println("\n--- Chạy Question 9 ---");
            exercise.question9(data.departments);

            // Chạy Question 10
            System.out.println("\n--- Chạy Question 10 ---");
            exercise.question10(data.accounts);

            // Chạy Question 11
            System.out.println("\n--- Chạy Question 11 ---");
            exercise.question11(data.departments);

            // Chạy Question 12
            System.out.println("\n--- Chạy Question 12 ---");
            exercise.question12(data.departments);

            // Chạy Question 13
            System.out.println("\n--- Chạy Question 13 ---");
            exercise.question13(data.accounts);

            // Chạy Question 14
            System.out.println("\n--- Chạy Question 14 ---");
            exercise.question14(data.accounts);

            // Chạy Question 15
            System.out.println("\n--- Chạy Question 15 ---");
            exercise.question15();

            // Chạy Question 16
            System.out.println("\n--- Chạy Question 16 ---");
            exercise.question16(data.accounts);

            // Chạy Question 17
            System.out.println("\n--- Chạy Question 17 ---");
            exercise.question17(data.accounts);
    }
}