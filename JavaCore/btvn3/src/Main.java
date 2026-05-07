import com.vti.backend.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
    DataInitializer data = new DataInitializer();
    data.initData();
    System.out.println("Chay Ex1");
        Ex1.question1();
        Ex1.question2();
        Ex1.question3();
        Ex1.question4();
    System.out.println("Ket thuc Ex1");

    System.out.println("Chay Ex2");
        Ex2.question1();
    System.out.println("Ket thuc Ex2");

    System.out.println("Chay Ex3");
        Ex3.question1();
        Ex3.question2();
        Ex3.question3();
    System.out.println("Ket thuc Ex3");


    System.out.println("Chay Ex4");
        Ex4.question1();
        Ex4.question2();
        Ex4.question3();
        Ex4.question4();
        Ex4.question5();
        Ex4.question6();
        Ex4.question7();
        Ex4.question8();
        Ex4.question9();
        Ex4.question10();
        Ex4.question11();
        Ex4.question12();
        Ex4.question13();
        Ex4.question14();
        Ex4.question15();
        Ex4.question16();
    System.out.println("Ket thuc Ex4");

    System.out.println("Chay Ex5");
        Ex5.question1(data.departments[0]);
        Ex5.question2(data.departments);
        Ex5.question3(data.departments[0]);
        Ex5.question4(data.departments[0]);
        Ex5.question5(data.departments[0], data.departments[1]);
        Ex5.question6();
        Ex5.question7();
    System.out.println("Ket thuc Ex5");
    }
}