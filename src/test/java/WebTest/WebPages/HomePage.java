package WebTest.WebPages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Assignment.WebTest.Base;

public class HomePage extends Base{

	public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	String fieldMapPath=System.getProperty("user.dir")+"\\src\\test\\java\\Assignment\\FieldMaps\\HomePage.xlsx";
	
	List<WebElement> companyInitials;
	List<WebElement> companyNameList;
	WebElement acceptCookies;

	public WebElement getAcceptCookies() {
		acceptCookies=getEle("acceptCookies",fieldMapPath);
		return acceptCookies;

	}

	public void setAcceptCookies(WebElement acceptCookies) {
		this.acceptCookies = acceptCookies;
	}

	public List<WebElement> getcompanyNameList() {
		companyNameList=getElements("companyNameList",fieldMapPath);
		return companyNameList;
	}
	public void setcompanyNameList(List<WebElement> companyNameList) {
		this.companyNameList = companyNameList;
	}


	public List<WebElement> getcompanyInitials() {
		companyInitials=getElements("companyInitials",fieldMapPath);
		return companyInitials;
	}

	public void setcompanyInitials(List<WebElement> companyInitials) {
		this.companyInitials = companyInitials;
	}

	


	
	

}
