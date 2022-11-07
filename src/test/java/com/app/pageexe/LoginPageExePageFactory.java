package com.app.pageexe;

import com.app.base.BaseClass;
import com.app.locators.LoginPageLoactorsPageFactory;

public class LoginPageExePageFactory extends LoginPageLoactorsPageFactory {
	
	public static void username() {
		//LoginPageLoactorsPageFactory f = new LoginPageLoactorsPageFactory();
		BaseClass.sendkeys(new LoginPageLoactorsPageFactory().getUsername(), BaseClass.excelreuseRead(0,0));
	}
	
	
	public static void password() {
		//LoginPageLoactorsPageFactory f = new LoginPageLoactorsPageFactory();
		BaseClass.sendkeys(new LoginPageLoactorsPageFactory().getPassword(), BaseClass.excelreuseRead(1, 0));
	}

}
