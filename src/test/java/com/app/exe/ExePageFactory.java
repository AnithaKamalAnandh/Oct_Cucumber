package com.app.exe;

import com.app.pageexe.LoginPageExePageFactory;

public class ExePageFactory extends LoginPageExePageFactory {

	public static void main(String[] args) {
		browserlaunch();
		url("https://adactinhotelapp.com/");
		username();
		password();
		
	}
}
