package driverFactory;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.PageClasses.CustomerPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utilities.ExcelFileUtil;
import config.AppUtil;

public class Apptest extends AppUtil{
	String inputpath="./FileInput/Customer.xlsx";
	String outputpath="./FileOutput/DataDrivenResult.xlsx";
	String TCSheet="CustomerData";
	ExtentReports reports;
	ExtentTest logger;
	@Test
	public void startTest() throws Throwable
	{
		//drfine path of html
		reports=new ExtentReports("./target/ExtentReports/Customer.html");
		
		//create obj foe excelfile util class
		ExcelFileUtil xl= new ExcelFileUtil(inputpath);
		
		//count no. of rows in sheet
		int rc=xl.rowCount(TCSheet);
		Reporter.log("No. of rows are:"+rc,true);
		
		//iterate all rows
		for(int i=1;i<=rc;i++) {
		String cname=xl.getCellData(TCSheet, i, 0);
		String Address=xl.getCellData(TCSheet, i, 1);
		String City=xl.getCellData(TCSheet, i, 2);
		String country=xl.getCellData(TCSheet, i, 3);
		String cperson=xl.getCellData(TCSheet, i, 4);
		String pnumber=xl.getCellData(TCSheet, i, 5);
		String email=xl.getCellData(TCSheet, i, 6);
		String mnumber=xl.getCellData(TCSheet, i, 7);
		String notes=xl.getCellData(TCSheet, i, 8);
		CustomerPage cus=PageFactory.initElements(driver, CustomerPage.class);
		boolean res=cus.add_Customer(cname, Address,City,country,cperson,pnumber,email,mnumber,notes);
				logger.log(LogStatus.INFO,cname+"--- "+ Address+"-----"+City+"---"+country+"---"+cperson+"----"+pnumber+"----"+ email+"---"+notes+"---");
		
		
		
		if(res) {
	//if res is true write as pass into status cell
	xl.setCellData(TCSheet, i, 9, "pass", outputpath);
}
else
{
//if res is false write as fail into status cell
	xl.setCellData(TCSheet, i, 9, "fail",outputpath);
	
}
}

		
	}}
















