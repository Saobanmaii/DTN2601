package backend.repository.impl;

import backend.repository.IAccountRepository;
import entity.Account;
import entity.Department;
import entity.Position;
import enums.PositionName;
import utils.JDBCUtils;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AccountRepositoryImpl implements IAccountRepository {

    private static final String SELECT_JOIN =
            "SELECT a.accountID, a.email, a.username, a.fullName, a.createDate, "
            + "d.departmentID, d.departmentName, p.positionID, p.positionName "
            + "FROM account a "
            + "LEFT JOIN department d ON a.departmentID = d.departmentID "
            + "LEFT JOIN position p ON a.positionID = p.positionID";

    @Override
    public List<Account> findAll() {
        List<Account> list = new ArrayList<>();
        try (Connection conn = JDBCUtils.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(SELECT_JOIN);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                list.add(buildAccount(rs));
            }
        } catch (SQLException e) {
            System.out.println("Loi ket noi CSDL: " + e.getMessage());
        }
        return list;
    }

    @Override
    public boolean save(Account acc) {
        String sql = "INSERT INTO account (email, username, fullName, createDate, departmentID, positionID) VALUES (?,?,?,?,?,?)";
        try (Connection conn = JDBCUtils.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, acc.getEmail());
            pstmt.setString(2, acc.getUsername());
            pstmt.setString(3, acc.getFullName());
            pstmt.setDate(4, Date.valueOf(LocalDate.now()));
            pstmt.setObject(5, acc.getDepartment() != null ? acc.getDepartment().getDepartmentID() : null);
            pstmt.setObject(6, acc.getPosition() != null ? acc.getPosition().getPositionID() : null);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Loi them tai khoan: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean updateUsernameById(int id, String newUsername) {
        String sql = "UPDATE account SET username=? WHERE accountID=?";
        try (Connection conn = JDBCUtils.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, newUsername);
            pstmt.setInt(2, id);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Loi sua tai khoan: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean deleteById(int id) {
        String sql = "DELETE FROM account WHERE accountID=?";
        try (Connection conn = JDBCUtils.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Loi xoa tai khoan: " + e.getMessage());
            return false;
        }
    }

    @Override
    public List<Account> findByName(String name) {
        List<Account> list = new ArrayList<>();
        String sql = SELECT_JOIN + " WHERE a.fullName LIKE ?";
        try (Connection conn = JDBCUtils.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, "%" + name + "%");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                list.add(buildAccount(rs));
            }
        } catch (SQLException e) {
            System.out.println("Loi tim kiem tai khoan: " + e.getMessage());
        }
        return list;
    }

    @Override
    public boolean existsByUsername(String username) {
        String sql = "SELECT COUNT(1) FROM account WHERE username=?";
        try (Connection conn = JDBCUtils.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) return rs.getInt(1) > 0;
        } catch (SQLException e) {
            System.out.println("Loi kiem tra tai khoan: " + e.getMessage());
        }
        return false;
    }

    @Override
    public boolean existsByEmail(String email) {
        String sql = "SELECT COUNT(1) FROM account WHERE email=?";
        try (Connection conn = JDBCUtils.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, email);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) return rs.getInt(1) > 0;
        } catch (SQLException e) {
            System.out.println("Loi kiem tra tai khoan: " + e.getMessage());
        }
        return false;
    }

    @Override
    public boolean existsById(int id) {
        String sql = "SELECT COUNT(1) FROM account WHERE accountID=?";
        try (Connection conn = JDBCUtils.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) return rs.getInt(1) > 0;
        } catch (SQLException e) {
            System.out.println("Loi kiem tra tai khoan: " + e.getMessage());
        }
        return false;
    }

    @Override
    public boolean existsByUsernameExcludingId(String username, int id) {
        String sql = "SELECT COUNT(1) FROM account WHERE username=? AND accountID <> ?";
        try (Connection conn = JDBCUtils.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, username);
            pstmt.setInt(2, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) return rs.getInt(1) > 0;
        } catch (SQLException e) {
            System.out.println("Loi kiem tra tai khoan: " + e.getMessage());
        }
        return false;
    }

    @Override
    public boolean departmentExists(int departmentId) {
        String sql = "SELECT COUNT(1) FROM department WHERE departmentID=?";
        try (Connection conn = JDBCUtils.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, departmentId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) return rs.getInt(1) > 0;
        } catch (SQLException e) {
            System.out.println("Loi kiem tra phong ban: " + e.getMessage());
        }
        return false;
    }

    @Override
    public boolean positionExists(int positionId) {
        String sql = "SELECT COUNT(1) FROM position WHERE positionID=?";
        try (Connection conn = JDBCUtils.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, positionId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) return rs.getInt(1) > 0;
        } catch (SQLException e) {
            System.out.println("Loi kiem tra chuc vu: " + e.getMessage());
        }
        return false;
    }

    private Account buildAccount(ResultSet rs) throws SQLException {
        Department dept = new Department(rs.getInt("departmentID"), rs.getString("departmentName"));
        Position pos = null;
        String posName = rs.getString("positionName");
        if (posName != null) {
            pos = new Position(rs.getInt("positionID"), PositionName.valueOf(posName));
        }
        Date sqlDate = rs.getDate("createDate");
        LocalDate createDate = (sqlDate != null) ? sqlDate.toLocalDate() : null;
        return new Account(rs.getInt("accountID"), rs.getString("email"),
                rs.getString("username"), rs.getString("fullName"), dept, pos, createDate);
    }
}
