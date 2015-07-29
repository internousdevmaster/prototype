package jp.co.internous.prototype.google;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.scribe.builder.ServiceBuilder;
import org.scribe.model.Token;
import org.scribe.oauth.OAuthService;

import com.opensymphony.xwork2.ActionSupport;

public class GoogleOAuth extends ActionSupport implements ServletResponseAware,ServletRequestAware{

		private static final long serialVersionUID = -36583185920205674L;
		private static final String NETWORK_NAME = "Google";
	    private static final String SCOPE = "https://www.googleapis.com/auth/userinfo.profile";
	    private static final Token EMPTY_TOKEN = null;
		private HttpServletResponse response;
		private HttpServletRequest request;

	public String execute() throws Exception {

		RequestToken();

		return SUCCESS;
	}

	public void RequestToken() throws IOException{


        // TODO: Put your own API key, secret, and callback URL here.
        String apiKey = "743522052869-1opcaimtcshc3rn09pnvifkeu29l7m6g.apps.googleusercontent.com";
        String apiSecret = "rcDrCvmbpJzwxVPx1TN26TQY";
        String callbackUrl = "http://www.internousdev.com:8080/prototype/GoogleOAuth2";

        OAuthService service = new ServiceBuilder()
        						.provider(Google2Api.class)
        						.apiKey(apiKey)
        						.apiSecret(apiSecret)
        						.callback(callbackUrl)
        						.scope(SCOPE)
        						.build();

        System.out.println("=== " + NETWORK_NAME + "'s OAuth Workflow ===");
        System.out.println();



        // TODO: Put your own token information here, if you don't want to start over the whole process.
        Token accessToken = new Token("ACCESS_TOKEN", "REFRESH_TOKEN");

            // Obtain the Authorization URL
            System.out.println("Fetching the Authorization URL...");
            String authorizationUrl = service.getAuthorizationUrl(EMPTY_TOKEN);
            System.out.println("Got the Authorization URL!");
            System.out.println("Now go and authorize Scribe here:");
            System.out.println(authorizationUrl);
            System.out.println("And paste the authorization code here");


            HttpSession session = request.getSession();
            session.setAttribute("SERVICE", service);



            System.out.println();
            response.sendRedirect(authorizationUrl);

	}

	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response=response;

	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request=request;

	}



}