package jp.co.internous.prototype.action;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import jp.co.internous.prototype.dao.CalendarDAO;
import jp.co.internous.prototype.dto.CalendarDTO;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
/**
 * カレンダーを生成するアクション
 * @author 鈴木　浩太
 * @since 2015/6/28
 * @see jp.co.internous.prototype.action
 */
public class CalendarAction extends ActionSupport implements SessionAware {
	/**
	 * カレンダーリスト
	 */
	public List<CalendarDTO> calendarList = new ArrayList<CalendarDTO>();
	/**
	 * セッション
	 */
	private Map<String, Object> session;
	/**
	 * 先月、来月
	 */
	private int move;
	/**
	 * カレンダーを生成し、画面上に表示する実行メソッド
	 * @author 鈴木浩太
	 * @since 2015/06/28
	 * @return result
	 */
	public String execute() {
		String result = ERROR;
		int month = 0, year = 0;
		Calendar cal = Calendar.getInstance();
		CalendarDAO dao = new CalendarDAO();
		if(!session.containsKey("month")) {
			session.put("month", cal.get(Calendar.MONTH));
			session.put("year", cal.get(Calendar.YEAR));
			month = (int)session.get("month");
			year = (int)session.get("year");
		} else {
			month = (int)session.get("month") - 1;
			year = (int)session.get("year");
			if(move == 1) {
				if(month == 11) {
					session.put("month", 0);
					session.put("year", ++year);
					month = 0;
				} else session.put("month", ++month);
			} else if(move == -1){
				if(month == 0) {
					session.put("month", 11);
					session.put("year", --year);
					month = 11;
				} else session.put("month", --month);
			}
		}
		if(dao.createCalendar(month, year) > 0) result = SUCCESS;
		calendarList.addAll(dao.getList());
		session.put("month", month + 1);
		return result;
	}
	/**
	 * カレンダーリスト取得メゾット
	 * @author 鈴木浩太
	 * @since  2015/06/28
	 * @return List<CalendarDTO>
	 */
	public List<CalendarDTO> getList() {
		return calendarList;
	}
	/**
	 * カレンダーリスト格納メゾット
	 * @author 鈴木浩太
	 * @since  2015/06/28
	 * @param calendarList カレンダーリスト
	 */
	public void setList(List<CalendarDTO> calendarList) {
		this.calendarList = calendarList;
	}
	/**
	 * セッション格納メゾット
	 * @author 鈴木浩太
	 * @since  2015/06/28
	 * @param session セッション
	 */
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	/**
	 * セッション取得メゾット
	 * @author 鈴木浩太
	 * @since  2015/06/28
	 * @return Map<String, Object>
	 */
	public Map<String, Object> getSession() {
		return session;
	}
	/**
	 * 先月、来月取得メゾット
	 * @author 鈴木浩太
	 * @since  2015/06/28
	 * @return move
	 */
	public int getMove() {
		return move;
	}
	/**
	 * 先月、来月格納メゾット
	 * @author 鈴木浩太
	 * @since  2015/06/28
	 * @param move 先月、来月
	 */
	public void setMove(int move) {
		this.move = move;
	}
}
