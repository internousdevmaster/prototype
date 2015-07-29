package jp.co.internous.prototype.dto;
/**
 * CalendarDTO カレンダー情報を格納するクラス
 * @author 鈴木浩太
 * @since 2015/06/28
 * @version 1.0
 */
public class CalendarDTO {
	/**
	 * 日付
	 */
	private String date;
	/**
	 * 日のみ
	 */
	private String day;
	/**
	 * 日付取得メゾット
	 * @author 鈴木浩太
	 * @since  2015/06/28
	 * @return date
	 */
	public String getDate() {
		return date;
	}
	/**
	 * 日付格納メゾット
	 * @author 鈴木浩太
	 * @since  2015/06/28
	 * @param date 日付
	 */
	public void setDate(String date) {
		this.date = date;
	}
	/**
	 * 日のみ取得メゾット
	 * @author 鈴木浩太
	 * @since  2015/06/28
	 * @return day
	 */
	public String getDay() {
		return day;
	}
	/**
	 * 日のみ格納メゾット
	 * @author 鈴木浩太
	 * @since  2015/06/28
	 * @param day 日
	 */
	public void setDay(String day) {
		this.day = day;
	}
}
