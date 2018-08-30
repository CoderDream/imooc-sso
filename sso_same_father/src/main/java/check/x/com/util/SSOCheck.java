package check.x.com.util;

public class SSOCheck {

	public static final String USERNAME = "user";
	public static final String PASSWORD = "123";

	public static boolean checkLogin(String username, String password) {
		if (null != username && null != password && username.equals(USERNAME) && password.equals(PASSWORD)) {
			return true;
		}
		return false;
	}

	public static boolean checkCookie(String cookieName, String cookieValue) {
		if (null != cookieName && null != cookieValue && cookieName.equals("ssocookie") && cookieValue.equals("sso")) {
			return true;
		}
		return false;
	}
}