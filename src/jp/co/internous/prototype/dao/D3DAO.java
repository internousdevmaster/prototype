package jp.co.internous.prototype.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jp.co.internous.prototype.dto.D3DTO;
import jp.co.internous.prototype.util.DBConnector;

/**
 *
 * @author Kikuchi Satoru
 * @since 2015/06/26
 * @version 1.0
 */
public class D3DAO {
	D3DTO dto = new D3DTO();
	public void d3Dao(){
		Connection con = null;
		try{
			con = DBConnector.getConnection();
			String sql1 = "select count(*) from customer_info where 3<=customer_age and customer_age<7";
			PreparedStatement ps =(PreparedStatement)con.prepareStatement(sql1);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				dto.setCountOld1(rs.getInt(1));
			}
			String sql2 = "select count(*) from customer_info where 7<=customer_age and customer_age<12";
			ps =(PreparedStatement)con.prepareStatement(sql2);
			rs = ps.executeQuery();
			if(rs.next()){
				dto.setCountOld2(rs.getInt(1));
			}
			String sql3 = "select count(*) from customer_info where 12<=customer_age and customer_age<15";
			ps =(PreparedStatement)con.prepareStatement(sql3);
			rs = ps.executeQuery();
			if(rs.next()){
				dto.setCountOld3(rs.getInt(1));
			}
			String sql4 = "select count(*) from customer_info where 15<=customer_age and customer_age<19";
			ps =(PreparedStatement)con.prepareStatement(sql4);
			rs = ps.executeQuery();
			if(rs.next()){
				dto.setCountOld4(rs.getInt(1));
			}
			String sql5 = "select count(*) from customer_info where 19<=customer_age and customer_age<23";
			ps =(PreparedStatement)con.prepareStatement(sql5);
			rs = ps.executeQuery();
			if(rs.next()){
				dto.setCountOld5(rs.getInt(1));
			}
			String sql6 = "select count(*) from customer_info where 23<=customer_age and customer_age<27";
			ps =(PreparedStatement)con.prepareStatement(sql6);
			rs = ps.executeQuery();
			if(rs.next()){
				dto.setCountOld6(rs.getInt(1));;
			}
			String sql7 = "select count(*) from customer_info where 27<=customer_age and customer_age<31";
			ps =(PreparedStatement)con.prepareStatement(sql7);
			rs = ps.executeQuery();
			if(rs.next()){
				dto.setCountOld7(rs.getInt(1));
			}
			String sql8 = "select count(*) from customer_info where 31<=customer_age";
			ps =(PreparedStatement)con.prepareStatement(sql8);
			rs = ps.executeQuery();
			if(rs.next()){
				dto.setCountOld8(rs.getInt(1));
			}

		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * @return dto
	 */
	public D3DTO getDto() {
		return dto;
	}
}
