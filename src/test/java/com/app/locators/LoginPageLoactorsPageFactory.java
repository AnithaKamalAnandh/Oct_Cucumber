package com.app.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.app.base.BaseClass;

public class LoginPageLoactorsPageFactory extends BaseClass {
	
	public LoginPageLoactorsPageFactory() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="username")
	private WebElement username;

	public WebElement getUsername() {
		return username;
	}
	
	@FindBy(id= "password")
	private WebElement password;

	public WebElement getPassword() {
		return password;
	}
	

}
