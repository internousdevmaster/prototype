package jp.co.internous.prototype.action;

import jp.co.internous.prototype.dao.CreateUserDAO;

import com.opensymphony.xwork2.ActionSupport;

/**
 * ユーザーの新規登録情報を格納するDAOを実行するクラス
 * @author 鈴木　浩太
 * @since 2015/6/25
 * @see jp.co.internous.dao.CreateUserDAO
 */
public class CreateUserAction extends ActionSupport{

	/**
	 * 登録するメールアドレス
	 */
	private String email;

	/**
	 * 登録するユーザーの名前
	 */
	private String user;

	/**
	 * 登録するユーザーパスワード
	 */
	private String password;

	/**
	 * 実行メソッド
	 * return result 結果
	 */
	public String execute() {
		String result = ERROR;
		CreateUserDAO dao = new CreateUserDAO();
		if(dao.createUser(email, password, user) > 0) result = SUCCESS;
		return result;
	}

	/**メールアドレスを取得するためのメソッド
	 *@return email メールアドレス
	 */
	public String getEmail() {
		return email;
	}

	/**メールアドレスを格納するためのメソッド
	 *@param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**名前を取得するためのメソッド
	 *@return user 名前
	 */
	public String getUser() {
		return user;
	}

	/**名前を格納するためのメソッド
	 *@param user 名前
	 */
	public void setUser(String user) {
		this.user = user;
	}

	/**パスワードを取得するためのメソッド
	 *@return password ユーザーパスワード
	 */
	public String getPassword() {
		return password;
	}

	/**パスワードを格納するためのメソッド
	 *@param upassword ユーザーパスワード
	 */
	public void setPassword(String password) {
		this.password = password;
	}
}
