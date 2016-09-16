package com.internousdev.prototype.action;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import twitter4j.TwitterException;

import com.internousdev.prototype.twitter.TwitterRequestToken;
import com.opensymphony.xwork2.ActionSupport;
/**
 * TwitterLoginAction
 * ログイン画面からTwitter認証画面へ遷移する為のアクションクラス
 * @author Funakoshi Akira
 * @since 2015/06/10
 * @version 1.0
 */
public class TwitterLoginAction extends ActionSupport implements ServletResponseAware,ServletRequestAware{
	/**
	* 結果
	*/
	private String result="success";
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
	* 実行メソッド
	* @author Funakoshi Akira
	* @since 2015/06/10
	* @return result
	*/
	public String execute(){
		TwitterRequestToken a = new TwitterRequestToken();
		try {
			result=a.loginOAuth(response,request);
		} catch (TwitterException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
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
}
