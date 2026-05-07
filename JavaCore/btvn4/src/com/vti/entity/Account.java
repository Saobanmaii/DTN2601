package com.vti.entity;

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

    // a) Không có parameters
    public Account() { }

    // b) Có các parameter là id, Email, Username, FirstName, LastName (với FullName = FirstName + LastName)
    public Account(int accountID, String email, String username, String firstName, String lastName) {
        this.accountID = accountID;
        this.email = email;
        this.username = username;
        this.fullName = firstName + " " + lastName;
    }

    // c) Có các parameter là id, Email, Username, FirstName, LastName và Position, default createDate = now
    public Account(int accountID, String email, String username, String firstName, String lastName, Position position) {
        this.accountID = accountID;
        this.email = email;
        this.username = username;
        this.fullName = firstName + " " + lastName;
        this.position = position;
        this.createDate = LocalDate.now();
    }

    // d) Có các parameter là id, Email, Username, FirstName, LastName và Position, createDate
    public Account(int accountID, String email, String username, String firstName, String lastName,
                   Position position, LocalDate createDate) {
        this.accountID = accountID;
        this.email = email;
        this.username = username;
        this.fullName = firstName + " " + lastName;
        this.position = position;
        this.createDate = createDate;
    }

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
    public void setAccountID(int accountID) { this.accountID = accountID; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public Department getDepartment() { return department; }
    public void setDepartment(Department department) { this.department = department; }

    public Position getPosition() { return position; }
    public void setPosition(Position position) { this.position = position; }

    public LocalDate getCreateDate() { return createDate; }
    public void setCreateDate(LocalDate createDate) { this.createDate = createDate; }

    public Group[] getGroups() { return groups; }
    public void setGroups(Group[] groups) { this.groups = groups; }
}
