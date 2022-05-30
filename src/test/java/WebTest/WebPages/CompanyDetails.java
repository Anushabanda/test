package WebTest.WebPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Assignment.WebTest.Base;

import java.util.List;

public class CompanyDetails extends Base{
	
	String fieldMapPath=System.getProperty("user.dir")+"\\src\\test\\java\\Assignment\\FieldMaps\\CompanyDetails.xlsx";
	
	WebElement companyName;
	WebElement telephone;
	WebElement stockAvailibilityPhone;
	WebElement wwwMail;
	WebElement medicalInfoMail;
	WebElement drugSafetyMail;
	WebElement companyLogo;

	List<WebElement> contactLabel;
	List<WebElement> contactDetails;


	public CompanyDetails(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public List<WebElement> getContactDetails() {
		contactDetails=getElements("contactDetails",fieldMapPath);
		return contactDetails;
	}

	public void setContactDetails(List<WebElement> contactDetails) {
		this.contactDetails = contactDetails;
	}

	public List<WebElement> getContactLabel() {
		contactLabel=getElements("contactLabel",fieldMapPath);
		return contactLabel;
	}

	public void setContactLabel(List<WebElement> contactLabel) {
		this.contactLabel = contactLabel;
	}

	public WebElement getCompanyLogo() {
		companyLogo=getEle("companyLogo",fieldMapPath);
		return companyLogo;
	}



	public void setCompanyLogo(WebElement companyLogo) {
		this.companyLogo = companyLogo;
	}

	public WebElement getDrugSafetyMail() {
		drugSafetyMail=getEle("drugSafetyMail",fieldMapPath);
		return drugSafetyMail;
	}



	public void setDrugSafetyMail(WebElement drugSafetyMail) {
		this.drugSafetyMail = drugSafetyMail;
	}

	public WebElement getMedicalInfoMail() {
		medicalInfoMail=getEle("medicalInfoMail",fieldMapPath);
		return medicalInfoMail;
	}



	public void setMedicalInfoMail(WebElement medicalInfoMail) {
		this.medicalInfoMail = medicalInfoMail;
	}


	public WebElement getCompanyName() {
		companyName=getEle("companyName",fieldMapPath);
		return companyName;
	}



	public void setCompanyName(WebElement companyName) {
		this.companyName = companyName;
	}



	public WebElement getTelephone() {
		telephone=getEle("telephone",fieldMapPath);
		return telephone;
	}



	public void setTelephone(WebElement telephone) {
		this.telephone = telephone;
	}



	public WebElement getStockAvailibilityPhone() {
		stockAvailibilityPhone=getEle("stockAvailibilityPhone",fieldMapPath);
		return stockAvailibilityPhone;
	}



	public void setStockAvailibilityPhone(WebElement stockAvailibilityPhone) {
		this.stockAvailibilityPhone = stockAvailibilityPhone;
	}



	public WebElement getWwwMail() {
		wwwMail=getEle("wwwMail",fieldMapPath);
		return wwwMail;
	}



	public void setWwwMail(WebElement wwwMail) {
		this.wwwMail = wwwMail;
	}

}
