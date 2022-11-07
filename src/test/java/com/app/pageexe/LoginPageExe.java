package com.app.pageexe;

import com.app.base.BaseClass;
import com.app.locators.LoginPageLocators;

public class LoginPageExe extends LoginPageLocators {
	
	/*public static void username() {
		BaseClass.sendkeys(BaseClass.findElementid(LoginPageLocators.username), "Kalarani");
	}*/
	
	public static void password() {
		BaseClass.sendkeys(BaseClass.findElementid(LoginPageLocators.password), "kalakala@1211");
	}
	
	public static void loginbutton() {
		BaseClass.clickdata(BaseClass.findElementid(LoginPageLocators.loginbutton));
	}
	
	// Abstarct method
	public static void username() {
		BaseClass.sendkeys(BaseClass.findElementBy(LoginPageLocators.username), "Kalarani");
	}

}
