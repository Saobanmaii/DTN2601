package backend.repository.impl;

import backend.repository.IPositionRepository;
import entity.Position;
import enums.PositionName;
import utils.JDBCUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PositionRepositoryImpl implements IPositionRepository {

    @Override
    public List<Position> findAll() {
        List<Position> list = new ArrayList<>();
        String sql = "SELECT positionID, positionName FROM position";
        try (Connection conn = JDBCUtils.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                list.add(new Position(rs.getInt("positionID"), PositionName.valueOf(rs.getString("positionName"))));
            }
        } catch (SQLException e) {
            System.out.println("Loi ket noi CSDL: " + e.getMessage());
        }
        return list;
    }

    @Override
    public boolean save(Position pos) {
        String sql = "INSERT INTO position (positionName) VALUES (?)";
        try (Connection conn = JDBCUtils.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, pos.getPositionName().name());
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Loi them chuc vu: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean update(int id, PositionName newName) {
        String sql = "UPDATE position SET positionName=? WHERE positionID=?";
        try (Connection conn = JDBCUtils.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, newName.name());
            pstmt.setInt(2, id);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Loi sua chuc vu: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean deleteById(int id) {
        String sql = "DELETE FROM position WHERE positionID=?";
        try (Connection conn = JDBCUtils.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Loi xoa chuc vu: " + e.getMessage());
            return false;
        }
    }

    @Override
    public List<Position> findByName(String name) {
        List<Position> list = new ArrayList<>();
        String sql = "SELECT positionID, positionName FROM position WHERE positionName LIKE ?";
        try (Connection conn = JDBCUtils.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, "%" + name.toUpperCase() + "%");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                list.add(new Position(rs.getInt("positionID"), PositionName.valueOf(rs.getString("positionName"))));
            }
        } catch (SQLException e) {
            System.out.println("Loi tim kiem chuc vu: " + e.getMessage());
        }
        return list;
    }

    @Override
    public boolean existsByName(PositionName name) {
        String sql = "SELECT COUNT(1) FROM position WHERE positionName=?";
        try (Connection conn = JDBCUtils.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name.name());
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) return rs.getInt(1) > 0;
        } catch (SQLException e) {
            System.out.println("Loi kiem tra chuc vu: " + e.getMessage());
        }
        return false;
    }

    @Override
    public boolean existsById(int id) {
        String sql = "SELECT COUNT(1) FROM position WHERE positionID=?";
        try (Connection conn = JDBCUtils.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) return rs.getInt(1) > 0;
        } catch (SQLException e) {
            System.out.println("Loi kiem tra chuc vu: " + e.getMessage());
        }
        return false;
    }

    @Override
    public boolean existsByNameExcludingId(PositionName name, int id) {
        String sql = "SELECT COUNT(1) FROM position WHERE positionName=? AND positionID <> ?";
        try (Connection conn = JDBCUtils.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name.name());
            pstmt.setInt(2, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) return rs.getInt(1) > 0;
        } catch (SQLException e) {
            System.out.println("Loi kiem tra chuc vu: " + e.getMessage());
        }
        return false;
    }
}
