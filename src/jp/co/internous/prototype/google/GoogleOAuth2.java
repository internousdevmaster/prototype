package jp.co.internous.prototype.google;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.Token;
import org.scribe.model.Verb;
import org.scribe.model.Verifier;
import org.scribe.oauth.OAuthService;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opensymphony.xwork2.ActionSupport;

public class GoogleOAuth2 extends ActionSupport implements ServletRequestAware,SessionAware {

	private static final long serialVersionUID=2529743866018522001L;
	private static final String PROTECTED_RESOURCE_URL = "https://www.googleapis.com/oauth2/v1/userinfo";
	private static final Token EMPTY_TOKEN = null;
	private HttpServletRequest request;
	private Map<String, Object> sessionMap;

	public String execute() throws Exception {

		AccessToken();

		return SUCCESS;
	}

	public void AccessToken() throws IOException {

		String verifier1 = request.getParameter("code");
		System.out.println(verifier1);

		Verifier verifier =new Verifier(verifier1);
		Token accessToken = new Token("ACCESS_TOKEN", "REFRESH_TOKEN");

		HttpSession session = request.getSession();
		OAuthService service = (OAuthService) session.getAttribute("SERVICE");

		// Trade the Request Token and Verfier for the Access Token

		accessToken = service.getAccessToken(EMPTY_TOKEN, verifier);


		// Now let's go and ask for a protected resource!

		OAuthRequest request = new OAuthRequest(Verb.GET, PROTECTED_RESOURCE_URL);
		service.signRequest(accessToken, request);
		Response response = request.send();

		System.out.println(response.getCode());
		System.out.println(response.getBody());


		// JSON形式で送られてきたデータをmapに入れる
				Map<String,String> map = new LinkedHashMap<>();
				ObjectMapper mapper = new ObjectMapper();
				try {
					map = mapper.readValue(response.getBody(), new TypeReference<LinkedHashMap<String,String>>(){});
					System.out.println(map);
					System.out.println(map.get("id"));
					System.out.println(map.get("name"));
					sessionMap.put("familyname", map.get("name"));
				} catch (Exception e) {
					e.printStackTrace();
				}

		System.out.println();
		System.out.println("Thats it man! Go and build something awesome with Scribe! :)");

	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;

	}

	@Override
	public void setSession(Map<String, Object> sessionMap) {
		this.sessionMap=sessionMap;

	}

}