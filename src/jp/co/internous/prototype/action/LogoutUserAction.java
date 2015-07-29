package jp.co.internous.prototype.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

/**
 * ログアウトする為のアクションクラス
 * @author 村上　史哉
 * @since  2015/06/25
 * @version  1.0
 */
public class LogoutUserAction extends ActionSupport implements SessionAware {
	private Map<String, Object> session;

	public String execute() {
		String result = ERROR;
		session.remove("user");
		if(!session.containsKey("user")) result = SUCCESS;
		return result;
	}

	/**
	 * セッション情報格納メソッド
	 * @param session セッション
	 */
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	/**
	 * セッション情報取得メソッド
	 * @return session セッション
	 */
	public Map<String, Object> getSession() {
		return session;
	}
}
