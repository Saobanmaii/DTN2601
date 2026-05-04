package Ex;

import com.vti.entity.Account;
import com.vti.entity.Department;
import com.vti.entity.Group;
import com.vti.entity.Position;
import java.time.LocalDate;


public class Ex1 {
    public static void Question1() {
        Department department1 = new Department();
        Department department2 = new Department( "Marketing");
    }

    public static void Question2() {
        Account account1 = new Account();
        Account account2 = new Account(1, "Abc@gmail.com", "abc", "Tran", "Tuan Kiet");
        Account account3 = new Account(2,"Abcd@gmail.com", "cde", "Tran", "Tuan Tu", new Position() );
        LocalDate localDate = LocalDate.now();
        Account account4 = new Account(3, "Abcde@gmail.com", "efg", "Tran Tuan Kiet", new Department(), new Position(), localDate);
    }

    public static void Question3() {
            // a) Constructor không có parameters
            Group group1 = new Group();

            // b) Constructor có GroupName, Creator, Account[] accounts, CreateDate
            Account creator = new Account(1, "creator@gmail.com", "creator", "Nguyen Van A", null, null, LocalDate.of(2020, 1, 1));
            Account[] accounts = {
                    new Account(2, "user1@gmail.com", "user1", "Tran Van B", null, null, LocalDate.of(2021, 5, 10)),
                    new Account(3, "user2@gmail.com", "user2", "Le Van C", null, null, LocalDate.of(2022, 3, 20))
            };
            Group group2 = new Group("Dev Team", creator, accounts, LocalDate.of(2023, 1, 1));

            // c) Constructor có GroupName, Creator, String[] usernames, CreateDate
            String[] usernames = {"alice", "bob", "charlie"};
            Group group3 = new Group("QA Team", creator, usernames, LocalDate.of(2024, 6, 15));
    }
}
