package com.imooc.demo2;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.imooc.util.SSOCheck;
import com.opensymphony.xwork2.ActionSupport;

public class Demo2Action extends ActionSupport {
	private String gotoUrl;

	public String main() {
		HttpServletRequest request = ServletActionContext.getRequest();
		boolean ok = SSOCheck.checkCookie(request);
		if (ok) {
			return SUCCESS;
		}
		gotoUrl = "/demo2/main.action";
		return "login";
	}

	public String getGotoUrl() {
		return gotoUrl;
	}

	public void setGotoUrl(String gotoUrl) {
		this.gotoUrl = gotoUrl;
	}
}
