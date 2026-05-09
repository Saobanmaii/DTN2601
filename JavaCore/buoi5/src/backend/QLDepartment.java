package backend;

import entity.Department;

import java.sql.*;

public class QLDepartment {

    public void printAll() {
        String sql = "SELECT departmentID, departmentName FROM department";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            System.out.println("===== DANH SACH PHONG BAN =====");
            while (rs.next()) {
                Department dept = new Department(
                        rs.getInt("departmentID"),
                        rs.getString("departmentName")
                );
                System.out.println(dept);
            }

        } catch (SQLException e) {
            System.out.println("Loi ket noi CSDL: " + e.getMessage());
        }
    }
}
