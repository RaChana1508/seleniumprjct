package selenium.tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ReadTestDataExcel {

	public static Object[][] testDataExcel(String sheetname)
	{
		File file=new File("C:\\Users\\Training_b6b.00.03\\eclipse-workspace\\seleniumwebdriveprjct\\src\\test\\resources\\datadriven.xlsx");
		// File file=new File("src\\test\\resources\\datadriven.xlsx");
		Object[][] Obj = null;
		try {
			InputStream is = new FileInputStream(file);
			XSSFWorkbook workbook = new XSSFWorkbook(is);
			XSSFSheet sheet1= workbook.getSheet(sheetname);
			Obj=new Object[sheet1.getLastRowNum()][];
			for(int i=1;i<=sheet1.getLastRowNum();i++)
			{
				Obj[i-1]=new Object[sheet1.getRow(i).getPhysicalNumberOfCells()];
				for(int j=0;j<sheet1.getRow(i).getPhysicalNumberOfCells();j++)
				{
					Obj[i-1][j]=sheet1.getRow(i).getCell(j).getStringCellValue();
					//System.out.print(sheet1.getRow(i).getCell(j).getStringCellValue());
				}
				//writing to excel sheet
				//sheet1.getRow(i).createCell(2).setCellValue("valid user");
				//System.out.println("");
			}
			is.close();
			//creating to write
			/*
			 * OutputStream os = new FileOutputStream(file); workbook.write(os); os.close();
			 */
			workbook.close();
		} 
		catch (FileNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Obj;
	}
}
