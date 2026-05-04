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

//    Question 2:
//    Tạo constructor cho Account:
//    a) Không có parameters
    public Account() { }
//    b) Có các parameter là id, Email, Username, FirstName, LastName (với FullName = FirstName + LastName)
    public Account(int accountID, String email, String username, String FirstName, String LastName) {
        this.accountID = accountID;
        this.email = email;
        this.username = username;
        this.fullName = FirstName + LastName;
    }
//    c) Có các parameter là id, Email, Username, FirstName, LastName (với FullName = FirstName + LastName) và Position của User, default createDate = now
    public Account(int accountID, String email, String username, String FirstName, String LastName, Position position) {
        this.accountID = accountID;
        this.email = email;
        this.username = username;
        this.fullName = FirstName + LastName;
        this.position = position;
        this.createDate = LocalDate.now();
    }
//    d) Có các parameter là id, Email, Username, FirstName, LastName (với FullName = FirstName + LastName) và Position của User, createDate.
//    Khởi tạo 1 Object với mỗi constructor ở trên.

    public Account(String username) {
        this.username = username;
    }

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

    public LocalDate getCreateDate() { return createDate; }
}
