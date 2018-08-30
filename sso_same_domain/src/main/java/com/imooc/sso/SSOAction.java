package com.imooc.sso;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.imooc.util.SSOCheck;
import com.opensymphony.xwork2.ActionSupport;

public class SSOAction extends ActionSupport {

	private String username;
	private String password;

	private String gotoUrl;

	public String doLogin() {
		gotoUrl = "/demo1/main.action";
		// 同域下的sso
		boolean ok = SSOCheck.checkLogin(username, password);
		if (ok) {
			Cookie cookie = new Cookie("ssocookie", "sso");
			cookie.setPath("/");// 设置到顶层
			HttpServletResponse response = ServletActionContext.getResponse();
			response.addCookie(cookie);
			return SUCCESS;
		}
		return "login";
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getGotoUrl() {
		return gotoUrl;
	}

	public void setGotoUrl(String gotoUrl) {
		this.gotoUrl = gotoUrl;
	}

}
