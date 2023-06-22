package pomorange;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basepackageOrangeHR.BaseclassOrangeHR;

public class Pomloginpage extends BaseclassOrangeHR{

	//First step is to locate all the element we have in the login page
	@FindBy(className="oxd-input oxd-input--active")
	//@FindBy is a replacement of driver.findelement.(By.
	WebElement Username;
	
	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input")
	WebElement Password;
	
	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")
	WebElement Loginbutton;
	
	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[4]/p")
	WebElement Forgotpassword;
	
	@FindBy(xpath="/html/body/div/div[1]/div/div[1]/div/div[2]/div[3]/div[2]/p[2]/a")
	WebElement OrangeHRMinc;
	
	
	//Initiate page element
	public Pomloginpage() {
		
	PageFactory.initElements(driver, this);	
	//we can use or initialize all the element located by findby with this command
	
	}
	
	public void typeusername(String name) {
		Username.sendKeys(name);
	}
	
	public void typepassword(String vicky  ) {
		Password.sendKeys(vicky);
	}
	
	public void loginbutton() {
		Loginbutton.click();
	}
	
	public void Forgotpass() {
		Forgotpassword.click();
	}
	
	public void OrangeHRMinc() {
		OrangeHRMinc.click();
	}
	
	public String verify() {
	return driver.getTitle();
	}
}
