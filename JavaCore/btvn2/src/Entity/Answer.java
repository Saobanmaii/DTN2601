package Entity;

public class Answer {
    private int answerID;
    private String content;
    private Question question;
    private boolean isCorrect;

    public Answer(int answerID, String content, Question question, boolean isCorrect) {
        this.answerID = answerID;
        this.content = content;
        this.question = question;
        this.isCorrect = isCorrect;
    }
}
