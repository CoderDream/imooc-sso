package demo1.x.com;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import demo1.x.com.util.Demo1Tool;

//先校验cookie的有效性  在校验登录
public class Demo1Action extends ActionSupport {

	private String gotoUrl;

	public String main() {
		HttpServletRequest request = ServletActionContext.getRequest();

		Cookie[] cookies = request.getCookies();
		if (null != cookies) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("ssocookie")) {
					String result = Demo1Tool.doGet("http://check.x.com:8080/sso/checkCookie.action", cookie.getName(),
							cookie.getValue());
					if ("1".equals(result)) {
						return SUCCESS;
					}
				}
			}
		}

		gotoUrl = "http://demo1.x.com:8080/demo1/main.action";
		return "login";
	}

	public String getGotoUrl() {
		return gotoUrl;
	}

	public void setGotoUrl(String gotoUrl) {
		this.gotoUrl = gotoUrl;
	}
}
