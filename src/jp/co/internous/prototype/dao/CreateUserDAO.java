package jp.co.internous.prototype.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jp.co.internous.prototype.util.DBConnector;

/**
 * CreateUserDAO ユーザー情報をDBに格納するためのメソッド
 * @author 鈴木　浩太
 * @since 2015/6/25
 * @version 1.0
 */
public class CreateUserDAO {
	
	/**
	 * 実行メソッド
	 * @param email メールアドレス
	 * @param password パスワード
	 * @param user 名前
	 * @return create 結果
	 */
	public int createUser(String email, String password, String user) {
		int create = 0;
		Connection conn = DBConnector.getConnection();
		try {
			String sql = "insert into userInfo(user_email, user_password, user_name)values(?, ?, ?)";
			PreparedStatement ps = (PreparedStatement)conn.prepareCall(sql);
			ps.setString(1,  email);
			ps.setString(2, password);
			ps.setString(3, user);
			create = ps.executeUpdate();
		} catch (SQLException e) {
			return create;
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					return create;
				}
			}
		}
		return create;
	}
}
