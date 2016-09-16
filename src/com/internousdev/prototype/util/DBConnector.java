package com.internousdev.prototype.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 * DBconnector DBから情報を取得するメソッド
 * @author 鈴木浩太
 * @since 2015/06/25
 * @param driverName  ドライバー名
 * @param url         url名
 * @param user        ユーザー名
 * @param pass        パスワード
 * @throws ClassNotFoundException
 * @throws SQLException
 * @return con
 */
public class DBConnector {

    private static String driverName = "com.mysql.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost/prototype05";
    private static String user = "root";
    private static String pass = "mysql";
    public static Connection getConnection() {

        Connection con = null;
        try {
            Class.forName(driverName);
            con = DriverManager.getConnection(url,user,pass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }
}