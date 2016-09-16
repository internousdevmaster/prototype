package com.internousdev.prototype.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.prototype.dao.LoginUserDAO;
import com.opensymphony.xwork2.ActionSupport;
/**
 * LoginUserAction ログイン画面からログインする為のアクション
 * @author Suzuki Erika
 * @since 2015/06/25
 * @version 1.0
 */

public class LoginUserAction extends ActionSupport implements SessionAware {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6604094070617325724L;

	private Map<String, Object> session;

	/**
	 * メールアドレス
	 */
	private String email;

	/**
	 * パスワード
	 */
	private String password;

	/**
	 * メールアドレスとパスワードの照合を行い、DBに登録済みのユーザーネームを引き出し、resultを返すメソッド
	 * @author Suzuki Erika
	 * @since 2015/06/25
	 * @return result
	 */
	public String execute() {
		String result = ERROR;
		LoginUserDAO dao = new LoginUserDAO();
		if(dao.checkLogin(email, password)) {
			result = SUCCESS;
			session.put("email", email);
			session.put("user", dao.getUserName(email));
		}

		return result;
	}

	/**
	 * セッション格納メゾット
	 * @author Suzuki Erika
	 * @since  2015/06/25
	 */
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	/**
	 * セッション取得メゾット
	 * @author Suzuki Erika
	 * @since  2015/06/25
	 * @return session
	 */
	public Map<String, Object> getSession() {
		return session;
	}

	/**
	 * メールアドレス取得メゾット
	 * @author Suzuki Erika
	 * @since  2015/06/25
	 * @return email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * メールアドレス格納メゾット
	 * @author Suzuki Erika
	 * @since  2015/06/25
	 * @param email メールアドレス
	 */
	public void setUser(String email) {
		this.email = email;
	}

	/**
	 * パスワード取得メゾット
	 * @author Suzuki Erika
	 * @since  2015/06/25
	 * @return password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * パスワード格納メゾット
	 * @author Suzuki Erika
	 * @since  2015/06/25
	 * @param password パスワード
	 */
	public void setPassword(String password) {
		this.password = password;
	}
}
