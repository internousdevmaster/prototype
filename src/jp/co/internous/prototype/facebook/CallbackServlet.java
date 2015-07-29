package jp.co.internous.prototype.facebook;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.json.simple.JSONValue;

import com.opensymphony.xwork2.ActionSupport;
/**
 * CallbackServlet
 * ログイン画面からFacebook認証画面へと遷移する為のアクションクラス
 * @author Funakoshi Akira
 * @since 2015/06/10
 * @version 1.0
 */
public class CallbackServlet extends ActionSupport implements SessionAware,
		ServletResponseAware, ServletRequestAware {
	/**
	 * シリアルバージョンUID
	 */
	private static final long serialVersionUID = 6305643034487441839L;
	/**
	 * ネットワークネーム
	 */
	static final String NETWORK_NAME = "Facebook";
	/**
	 * レスポンス
	 */
	private HttpServletRequest request;
	/**
	 * リクエスト
	 */
	private HttpServletResponse response;

	private String name;

	private String id;

	private String email;
	/**
	 * セッション
	 */
	public Map<String, Object> sessionMap;

    /**
	 * 実行メソッド
	 * @author Funakoshi Akira
	 * @since 2015/06/10
	 * @return result
	 */
	public String execute() throws Exception {
		doGet(request, response);
		return SUCCESS;
	}
	/**
	 * ユーザー情報取得用トークン取得メソッド
	 * @author
	 * @since
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, Exception {
		final String callbackURL = request.getRequestURL().toString();
		final String code = request.getParameter("code");
		if(code == null){
			 response.sendRedirect(request.getContextPath()+ "/Login.jsp");
			 }
		final String appId = "920480471341970";
		final String appSecret = "693f8b6c8d892d76aea13cf333df2776";
		final String accessTokenURL = "https://graph.facebook.com/oauth/access_token?client_id="
				+ appId
				+ "&redirect_uri="
				+ URLEncoder.encode(callbackURL, "UTF-8")
				+ "&client_secret="
				+ appSecret + "&code=" + URLEncoder.encode(code, "UTF-8");
		final String accessTokenResult = httpRequest(new URL(accessTokenURL));
		String accessToken = null;
		String[] pairs = accessTokenResult.split("&");
		for (String pair : pairs) {
			String[] kv = pair.split("=");
			if (kv.length != 2) {
				throw new RuntimeException("Unexpected auth response");
			} else {
				if (kv[0].equals("access_token")) {
					accessToken = kv[1];
				}
			}
		}
		final String apiURL = "https://graph.facebook.com/me?access_token="
				+ URLEncoder.encode(accessToken, "UTF-8");
		final String apiResult = httpRequest(new URL(apiURL));
		Map<?, ?> me = (Map<?, ?>) JSONValue.parse(apiResult);
		Map<?, ?> map = new HashMap<Object, Object>();
		name = String.valueOf(me.get("name"));
		id = String.valueOf(me.get("id"));
		email = String.valueOf(me.get("email"));


		sessionMap.put("familyname", name);
		sessionMap.put("id",id);
		sessionMap.put("email", email);
		sessionMap.put("accessToken", accessToken);
		request.getSession().setAttribute("loginUser", map);
		response.sendRedirect(request.getContextPath() + "/MyPage.jsp");
	}
	String httpRequest(URL url) throws IOException {
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setDoOutput(true);
		conn.setUseCaches(false);
		conn.setRequestMethod("GET");
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				conn.getInputStream()));
		String line = null;
		String response = "";
		while ((line = reader.readLine()) != null) {
			response += line;
		}
		reader.close();
		conn.disconnect();
		return response;
	}
	/**
	 * リクエスト格納メソッド
	 * @author
	 * @since
	 * @param request
	 */
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
	/**
	 * レスポンス格納メソッド
	 * @author
	 * @since
	 * @param request
	 */
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}
	/**
	 * セッション取得メソッド
	 * @author
	 * @since
	 * @param request
	 */
	public Map<String, Object> getSessionMap() {
		return sessionMap;
	}
	/**
	 * セッション格納メソッド
	 * @author
	 * @since
	 * @param sessionMap
	 */
	public void setSessionMap(Map<String, Object> sessionMap) {
		this.sessionMap = sessionMap;
	}
	/**
	 * セッション格納メソッド
	 * @author
	 * @since
	 * @param sessionMap
	 */
	public void setSession(Map<String, Object> sessionMap) {
		this.sessionMap = sessionMap;
	}
}