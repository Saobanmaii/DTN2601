package Entity;

import java.time.LocalDate;

public class Group {
    private int groupID;
    private String groupName;
    private Account creator;
    private LocalDate createDate;
    private Account[] accounts;

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