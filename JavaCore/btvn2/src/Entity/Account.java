package Entity;
import java.time.LocalDate;

public class Account {
    private int accountID;
    private String email;
    private String username;
    private String fullName;
    private Department department;
    private Position position;
    private LocalDate createDate;
    private Group[] groups;

    public Account(int accountID, String email, String username, String fullName,
                   Department department, Position position, LocalDate createDate) {
        this.accountID = accountID;
        this.email = email;
        this.username = username;
        this.fullName = fullName;
        this.department = department;
        this.position = position;
        this.createDate = createDate;
    }

    public int getAccountID() { return accountID; }
    public String getEmail() { return email; }
    public String getUsername() { return username; }
    public String getFullName() { return fullName; }
    public Department getDepartment() { return department; }
    public Position getPosition() { return position; }
    public Group[] getGroups() { return groups; }
    public void setGroups(Group[] groups) { this.groups = groups; }
}
