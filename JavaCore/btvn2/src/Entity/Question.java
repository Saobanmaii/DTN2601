package Entity;

import java.time.LocalDate;

public class Question {
    private int questionID;
    private String content;
    private CategoryQuestion category;
    private TypeQuestion type;
    private Account creator;
    private LocalDate createDate;

    public Question(int questionID, String content, CategoryQuestion category,
                    TypeQuestion type, Account creator, LocalDate createDate) {
        this.questionID = questionID;
        this.content = content;
        this.category = category;
        this.type = type;
        this.creator = creator;
        this.createDate = createDate;
    }
}
