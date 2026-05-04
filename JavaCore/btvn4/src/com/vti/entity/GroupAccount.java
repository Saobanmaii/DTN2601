package Entity;

import java.time.LocalDate;

public class GroupAccount {
    private Group group;
    private Account account;
    private LocalDate joinDate;

    public GroupAccount(Group group, Account account, LocalDate joinDate) {
        this.group = group;
        this.account = account;
        this.joinDate = joinDate;
    }
}
