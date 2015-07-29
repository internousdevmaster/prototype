package jp.co.internous.prototype.twitter;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.User;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;
/**
 * TwitterAccessToken
 * Twitterのアクセストークンを取得する為のクラス
 * @author Funakoshi Akira
 * @since 2015/06/10
 * @version 1.0
 */
public class TwitterAccessToken {
	/**
	 * ユーザー情報取得用トークン取得メソッド
	 * @author Funakoshi Akira
	 * @since 2015/06/10
	 * @return result 結果
	 * @throws TwitterException
	 * @throws IOException
	 */
	public String[] loginOAuth(HttpServletResponse response,
			HttpServletRequest request) throws TwitterException, IOException {
		HttpSession session = request.getSession();
		Twitter twitter = (Twitter) session.getAttribute("Twitter");
		String verifier = request.getParameter("oauth_verifier");
		if(verifier == null){
			 response.sendRedirect(request.getContextPath()+ "/GoLoginAction");
			 }
		AccessToken accessToken = null;
		String userData[] = new String[2];
		try {
			if (session.getAttribute("RequestToken") != null) {
				accessToken = twitter.getOAuthAccessToken(
						(RequestToken) session.getAttribute("RequestToken"),
						verifier);
			} else {
				userData[0] = "ゲスト";
				userData[1] = "ゲスト";
				return userData;
			}
		} catch (Exception e) {
		}
		if (accessToken != null) {
			session.setAttribute("AccessToken", accessToken.getToken());
			session.setAttribute("AccessTokenSecret",
					accessToken.getTokenSecret());
		}
		User user = twitter.verifyCredentials();
		userData[0] = user.getName();
		userData[1] = user.getScreenName();
		return userData;
	}
}