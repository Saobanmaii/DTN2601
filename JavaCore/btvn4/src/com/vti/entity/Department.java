package Entity;

public class Department {
    private int departmentID;
    private String departmentName;

//    Question 1:
//    Tạo constructor cho department:
//    a) Không có parameters
    public Department() { }
//    b) Có 1 parameter là nameDepartment và default id của Department = 0
//    Khởi tạo 1 Object với mỗi constructor ở trên
    public Department(String departmentName) {
        this.departmentName = departmentName;
        this.departmentID = 0;
    }

    public Department(int departmentID, String departmentName) {
        this.departmentID = departmentID;
        this.departmentName = departmentName;
    }
    public int getDepartmentID() { return departmentID; }
    public String getDepartmentName() { return departmentName; }

    public String toString() {
        return "Id phong ban: " + departmentID + " - Ten phong ban: " + departmentName ;
    }
}
