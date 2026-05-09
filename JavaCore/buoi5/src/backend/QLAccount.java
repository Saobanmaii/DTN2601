package backend;

import entity.Account;
import entity.Department;
import entity.Position;
import enums.PositionName;

import java.sql.*;
import java.time.LocalDate;

public class QLAccount {

    public void printAll() {
        String sql = "SELECT a.accountID, a.email, a.username, a.fullName, a.createDate, "
                   + "d.departmentID, d.departmentName, "
                   + "p.positionID, p.positionName "
                   + "FROM account a "
                   + "LEFT JOIN department d ON a.departmentID = d.departmentID "
                   + "LEFT JOIN position p ON a.positionID = p.positionID";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            System.out.println("===== DANH SACH TAI KHOAN =====");
            while (rs.next()) {
                Department dept = new Department(
                        rs.getInt("departmentID"),
                        rs.getString("departmentName")
                );
                Position pos = new Position(
                        rs.getInt("positionID"),
                        PositionName.valueOf(rs.getString("positionName"))
                );
                Date sqlDate = rs.getDate("createDate");
                LocalDate createDate = (sqlDate != null) ? sqlDate.toLocalDate() : null;

                Account acc = new Account(
                        rs.getInt("accountID"),
                        rs.getString("email"),
                        rs.getString("username"),
                        rs.getString("fullName"),
                        dept,
                        pos,
                        createDate
                );
                System.out.println(acc);
            }

        } catch (SQLException e) {
            System.out.println("Loi ket noi CSDL: " + e.getMessage());
        }
    }
}
