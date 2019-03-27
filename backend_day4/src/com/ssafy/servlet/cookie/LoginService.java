package com.ssafy.servlet.cookie;

public class LoginService {
	private static LoginService loginService = new LoginService();
	private LoginService () {};
	public static LoginService getService() {
		return loginService;
	}
	public boolean canLogin(String id,String pass) {
		if(id.equals("hong") && pass.equals("1234")) {
			return true;
		}
		else return false;
	}
}
