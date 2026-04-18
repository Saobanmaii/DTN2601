import Entity.*;
import java.time.LocalDate;

public class Program {
    public static void main(String[] args) {
                // --- Khởi tạo Department ---
                Department dep1 = new Department(); dep1.id = 1; dep1.name = "Sale";
                Department dep2 = new Department(); dep2.id = 2; dep2.name = "Marketing";
                Department dep3 = new Department(); dep3.id = 3; dep3.name = "Engineering";

                // --- Khởi tạo Position ---
                Position pos1 = new Position(); pos1.id = 1; pos1.name = PositionName.DEV;
                Position pos2 = new Position(); pos2.id = 2; pos2.name = PositionName.TEST;
                Position pos3 = new Position(); pos3.id = 3; pos3.name = PositionName.PM;

                // --- Khởi tạo Account ---
                Account acc1 = new Account();
                acc1.id = 1; acc1.email = "vti1@gmail.com"; acc1.fullName = "Nguyen Van A";
                acc1.department = dep3; acc1.position = pos1; acc1.createDate = LocalDate.now();

                Account acc2 = new Account();
                acc2.id = 2; acc2.email = "vti2@gmail.com"; acc2.fullName = "Tran Van B";
                acc2.department = dep1; acc2.position = pos3; acc2.createDate = LocalDate.now();

                Account acc3 = new Account();
                acc3.id = 3; acc3.email = "vti3@gmail.com"; acc3.fullName = "Le Thi C";
                acc3.department = dep2; acc3.position = pos2; acc3.createDate = LocalDate.now();

                // --- Khởi tạo Category & Type Question ---
                CategoryQuestion cat1 = new CategoryQuestion(); cat1.id = 1; cat1.name = "Java";
                TypeQuestion type1 = new TypeQuestion(); type1.id = 1; type1.name = TypeName.ESSAY;

                // --- Khởi tạo Question ---
                Question q1 = new Question();
                q1.id = 1; q1.content = "Java là gì?"; q1.category = cat1; q1.type = type1; q1.creator = acc1;

                // --- Khởi tạo Exam ---
                Exam ex1 = new Exam();
                ex1.id = 1; ex1.code = "VTI01"; ex1.title = "Đề thi Java cơ bản"; ex1.duration = 60;

                // --- IN ---
                System.out.println("Thông tin Account 1:");
                System.out.println("ID: " + acc1.id);
                System.out.println("Full Name: " + acc1.fullName);
                System.out.println("Phòng ban: " + acc1.department.name);
                System.out.println("Chức vụ: " + acc1.position.name);
                System.out.println("---------------------------");
                System.out.println("Thông tin Câu hỏi 1:");
                System.out.println("Nội dung: " + q1.content);
                System.out.println("Người tạo: " + q1.creator.fullName);
    }
}
