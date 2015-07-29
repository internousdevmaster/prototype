package jp.co.internous.prototype.facebook;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionSupport;

import facebook4j.Facebook;
import facebook4j.FacebookFactory;
import facebook4j.auth.AccessToken;
/**
 * SignInServlet
 * ログイン画面からFacebook認証画面へと遷移する為のアクションクラス
 * @author
 * @since
 * @version 1.0
 */
public class SignInServlet extends ActionSupport implements ServletResponseAware,ServletRequestAware  {
	/**
	 * シリアルバージョンUID
	 */
	private static final long serialVersionUID = -7453606094644144082L;
	/**
	 * リクエスト
	 */
	private HttpServletRequest request;
	/**
	 * レスポンス
	 */
	private HttpServletResponse response;
	/**
	 * ユーザー情報取得用トークン取得メソッド
	 * @author
	 * @since
	 * @return SUCCESS
	 */
    public String execute() throws Exception {
    	doGet(request, response);
		return SUCCESS;
	}
    /**
     * Facebook認証画面へ遷移する為のメソッド
     * @author
	 * @since
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Facebook facebook = new FacebookFactory().getInstance();
        request.getSession().setAttribute("facebook", facebook);
        facebook.setOAuthAppId("920480471341970", "693f8b6c8d892d76aea13cf333df2776");
        String accessTokenString = "920480471341970|e1a88bbddf5bc4a89cc2a74421adac36";
        AccessToken at = new AccessToken(accessTokenString);
        facebook.setOAuthAccessToken(at);
        StringBuffer callbackURL = request.getRequestURL();
        int index = callbackURL.lastIndexOf("/");
        callbackURL.replace(index, callbackURL.length(), "").append("/CallbackServlet");
        response.sendRedirect(facebook.getOAuthAuthorizationURL(callbackURL.toString()));
    }
	/**
	 * リクエスト格納メソッド
	 * @author
	 * @since
	 * @param request
	 */
	public void setServletRequest(HttpServletRequest request) {
				this.request=request;
	}
	/**
	 * レスポンス格納メソッド
	 * @author
	 * @since
	 * @param response
	 */
	public void setServletResponse(HttpServletResponse response) {
		this.response=response;
	}
}

