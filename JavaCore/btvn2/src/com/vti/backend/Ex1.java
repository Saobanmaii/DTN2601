package Ex;
import Entity.*;

public class Ex1 {

    public void question1(Account acc2) {
        if (acc2.getDepartment() == null) {
            System.out.println("Nhân viên này chưa có phòng ban");
        } else {
            System.out.println("Phòng ban của nhân viên này là " + acc2.getDepartment().getDepartmentName());
        }
    }

    public void question2(Account acc2) {
        int groupCount = (acc2.getGroups() != null) ? acc2.getGroups().length : 0;

        if (groupCount == 0) {
            System.out.println("Nhân viên này chưa có group");
        } else if (groupCount == 1 || groupCount == 2) {
            System.out.print("Group của nhân viên này là : ");
            for (int i = 0; i < groupCount; i++) {
                System.out.print(acc2.getGroups()[i].getGroupName() + ", ");
            }
            System.out.println();
        } else if (groupCount == 3) {
            System.out.println("Nhân viên này là người quan trọng, tham gia nhiều group");
        } else {
            System.out.println("Nhân viên này là người hóng chuyện, tham gia tất cả các group");
        }
    }

    public void question3(Account acc2) {
        String result = (acc2.getDepartment() == null)
                ? "Nhân viên này chưa có phòng ban"
                : "Phòng ban của nhân viên này là " + acc2.getDepartment().getDepartmentName();
        System.out.println(result);
    }

    public void question4(Account acc1) {
        String result = (acc1.getPosition().getPositionName().toString().equals("DEV"))
                ? "Đây là Developer"
                : "Người này không phải là Developer";
        System.out.println(result);
    }

    public void question5(Group group1) {
        int count = (group1.getAccounts() != null) ? group1.getAccounts().length : 0;
        switch (count) {
            case 0:
                System.out.println("Nhóm không có thành viên nào");
            case 1:
                System.out.println("Nhóm có một thành viên");
                break;
            case 2:
                System.out.println("Nhóm có hai thành viên");
                break;
            case 3:
                System.out.println("Nhóm có ba thành viên");
                break;
            default:
                System.out.println("Nhóm có nhiều thành viên");
                break;
        }
    }

    public void question6(Account acc2) {
        int groupCount = (acc2.getGroups() != null) ? acc2.getGroups().length : 0;
        switch (groupCount) {
            case 0:
                System.out.println("Nhân viên này chưa có group");
                break;
            case 1:
            case 2:
                System.out.println("Group của nhân viên này là Java Fresher, C# Fresher");
                break;
            case 3:
                System.out.println("Nhân viên này là người quan trọng, tham gia nhiều group");
                break;
            default:
                System.out.println("Nhân viên này là người hóng chuyện, tham gia tất cả các group");
                break;
        }
    }

    public void question7(Account acc1) {
        switch (acc1.getPosition().getPositionName().toString()) {
            case "DEV":
                System.out.println("Đây là Developer");
                break;
            default:
                System.out.println("Người này không phải là Developer");
                break;
        }
    }

    public void question8(Account[] accounts) {
        for (Account acc : accounts) {
            String depName = (acc.getDepartment() != null) ? acc.getDepartment().getDepartmentName() : "No Department";
            System.out.println("Email: " + acc.getEmail() + " | FullName: " + acc.getFullName() + " | Phòng ban: " + depName);
        }
    }

    public void question9(Department[] departments) {
        for (Department dep : departments) {
            System.out.println("ID: " + dep.getDepartmentID() + " | Name: " + dep.getDepartmentName());
        }
    }


    public void question10(Account[] accounts) {
        for (int i = 0; i < accounts.length; i++) {
            System.out.println("Thông tin account thứ " + (i + 1) + " là:");
            System.out.println("Email: " + accounts[i].getEmail());
            System.out.println("Full name: " + accounts[i].getFullName());
            String depName = (accounts[i].getDepartment() != null) ? accounts[i].getDepartment().getDepartmentName() : "None";
            System.out.println("Phòng ban: " + depName);
        }
    }

    public void question11(Department[] departments) {
        for (int i = 0; i < departments.length; i++) {
            System.out.println("Thông tin department thứ " + (i + 1) + " là:");
            System.out.println("Id: " + departments[i].getDepartmentID());
            System.out.println("Name: " + departments[i].getDepartmentName());
        }
    }

    // Question 12
    public void question12(Department[] departments) {
        for (int i = 0; i < 2 && i < departments.length; i++) {
            System.out.println("Thông tin department thứ " + (i + 1) + " là:");
            System.out.println("Id: " + departments[i].getDepartmentID());
            System.out.println("Name: " + departments[i].getDepartmentName());
        }
    }

    public void question13(Account[] accounts) {
        for (int i = 0; i < accounts.length; i++) {
            if (i == 1) {
                continue;
            }
            System.out.println("Thông tin account thứ " + (i + 1) + " là: " + accounts[i].getFullName());
        }
    }

    public void question14(Account[] accounts) {
        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i].getAccountID() >= 4) {
                break;
            }
            System.out.println("Account ID < 4: " + accounts[i].getFullName());
        }
    }

    public void question15() {
        for (int i = 0; i <= 20; i++) {
            if (i % 2 != 0) {
                continue;
            }
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public void question16(Account[] accounts) {
        int i = 0;
        while (i < accounts.length) {
            if (accounts[i].getAccountID() >= 4) {
                break;
            }
            if (i == 1) {
                i++;
                continue;
            }
            System.out.println("Account: " + accounts[i].getFullName());
            i++;
        }
    }

    public void question17(Account[] accounts) {
        int i = 0;
        do {
            if (accounts[i].getAccountID() >= 4) {
                break;
            }
            if (i == 1) {
                i++;
                continue;
            }
            System.out.println("Account: " + accounts[i].getFullName());
            i++;
        } while (i < accounts.length);
    }
}