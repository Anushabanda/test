package Assignment.Tester;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import WebTest.WebPages.HomePage;
import WebTest.WebPages.CompanyDetails;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import javax.imageio.ImageIO;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class CompanyDetailsTester {

	public void handleCookies(WebDriver driver)
	{
		HomePage hp=new HomePage(driver);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		hp.getAcceptCookies().click();
	}

	public void selectCompanyInitials(WebDriver driver,String val)
	{

		//driver.manage().deleteAllCookies();
		HomePage hp=new HomePage(driver);
		for (int i=0;i<hp.getcompanyInitials().size();i++)
		{
			if(hp.getcompanyInitials().get(i).getText().equals(val))
			{
				hp.getcompanyInitials().get(i).click();
				break;
			}
		}

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void getAllCompanyData(WebDriver driver)
	{

		HomePage hp=new HomePage(driver);

		int noOfInitials=hp.getcompanyInitials().size();
		for (int i=0;i<noOfInitials;i++) {

			((JavascriptExecutor) driver)
					.executeScript("window.scrollTo(0, -document.body.scrollHeight)");

			selectCompanyInitials(driver,hp.getcompanyInitials().get(i).getText());
			getCompanyData(driver, 0);
			getCompanyData(driver, 2);
			getCompanyData(driver, hp.getcompanyNameList().size() - 1);
		}
	}

	public void getCompanyData(WebDriver driver,int val)
	{

		DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();

		DocumentBuilder documentBuilder = null;
		try {
			documentBuilder = documentFactory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}

		Document document = null;

		document=documentBuilder.newDocument();



		HomePage hp=new HomePage(driver);

		CompanyDetails pdetails=new CompanyDetails(driver);


		hp.getcompanyNameList().get(val).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		List<WebElement> labels =pdetails.getContactLabel();
		List<WebElement> contactInfo=pdetails.getContactDetails();
		String companyName=pdetails.getCompanyName().getText();
		/*String telephoneNumber=pdetails.getTelephone().getText();
		String stockAvailibility="";
		if(pdetails.getStockAvailibilityPhone().isDisplayed())
			stockAvailibility=pdetails.getStockAvailibilityPhone().getText();
		String www=pdetails.getWwwMail().getText();
		String medicalInfoMail=pdetails.getMedicalInfoMail().getText();
		String drugSafetyMail=pdetails.getDrugSafetyMail().getText();
*/
		//String imgPath=saveLogoImage(companyName,pdetails.getCompanyLogo());

		//createXML(companyName,telephoneNumber,stockAvailibility,www,medicalInfoMail,drugSafetyMail,imgPath);


		// root element
		Element root = document.createElement("company");
		document.appendChild(root);


		Element companyNameInfo = document.createElement("CompanyName");
		companyNameInfo.appendChild(document.createTextNode(companyName));
		root.appendChild(companyNameInfo);

		for(int i=0;i<labels.size();i++) {
			// CompanyName element
			Element labelName = document.createElement("Label");
			labelName.appendChild(document.createTextNode(labels.get(i).getText()));
			root.appendChild(labelName);

			Element contactInfoDetails = document.createElement("ContactInfo");
			contactInfoDetails.appendChild(document.createTextNode(contactInfo.get(i).getText()));
			root.appendChild(contactInfoDetails);

		}

		String imgPath=saveLogoImage(companyName,pdetails.getCompanyLogo());
		Element logo = document.createElement("Logo");
		logo.appendChild(document.createTextNode(imgPath));
		root.appendChild(logo);

		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = null;
		try {
			transformer = transformerFactory.newTransformer();
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		}
		DOMSource domSource = new DOMSource(document);
		StreamResult streamResult = new StreamResult(new File(System.getProperty("user.dir")+"\\CompanyData\\"+companyName+".xml"));

		try {
			transformer.transform(domSource, streamResult);
		} catch (TransformerException e) {
			e.printStackTrace();
		}

		System.out.println("Done creating XML File");




		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.navigate().back();
	}

	public String saveLogoImage(String companyName,WebElement image)
	{
		String logoSRC = image.getAttribute("src");
		String filePath=System.getProperty("user.dir")+"\\logo\\"+companyName+".png";
		URL imageURL = null;
		try {
			imageURL = new URL(logoSRC);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		BufferedImage saveImage = null;
		try {
			saveImage = ImageIO.read(imageURL);
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			ImageIO.write(saveImage, "png", new File(filePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
return filePath;

	}

	public void createXML(String companyName,String telephoneNo,String stockAvailibilityNo,String www,String medicalInfoMail,String drugSafetyMail,String logoPath)
	{
		DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();

		DocumentBuilder documentBuilder = null;
		try {
			documentBuilder = documentFactory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}

		Document document = null;
		try {
			document = documentBuilder.parse(System.getProperty("user.dir")+"\\CompanyData\\Camurus AB.xml");
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		//Document document = documentBuilder.newDocument();

		// root element
		Element root = document.createElement("company");
		document.appendChild(root);

		// CompanyName element
		Element CompanyName = document.createElement("CompanyName");
		CompanyName.appendChild(document.createTextNode(companyName));
		root.appendChild(CompanyName);


		// Telephone element
		Element telephone = document.createElement("Telephone");
		telephone.appendChild(document.createTextNode(telephoneNo));
		root.appendChild(telephone);


		// Stock Availibility element
		Element stockAvailibilityNumber = document.createElement("StockAvailibilityNumber");
		stockAvailibilityNumber.appendChild(document.createTextNode(stockAvailibilityNo));
		root.appendChild(stockAvailibilityNumber);

		// www element
		Element wwwMail = document.createElement("WWW");
		wwwMail.appendChild(document.createTextNode(www));
		root.appendChild(wwwMail);

		// medicalInfo element
		Element medicalInfo = document.createElement("MedicalInfoMail");
		medicalInfo.appendChild(document.createTextNode(medicalInfoMail));
		root.appendChild(medicalInfo);

		// drugSafety element
		Element drugSafety = document.createElement("DrugSafetyMail");
		drugSafety.appendChild(document.createTextNode(drugSafetyMail));
		root.appendChild(drugSafety);

		// logoPath element
		Element logo = document.createElement("Logo");
		logo.appendChild(document.createTextNode(logoPath));
		root.appendChild(logo);

		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = null;
		try {
			transformer = transformerFactory.newTransformer();
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		}
		DOMSource domSource = new DOMSource(document);
		StreamResult streamResult = new StreamResult(new File(System.getProperty("user.dir")+"\\CompanyData\\"+companyName+".xml"));

		try {
			transformer.transform(domSource, streamResult);
		} catch (TransformerException e) {
			e.printStackTrace();
		}

		System.out.println("Done creating XML File");


	}


}
