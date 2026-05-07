package com.vti.entity;

import java.time.LocalDate;
import java.util.Objects;

public class Group {
    private int groupID;
    private String groupName;
    private Account creator;
    private LocalDate createDate;
    private Account[] accounts;

    // a) Không có parameters
    public Group() { }

    // b) Có các parameter là GroupName, Creator, array Account[] accounts, CreateDate
    public Group(String groupName, Account creator, Account[] accounts, LocalDate createDate) {
        this.groupName = groupName;
        this.creator = creator;
        this.accounts = accounts;
        this.createDate = createDate;
    }

    // c) Có các parameter là GroupName, Creator, array String[] usernames, CreateDate
    // Với mỗi username thì sẽ khởi tạo 1 Account (chỉ có thông tin username, các thông tin còn lại = null).
    public Group(String groupName, Account creator, String[] usernames, LocalDate createDate) {
        this.groupName = groupName;
        this.creator = creator;
        this.createDate = createDate;
        this.accounts = new Account[usernames.length];
        for (int i = 0; i < usernames.length; i++) {
            accounts[i] = new Account(usernames[i]);
        }
    }

    public Group(int groupID, String groupName, Account creator, LocalDate createDate) {
        this.groupID = groupID;
        this.groupName = groupName;
        this.creator = creator;
        this.createDate = createDate;
    }

    public int getGroupID() { return groupID; }
    public void setGroupID(int groupID) { this.groupID = groupID; }

    public String getGroupName() { return groupName; }
    public void setGroupName(String groupName) { this.groupName = groupName; }

    public Account getCreator() { return creator; }
    public void setCreator(Account creator) { this.creator = creator; }

    public LocalDate getCreateDate() { return createDate; }
    public void setCreateDate(LocalDate createDate) { this.createDate = createDate; }

    public Account[] getAccounts() { return accounts; }
    public void setAccounts(Account[] accounts) { this.accounts = accounts; }

    @Override
    public String toString() {
        return "Group{" +
                "groupID=" + groupID +
                ", groupName='" + groupName + '\'' +
                ", creator=" + (creator != null ? creator.getUsername() : "N/A") +
                ", createDate=" + createDate +
                ", memberCount=" + (accounts != null ? accounts.length : 0) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Group group = (Group) o;
        return groupID == group.groupID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(groupID);
    }
}
