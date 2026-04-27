package Entity;

import java.time.LocalDateTime;

public class Exam {
    private int examID;
    private String code;
    private String title;
    private CategoryQuestion category;
    private int duration;
    private Account creator;
    private LocalDateTime createDate;

    public Exam(int examID, String code, String title, CategoryQuestion category,
                int duration, Account creator, LocalDateTime createDate) {
        this.examID = examID;
        this.code = code;
        this.title = title;
        this.category = category;
        this.duration = duration;
        this.creator = creator;
        this.createDate = createDate;
    }
    public LocalDateTime getCreateDate() { return createDate; }
}
