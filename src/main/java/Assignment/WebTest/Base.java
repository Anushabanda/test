package Assignment.WebTest;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class Base {

	protected static WebDriver driver = null;
	public static String fieldMapPath;
	
	protected Base(WebDriver driver)
	{
		Base.driver=driver;
	}
	
	public static void setFieldMapPath(String path)
	{
		fieldMapPath=path;
	}
	//Gets Xpath from the FieldMap Excels and returns the Webelement object
	public static WebElement getEle(String ele,String fieldMapPath)
	{
		
		try {
			return driver.findElement(By.xpath(BasicFunctions.getPath(ele,fieldMapPath)));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static List<WebElement> getElements(String ele,String fieldMapPath)
	{
		
		try {
			return driver.findElements(By.xpath(BasicFunctions.getPath(ele,fieldMapPath)));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static WebDriver setCapabilities() {

		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\ChromeDriver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		return driver;
	}
}
