package jp.co.internous.prototype.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jp.co.internous.prototype.util.DBConnector;
public class LoginUserDAO {

	public boolean checkLogin(String user, String password) {
		boolean login = false;
		Connection conn = DBConnector.getConnection();
		try {
			String sql = "select * from user_info where user_email = ? and user_password = ?";
			PreparedStatement ps = (PreparedStatement)conn.prepareStatement(sql);
			ps.setString(1,  user);
			ps.setString(2,  password);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) login = true;
		} catch (SQLException e) {
			return login;
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					return login;
				}
			}
		}
		return login;
	}

	public String getUserName(String email) {
		String username = "";
		Connection conn = DBConnector.getConnection();
		try {
			String sql = "select * from user_info where user_email = ?";
			PreparedStatement ps = (PreparedStatement)conn.prepareStatement(sql);
			ps.setString(1,  email);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) username = rs.getString("userName");
		} catch (SQLException e) {
			return username;
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					return username;
				}
			}
		}
		return username;
	}
}
