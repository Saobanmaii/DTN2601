package Entity;

import java.time.LocalDate;

public class Group {
    private int groupID;
    private String groupName;
    private Account creator;
    private LocalDate createDate;
    private Account[] accounts;

//    Question 3:
//    Tạo constructor cho Group:
//    a) Không có parameters
    public Group() { }
//    b) Có các parameter là GroupName, Creator, array Account[] accounts, CreateDate
    public Group(String groupName, Account creator, Account[] accounts, LocalDate createDate) {
        this.groupName = groupName;
        this.creator = creator;
        this.accounts = accounts;
        this.createDate = createDate;
    }
//    c) Có các parameter là GroupName, Creator, array String[] usernames , CreateDate
//    Với mỗi username thì sẽ khởi tạo 1 Account (chỉ có thông tin username, các thông tin còn lại = null).
    public Group(String groupName, Account creator, String[] usernames, LocalDate createDate) {
        this.groupName = groupName;
        this.creator = creator;
        this.createDate = createDate;
        this.accounts = new Account[usernames.length];
        for(int i = 0; i < usernames.length; i++) {
            accounts[i] = new Account(usernames[i]);
        }
    }
//    Khởi tạo 1 Object với mỗi constructor ở trên.


    public Group(int groupID, String groupName, Account creator, LocalDate createDate) {
        this.groupID = groupID;
        this.groupName = groupName;
        this.creator = creator;
        this.createDate = createDate;
    }
    public String getGroupName() { return groupName; }
    public Account[] getAccounts() { return accounts; }
    public void setAccounts(Account[] accounts) { this.accounts = accounts; }
}