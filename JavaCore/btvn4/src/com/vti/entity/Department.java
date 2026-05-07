package com.vti.entity;

public class Department {
    private int departmentID;
    private String departmentName;

    // a) Không có parameters
    public Department() { }

    // b) Có 1 parameter là nameDepartment và default id của Department = 0
    public Department(String departmentName) {
        this.departmentName = departmentName;
        this.departmentID = 0;
    }

    public Department(int departmentID, String departmentName) {
        this.departmentID = departmentID;
        this.departmentName = departmentName;
    }

    public int getDepartmentID() { return departmentID; }
    public void setDepartmentID(int departmentID) { this.departmentID = departmentID; }

    public String getDepartmentName() { return departmentName; }
    public void setDepartmentName(String departmentName) { this.departmentName = departmentName; }

    @Override
    public String toString() {
        return "Id phong ban: " + departmentID + " - Ten phong ban: " + departmentName;
    }
}
