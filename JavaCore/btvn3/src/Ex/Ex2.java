package Ex;

import Entity.Account;

import java.time.LocalDate;

public class Ex2 {
    public static void question1() {
        Account[] accounts = new Account[5];

        for (int i = 1; i <= 5; i++) {
            accounts[i - 1] = new Account(
                    i,
                    "Email " + i,
                    "User name " + i,
                    "Full name " + i,
                    null,
                    null,
                    LocalDate.now()
            );
        }

        // In ra để kiểm tra
        for (Account acc : accounts) {
            System.out.println("Email: " + acc.getEmail()
                    + " | Username: " + acc.getUsername()
                    + " | FullName: " + acc.getFullName()
                    + " | CreateDate: " + acc.getCreateDate()
            );
        }

    }

}