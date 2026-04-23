import java.time.LocalDate;
import java.time.LocalDateTime;
import Entity.*;

public class DataInitializer {
    public Department[] departments;
    public Position[] positions;
    public Account[] accounts;
    public Group[] groups;
    public GroupAccount[] groupAccounts;
    public TypeQuestion[] typeQuestions;
    public CategoryQuestion[] categoryQuestions;
    public Question[] questions;
    public Answer[] answers;
    public Exam[] exams;
    public ExamQuestion[] examQuestions;

    public void initData() {
        // 1. DEPARTMENT

        Department dep1 = new Department(1, "Sale");
        Department dep2 = new Department(2, "Marketing");
        Department dep3 = new Department(3, "BOD");
        Department dep4 = new Department(4, "IT");
        Department dep5 = new Department(5, "HR");
        departments = new Department[]{dep1, dep2, dep3, dep4, dep5};

        // 2. POSITION
        Position pos1 = new Position(1, PositionName.DEV);
        Position pos2 = new Position(2, PositionName.TEST);
        Position pos3 = new Position(3, PositionName.SCRUM_MASTER);
        Position pos4 = new Position(4, PositionName.PM);
        positions = new Position[]{pos1, pos2, pos3, pos4};

        // 3. ACCOUNT
        Account acc1 = new Account(1, "NguyenVanA@gmail.com", "nva", "Nguyễn Văn A", dep1, pos1, LocalDate.of(2020, 3, 15));
        Account acc2 = new Account(2, "NguyenVanB@gmail.com", "nvb", "Nguyễn Văn B", dep2, pos2, LocalDate.of(2021, 5, 20));
        Account acc3 = new Account(3, "NguyenVanC@gmail.com", "nvc", "Nguyễn Văn C", null, pos4, LocalDate.of(2019, 11, 11)); // Không có phòng ban
        Account acc4 = new Account(4, "NguyenVanD@gmail.com", "nvd", "Nguyễn Văn D", dep4, pos1, LocalDate.of(2023, 1, 5));
        Account acc5 = new Account(5, "TranThiE@gmail.com", "tte", "Trần Thị E", dep5, pos3, LocalDate.of(2022, 8, 22));
        Account acc6 = new Account(6, "LeVanF@gmail.com", "lvf", "Lê Văn F", dep4, pos2, LocalDate.of(2023, 6, 10));
        Account acc7 = new Account(7, "PhamThiG@gmail.com", "ptg", "Phạm Thị G", dep1, pos1, LocalDate.now());
        accounts = new Account[]{acc1, acc2, acc3, acc4, acc5, acc6, acc7};

        // 4. GROUP & GROUP ACCOUNT
        Group grp1 = new Group(1, "Java Fresher", acc1, LocalDate.of(2021, 1, 1));
        Group grp2 = new Group(2, "C# Fresher", acc2, LocalDate.of(2021, 6, 15));
        Group grp3 = new Group(3, "Management Board", acc3, LocalDate.of(2020, 1, 1));
        Group grp4 = new Group(4, "Company Camp", acc5, LocalDate.now());
        groups = new Group[]{grp1, grp2, grp3, grp4};

        grp1.setAccounts(new Account[]{acc1, acc2, acc4, acc6});
        grp2.setAccounts(new Account[]{acc2, acc4});
        grp3.setAccounts(new Account[]{acc3, acc5});
        grp4.setAccounts(new Account[]{acc1, acc2, acc3, acc4, acc5, acc6, acc7});

        acc1.setGroups(new Group[]{grp1, grp4});
        acc2.setGroups(new Group[]{grp1, grp2, grp4}); // Tham gia 3 group (để test bài tập)
        acc3.setGroups(new Group[]{grp3, grp4});
        acc4.setGroups(new Group[]{grp1, grp2, grp4});
        acc5.setGroups(new Group[]{grp3, grp4});
        acc6.setGroups(new Group[]{grp1, grp4});
        acc7.setGroups(new Group[]{grp4}); // Mới vào, chỉ ở group tổng cty

        // 5. TYPE QUESTION
        TypeQuestion tq1 = new TypeQuestion(1, TypeName.MULTIPLE_CHOICE);
        TypeQuestion tq2 = new TypeQuestion(2, TypeName.ESSAY);
        typeQuestions = new TypeQuestion[]{tq1, tq2};

        // 6. CATEGORY QUESTION
        CategoryQuestion cq1 = new CategoryQuestion(1, "Java");
        CategoryQuestion cq2 = new CategoryQuestion(2, ".NET");
        CategoryQuestion cq3 = new CategoryQuestion(3, "SQL");
        CategoryQuestion cq4 = new CategoryQuestion(4, "Postman");
        CategoryQuestion cq5 = new CategoryQuestion(5, "Ruby");
        categoryQuestions = new CategoryQuestion[]{cq1, cq2, cq3, cq4, cq5};

        // 7. QUESTION
        Question q1 = new Question(1, "Java là ngôn ngữ lập trình gì?", cq1, tq1, acc1, LocalDate.of(2023, 2, 1));
        Question q2 = new Question(2, "Hãy mô tả 4 tính chất của OOP.", cq1, tq2, acc1, LocalDate.of(2023, 2, 2));
        Question q3 = new Question(3, "Lệnh JOIN nào lấy tất cả bản ghi bên trái?", cq3, tq1, acc4, LocalDate.of(2023, 3, 5));
        Question q4 = new Question(4, "Phân biệt WHERE và HAVING trong SQL.", cq3, tq2, acc4, LocalDate.of(2023, 3, 6));
        Question q5 = new Question(5, "Cách truyền Token vào Header trong Postman?", cq4, tq1, acc2, LocalDate.of(2023, 4, 10));
        Question q6 = new Question(6, "C# hỗ trợ đa kế thừa đối với Class không?", cq2, tq1, acc6, LocalDate.of(2023, 5, 20));
        Question q7 = new Question(7, "Viết code C# đảo ngược chuỗi.", cq2, tq2, acc6, LocalDate.now());
        questions = new Question[]{q1, q2, q3, q4, q5, q6, q7};

        // 8. ANSWER
        answers = new Answer[]{
                // Q1: Multiple choice
                new Answer(1, "Hướng thủ tục", q1, false),
                new Answer(2, "Hướng đối tượng", q1, true),
                new Answer(3, "Hướng hàm", q1, false),
                // Q2: Essay
                new Answer(4, "Đóng gói, Kế thừa, Đa hình, Trừu tượng...", q2, true),
                // Q3: Multiple choice
                new Answer(5, "INNER JOIN", q3, false),
                new Answer(6, "LEFT JOIN", q3, true),
                new Answer(7, "RIGHT JOIN", q3, false),
                // Q4: Essay
                new Answer(8, "WHERE lọc trước khi GROUP BY, HAVING lọc sau...", q4, true),
                // Q5: Multiple choice
                new Answer(9, "Tab Authorization -> Bearer Token", q5, true),
                new Answer(10, "Tab Body -> raw", q5, false),
                // Q6: Multiple choice
                new Answer(11, "Có", q6, false),
                new Answer(12, "Không, chỉ hỗ trợ đa kế thừa Interface", q6, true)
        };

        // 9. EXAM-
        Exam exam1 = new Exam(1, "VTI001", "Đề thi đầu vào Java", cq1, 60, acc3, LocalDateTime.of(2023, 5, 1, 8, 0, 0));
        Exam exam2 = new Exam(2, "VTI002", "Đề thi đầu vào .NET", cq2, 60, acc3, LocalDateTime.of(2023, 5, 2, 14, 30, 0));
        Exam exam3 = new Exam(3, "VTI003", "Kiểm tra kiến thức SQL", cq3, 45, acc1, LocalDateTime.now().minusDays(2));
        exams = new Exam[]{exam1, exam2, exam3};

        // 10. EXAM QUESTION
        examQuestions = new ExamQuestion[]{
                new ExamQuestion(exam1, q1),
                new ExamQuestion(exam1, q2),
                new ExamQuestion(exam2, q6),
                new ExamQuestion(exam2, q7),
                new ExamQuestion(exam3, q3),
                new ExamQuestion(exam3, q4)
        };

        System.out.println("Khởi tạo dữ liệu thành công!");
    }
}