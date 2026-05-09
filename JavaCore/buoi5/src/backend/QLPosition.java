package backend;

import entity.Position;
import enums.PositionName;

import java.sql.*;

public class QLPosition {

    public void printAll() {
        String sql = "SELECT positionID, positionName FROM position";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            System.out.println("===== DANH SACH CHUC VU =====");
            while (rs.next()) {
                Position pos = new Position(
                        rs.getInt("positionID"),
                        PositionName.valueOf(rs.getString("positionName"))
                );
                System.out.println(pos);
            }

        } catch (SQLException e) {
            System.out.println("Loi ket noi CSDL: " + e.getMessage());
        }
    }
}
