

package Assignment.WebTest;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import Assignment.Tester.CompanyDetailsTester;

public class CompanyInfoMain extends Base {

	protected CompanyInfoMain(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public static void main(String args[]) throws InterruptedException, IOException {

		WebDriver driver = setCapabilities();
		driver.get("https://www.medicines.org.uk/emc/browse-companies");
		Thread.sleep(1000);

		System.out.println(System.getProperty("user.dir"));

		CompanyDetailsTester cd=new CompanyDetailsTester();

		cd.handleCookies(driver);
		cd.getAllCompanyData(driver);
		driver.quit();
	}

}
