package com.internousdev.prototype.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.internousdev.prototype.dto.CalendarDTO;
import com.internousdev.prototype.util.DBConnector;
/**
 * カレンダーを生成するDAO
 * @author 鈴木　浩太
 * @since 2015/6/28
 * @see com.internousdev.prototype.dao
 */
public class CalendarDAO {
	/**
	 * リスト
	 */
	private List<CalendarDTO> list = new ArrayList<CalendarDTO>();
	/**
	 * カレンダーを生成し、アクションと連動して画面上に表示する実行メソッド
	 * @author 鈴木浩太
	 * @since 2015/06/28
	 * @return create
	 */
	public int createCalendar(int month, int year) {
		if(checkIfCalendarExists()) deleteCalendar();
		int create = 0;

		Connection conn = DBConnector.getConnection();
		Calendar cal = Calendar.getInstance();
		
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String date = dateFormat.format(cal.getTime());
		if(month == 12) month = 0;
		try {
			while(cal.get(Calendar.MONTH) == month) {
				CalendarDTO dto = new CalendarDTO();
				String[] split = date.split("-");
				String sql = "insert into calendar(day)values(?)";
				PreparedStatement ps = (PreparedStatement)conn.prepareStatement(sql);
				ps.setString(1, date);

				int count = 1;
				while(split[2].equals("01") && cal.get(Calendar.DAY_OF_WEEK) != count && list.size() < 8) {
					CalendarDTO tempdto = new CalendarDTO();
					tempdto.setDate("無効");
					list.add(tempdto);
					count++;
				}
				dto.setDate(date);
				dto.setDay(split[2]);
				list.add(dto);
				create += ps.executeUpdate();
				cal.add(Calendar.DATE, 1);
				date = dateFormat.format(cal.getTime());
			}
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
	/**
	 * カレンダーが存在しているか確かめるメソッド
	 * @author 鈴木浩太
	 * @since 2015/06/28
	 * @return exists
	 */
	public boolean checkIfCalendarExists() {
		boolean exists = false;
		Connection conn = DBConnector.getConnection();
		try {
			String sql = "select * from calendar";
			PreparedStatement ps = (PreparedStatement)conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			exists = rs.next();
		} catch (SQLException e) {
			return exists;
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					return exists;
				}
			}
		}
		return exists;
	}
	/**
	 * カレンダーを削除するメソッド
	 * @author 鈴木浩太
	 * @since 2015/06/28
	 * @return delete
	 */
	public boolean deleteCalendar() {
		boolean delete = false;
		Connection conn = DBConnector.getConnection();
		try {
			String sql = "delete from calendar";
			PreparedStatement ps = (PreparedStatement)conn.prepareStatement(sql);
			if(ps.executeUpdate() > 0) delete = true;
		} catch (SQLException e) {
			return delete;
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					return delete;
				}
			}
		}
		return delete;
	}
	/**
	 * カレンダーリスト取得メゾット
	 * @author 鈴木浩太
	 * @since  2015/06/28
	 * @return List<CalendarDTO>
	 */
	public List<CalendarDTO> getList() {
		return list;
	}
	/**
	 * カレンダーリスト格納メゾット
	 * @author 鈴木浩太
	 * @since  2015/06/28
	 * @param List カレンダーリスト
	 */
	public void setList(List<CalendarDTO> list) {
		this.list = list;
	}
}
