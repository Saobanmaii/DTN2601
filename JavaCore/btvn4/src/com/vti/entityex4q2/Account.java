package com.vti.entityex4q2;

public class Account {
    private String id;
    private String name;
    private int balance;

    // Constructor
    public Account(String id, String name, int balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
    }

    // Getters
    public String getID() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getBalance() {
        return balance;
    }

    // Các phương thức giao dịch
    public int credit(int amount) {
        balance += amount;
        return balance;
    }

    public int debit(int amount) {
        if (amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("số tiền rút hoặc chuyển vượt quá số dư hiện có trong tài khoản.");
        }
        return balance;
    }

    public int tranferTo(Account account, int amount) {
        if (amount <= balance) {
            this.balance -= amount;
            account.credit(amount);
        } else {
            System.out.println("số tiền rút hoặc chuyển vượt quá số dư hiện có trong tài khoản.");
        }
        return this.balance;
    }
}
