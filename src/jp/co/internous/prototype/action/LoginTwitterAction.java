package jp.co.internous.prototype.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.internous.prototype.twitter.TwitterAccessToken;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
/**
 * LoginTwitterAction
 * Twitter認証画面からマイページ画面へ遷移する為のアクションクラス
 * @author Funakoshi Akira
 * @since 2015/06/10
 * @version 1.0
 */
public class LoginTwitterAction extends ActionSupport implements ServletResponseAware,ServletRequestAware,SessionAware{

	/**
	* セッション
	*/
	public Map<String, Object> sessionMap;
	/**
	* レスポンス
	*/
	private HttpServletResponse response;
	/**
	* リクエスト
	*/
	private HttpServletRequest request;
	/**
	* ユーザー情報
	*/
	private String[] userData=new String[2];
	/**
	* 苗字
	*/
	public String familyname = null;
	/**
	* 名前
	*/
	public String givenname = null;

	/**
	 * 実行メソッド
	 * @author Funakoshi Akira
	 * @since 2015/06/10
	 * @return SUCCESS
	 * @throws Exception
	 * @see TwitterAccessToken
	 */
	public String execute() throws Exception{
		TwitterAccessToken twitter = new TwitterAccessToken();
		try {
		userData = twitter.loginOAuth(response, request);
		} catch (Exception e) {
			return ERROR;
		}
		familyname = userData[0];
		givenname = "Twitter";

		sessionMap.put("familyname", userData[0]);

		return SUCCESS;
	}

	/**
	 * レスポンス格納メソッド
	 * @author Funakoshi Akira
	 * @since 2015/06/10
	 * @param response
	 */
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}
	/**
	 * リクエスト格納メソッド
	 * @author Funakoshi Akira
	 * @since 2015/06/10
	 * @param request
	 */
	public void setServletRequest(HttpServletRequest request) {
		this.request=request;
	}
	/**
	 * セッション格納メソッド
	 * @author Funakoshi Akira
	 * @since 2015/06/10
	 * @param sessionMap
	 */
	public void setSession(Map<String, Object> sessionMap) {
		this.sessionMap=sessionMap;
	}
}
