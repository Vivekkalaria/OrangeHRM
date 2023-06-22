package basepackageOrangeHR;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.io.File;
import java.io.FileInputStream;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import utility.Timeutils;

public class BaseclassOrangeHR {

	
	public static Properties prop=new Properties();
	public static WebDriver driver;
	
	public BaseclassOrangeHR() {
		try {
	FileInputStream file=new FileInputStream("C:\\Users\\Tast\\eclipse-workspace\\OrangeHR\\src\\test\\java\\environmentvariables\\Config.properties");
	prop.load(file);
	
		}
		
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		catch(IOException a) {
			a.printStackTrace();
		}
		}
	
	@SuppressWarnings("deprecation")
	public static void initiation() {
	String browsername=	prop.getProperty("browser");
		if (browsername.equals("Firefox")){
			System.setProperty("webdriver.gecko.driver","geckodriver.exe");
			driver=new FirefoxDriver();
		}
			else if(browsername.equals("chrome")){
				System.setProperty("webdriver.chrome.driver","chromedriver.exe");
			driver=new ChromeDriver();
			}
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Timeutils.timepage ,TimeUnit.SECONDS);
		driver.get(prop.getProperty("Url"));
	}
	
	public static void screenshots(String Filename) {
	File file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	try {
	FileUtils.copyFile(file,new File("D:\\pre wed 2"+Filename+".jpg"));
	}
	catch(IOException e) {
	e.printStackTrace();	
	}}
	} 

