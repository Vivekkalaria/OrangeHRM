package OrangeHRMtest;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import basepackageOrangeHR.BaseclassOrangeHR;
import pomorange.Pomloginpage;
import testdata.Excelsheet;

public class Logintest extends BaseclassOrangeHR {

	Pomloginpage vk;
	
	public Logintest() {
		super();//If we want to call constructor of parent class, we need to write Super key word
	
	}
	
	@BeforeMethod
	public void initsetup() {
		initiation(); //method we create in Base class
		screenshots("login");
		
		vk=new Pomloginpage();
		
	}
	
	@Test(priority=2)
	public void Title() {
	String actual=vk.verify();
	System.out.println(actual);
	Assert.assertEquals(actual,"OrangeHRM");
	}
	
	@DataProvider
	public Object[][] Details(){
		Object result[][]=Excelsheet.readdata("Sheet1");
		return result;
	}
	
	@Test(priority=1, dataProvider="Details")
	public void Login(String name, String password) {
		vk.typeusername(prop.getProperty(name));
		vk.typepassword(prop.getProperty(password));
	}
	
	@AfterMethod
	public void close() {
	driver.close();
	}
	
	
	
}
