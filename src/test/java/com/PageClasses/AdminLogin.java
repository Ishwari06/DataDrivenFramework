package com.PageClasses;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminLogin {
	
	//defined repository for login
	
	@FindBy(id="btnreset")
	WebElement ObjReset;
	@FindBy(id="username")
	WebElement ObjUser;
	@FindBy(id="password")
	WebElement ObjPassword;
	@FindBy(id="btnsubmit")
	WebElement ObjLogin;
	
	//method for login
		
		public void verify_Login(String user, String pass) throws Throwable {
			Thread.sleep(1000);
			ObjReset.click();
			Thread.sleep(1000);
			ObjUser.sendKeys(user);
			Thread.sleep(1000);
			ObjPassword.sendKeys(pass);
			Thread.sleep(1000);
			ObjLogin.click();
		}

		}
			
		
