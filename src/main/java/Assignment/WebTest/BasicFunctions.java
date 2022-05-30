package Assignment.WebTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class BasicFunctions {
	
	public static int getColumnNo(String onBasis,String filePath) throws IOException
	{
		
		FileInputStream inputStream = new FileInputStream(new File(filePath));
		XSSFWorkbook wb=new XSSFWorkbook(inputStream);   
		XSSFSheet sheet=wb.getSheetAt(0);  
		
		Iterator<Row> itr = sheet.iterator();
		int i=0,columnno=0;
		while(itr.hasNext())
		{
			Row row=itr.next();
			Iterator<Cell> cellIterator = row.cellIterator();
			
			while (cellIterator.hasNext())   
			{
			
				Cell cell = cellIterator.next();
			
				if(cell.getStringCellValue().equalsIgnoreCase(onBasis))
					
				{
					columnno=i;
				}
				i++;
			}
			
		}
		
		return columnno;
	}
	
	public static String getPath(String element,String fieldMapPath) throws IOException
	{
		String onBasis="Field";
		String expectedVal="xpath";
		String FilePath=fieldMapPath;
		FileInputStream inputStream = new FileInputStream(new File(FilePath));
		XSSFWorkbook wb=new XSSFWorkbook(inputStream);   
		XSSFSheet sheet=wb.getSheetAt(0);  
		
		String xpathVal=null;
		Iterator<Row> itr = sheet.iterator(); 
		while (itr.hasNext())                 
		{  
		Row row=itr.next();
		Cell cell=row.getCell(BasicFunctions.getColumnNo(onBasis,FilePath)); //getting the cell representing the given column  
		String value=cell.getStringCellValue();
		if(element.equalsIgnoreCase(value))
		{
			Cell val=row.getCell(BasicFunctions.getColumnNo(expectedVal,FilePath));
			xpathVal=val.getStringCellValue();
		//System.out.println(val);
		break;
		}
		}
		return xpathVal;
	}


}
