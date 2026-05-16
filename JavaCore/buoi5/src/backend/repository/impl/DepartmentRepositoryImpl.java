package backend.repository.impl;

import backend.repository.IDepartmentRepository;
import entity.Department;
import utils.JDBCUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DepartmentRepositoryImpl implements IDepartmentRepository {

    @Override
    public List<Department> findAll() {
        List<Department> list = new ArrayList<>();
        String sql = "SELECT departmentID, departmentName FROM department";
        try (Connection conn = JDBCUtils.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                list.add(new Department(rs.getInt("departmentID"), rs.getString("departmentName")));
            }
        } catch (SQLException e) {
            System.out.println("Loi ket noi CSDL: " + e.getMessage());
        }
        return list;
    }

    @Override
    public boolean save(Department dept) {
        String sql = "INSERT INTO department (departmentName) VALUES (?)";
        try (Connection conn = JDBCUtils.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, dept.getDepartmentName());
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Loi them phong ban: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean update(int id, String newName) {
        String sql = "UPDATE department SET departmentName=? WHERE departmentID=?";
        try (Connection conn = JDBCUtils.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, newName);
            pstmt.setInt(2, id);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Loi sua phong ban: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean deleteById(int id) {
        String sql = "DELETE FROM department WHERE departmentID=?";
        try (Connection conn = JDBCUtils.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Loi xoa phong ban: " + e.getMessage());
            return false;
        }
    }

    @Override
    public List<Department> findByName(String name) {
        List<Department> list = new ArrayList<>();
        String sql = "SELECT departmentID, departmentName FROM department WHERE departmentName LIKE ?";
        try (Connection conn = JDBCUtils.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, "%" + name + "%");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                list.add(new Department(rs.getInt("departmentID"), rs.getString("departmentName")));
            }
        } catch (SQLException e) {
            System.out.println("Loi tim kiem phong ban: " + e.getMessage());
        }
        return list;
    }

    @Override
    public boolean existsByName(String name) {
        String sql = "SELECT COUNT(1) FROM department WHERE departmentName LIKE ?";
        try (Connection conn = JDBCUtils.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) return rs.getInt(1) > 0;
        } catch (SQLException e) {
            System.out.println("Loi kiem tra phong ban: " + e.getMessage());
        }
        return false;
    }

    @Override
    public boolean existsById(int id) {
        String sql = "SELECT COUNT(1) FROM department WHERE departmentID=?";
        try (Connection conn = JDBCUtils.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) return rs.getInt(1) > 0;
        } catch (SQLException e) {
            System.out.println("Loi kiem tra phong ban: " + e.getMessage());
        }
        return false;
    }

    @Override
    public boolean existsByNameExcludingId(String name, int id) {
        String sql = "SELECT COUNT(1) FROM department WHERE departmentName LIKE ? AND departmentID <> ?";
        try (Connection conn = JDBCUtils.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setInt(2, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) return rs.getInt(1) > 0;
        } catch (SQLException e) {
            System.out.println("Loi kiem tra phong ban: " + e.getMessage());
        }
        return false;
    }

    @Override
    public void findDepartmentWithMostEmployees() {
        String sql = "SELECT d.departmentID, d.departmentName, COUNT(a.accountID) AS empCount "
                + "FROM department d LEFT JOIN account a ON d.departmentID = a.departmentID "
                + "GROUP BY d.departmentID, d.departmentName "
                + "HAVING COUNT(a.accountID) = ("
                + "  SELECT MAX(cnt) FROM (SELECT COUNT(accountID) AS cnt FROM account GROUP BY departmentID) AS sub"
                + ")";
        try (Connection conn = JDBCUtils.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            System.out.println("===== PHONG BAN CO NHIEU NHAN VIEN NHAT =====");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("departmentID")
                        + " | Ten: " + rs.getString("departmentName")
                        + " | So NV: " + rs.getInt("empCount"));
            }
        } catch (SQLException e) {
            System.out.println("Loi thong ke: " + e.getMessage());
        }
    }

    @Override
    public void findDepartmentWithLeastEmployees() {
        String sql = "SELECT d.departmentID, d.departmentName, COUNT(a.accountID) AS empCount "
                + "FROM department d LEFT JOIN account a ON d.departmentID = a.departmentID "
                + "GROUP BY d.departmentID, d.departmentName "
                + "HAVING COUNT(a.accountID) = ("
                + "  SELECT MIN(cnt) FROM (SELECT COUNT(accountID) AS cnt FROM account GROUP BY departmentID) AS sub"
                + ")";
        try (Connection conn = JDBCUtils.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            System.out.println("===== PHONG BAN CO IT NHAN VIEN NHAT =====");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("departmentID")
                        + " | Ten: " + rs.getString("departmentName")
                        + " | So NV: " + rs.getInt("empCount"));
            }
        } catch (SQLException e) {
            System.out.println("Loi thong ke: " + e.getMessage());
        }
    }

    @Override
    public void findPositionWithMostEmployees() {
        String sql = "SELECT p.positionID, p.positionName, COUNT(a.accountID) AS empCount "
                + "FROM position p LEFT JOIN account a ON p.positionID = a.positionID "
                + "GROUP BY p.positionID, p.positionName "
                + "HAVING COUNT(a.accountID) = ("
                + "  SELECT MAX(cnt) FROM (SELECT COUNT(accountID) AS cnt FROM account GROUP BY positionID) AS sub"
                + ")";
        try (Connection conn = JDBCUtils.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            System.out.println("===== CHUC VU CO NHIEU NHAN VIEN NHAT =====");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("positionID")
                        + " | Ten: " + rs.getString("positionName")
                        + " | So NV: " + rs.getInt("empCount"));
            }
        } catch (SQLException e) {
            System.out.println("Loi thong ke: " + e.getMessage());
        }
    }

    @Override
    public void findPositionWithLeastEmployees() {
        String sql = "SELECT p.positionID, p.positionName, COUNT(a.accountID) AS empCount "
                + "FROM position p LEFT JOIN account a ON p.positionID = a.positionID "
                + "GROUP BY p.positionID, p.positionName "
                + "HAVING COUNT(a.accountID) = ("
                + "  SELECT MIN(cnt) FROM (SELECT COUNT(accountID) AS cnt FROM account GROUP BY positionID) AS sub"
                + ")";
        try (Connection conn = JDBCUtils.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            System.out.println("===== CHUC VU CO IT NHAN VIEN NHAT =====");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("positionID")
                        + " | Ten: " + rs.getString("positionName")
                        + " | So NV: " + rs.getInt("empCount"));
            }
        } catch (SQLException e) {
            System.out.println("Loi thong ke: " + e.getMessage());
        }
    }
}
