package demo2.x.com;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import demo2.x.com.util.Demo2Tool;

public class Demo2Action extends ActionSupport {
	private String gotoUrl;

	public String main() {
		HttpServletRequest request = ServletActionContext.getRequest();

		Cookie[] cookies = request.getCookies();
		if (null != cookies) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("ssocookie")) {
					String result = Demo2Tool.doGet("http://check.x.com:8080/sso/checkCookie.action", cookie.getName(),
							cookie.getValue());
					if ("1".equals(result)) {
						return SUCCESS;
					}
				}
			}
		}

		gotoUrl = "http://demo2.x.com:8080/demo2/main.action";
		return "login";
	}

	public String getGotoUrl() {
		return gotoUrl;
	}

	public void setGotoUrl(String gotoUrl) {
		this.gotoUrl = gotoUrl;
	}
}
