package com.app.pageexe;

import com.app.base.BaseClass;
import com.app.locators.BookingPageLocators;

public class BookingPageExe extends LoginPageExe {
	
	public static void location() {
		BaseClass.selectbyvalue(BaseClass.findElementid(BookingPageLocators.location), "Melbourne");
	}

}
