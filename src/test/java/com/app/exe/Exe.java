package com.app.exe;

import com.app.pageexe.BookingPageExe;


public class Exe extends BookingPageExe {
	
	public static void main(String[] args) {
		
		browserlaunch();
		url("https://adactinhotelapp.com/");
		username();
		password();
		loginbutton();
		location();
		
	}

}
