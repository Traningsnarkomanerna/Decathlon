package testrunner;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import excel.ExcelPrinter;
import java.io.File;
import java.io.FileInputStream;
import org.junit.Assert;


public class ExcelPrinterTest {
	//Assumes c:\Eclipse\ exists!

	private ExcelPrinter printer;

	@Before
	public void setUp() throws IOException {
		printer = new ExcelPrinter("test");

	}

	@Test
	public void testAdd() {
		Object[][] data = { { "Bob", "Fish", 30 }, { "Jane", "Austin", 25 } };
		printer.add(data, "Sheet1");

		XSSFWorkbook workbook = printer.getWorkbook();
		XSSFSheet sheet = workbook.getSheet("Sheet1");

		Row row1 = sheet.getRow(0);
		Cell cell1 = row1.getCell(0);
		assertEquals("Bob", cell1.getStringCellValue());

		Row row2 = sheet.getRow(1);
		Cell cell2 = row2.getCell(2);
		assertEquals(25, (int) cell2.getNumericCellValue());
	}

	@Test
	public void testWrite() throws IOException {

		ExcelPrinter printer = new ExcelPrinter("test");
		Object[][] data = { { "Bob", "Fish", 30 }, { "Jane", "Austin", 25 } };
		printer.add(data, "Sheet1");
		printer.write();
		// assertions to check that the file was created and contains the expected data
		File file = new File("resultat_test.xlsx");
		Assert.assertTrue(file.exists());

		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("Sheet1");

		Row row1 = sheet.getRow(0);
		Cell cell1 = row1.getCell(0);
		Assert.assertEquals("John", cell1.getStringCellValue());

		Row row2 = sheet.getRow(1);
		Cell cell2 = row2.getCell(2);
		Assert.assertEquals(25, (int) cell2.getNumericCellValue());

		workbook.close();
		fis.close();
		file.delete();
	}
	

	@After
	public void tearDown() throws IOException {
		printer.getWorkbook().close();
	}
}