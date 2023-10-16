
package testrunner;

import common.Score;
import excel.ExcelPrinter;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ExcelPrinterTest {

    private ExcelPrinter excelPrinter;
    private Scanner scanner;

    private final String filename = "test.xlsx";

    @BeforeEach
    public void setUp() throws IOException {
        File file = new File(filename);
        if (file.exists()) {
            file.delete();

        }
    }

    @Test
    public void testGetFileName() throws IOException {
        String input = filename + "\ny\n";

        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        Scanner scanner = new Scanner(in);
        ExcelPrinter excelPrinter = new ExcelPrinter(scanner);

        String fileName = excelPrinter.getFileName();

        assertNotNull(fileName);
        assertEquals(filename, fileName);
    }

    @Test
    public void testWriteResults() throws IOException {
        String input = filename + "\ny\n";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        Scanner scanner = new Scanner(in);
        ExcelPrinter excelPrinter = new ExcelPrinter(scanner);

        String name1 = "John Smith";
        String name2 = "Janet Jones";
        String event1 = "Donkey Hurling";
        String event2 = "Monkey Tickling";

        List<Score> scores = new ArrayList<>();
        scores.add(new Score(name1,  event1, 100));
        scores.add(new Score(name1,  event2, 200));

        scores.add(new Score(name2, event1, 300));
        scores.add(new Score(name2, event2, 400));


        excelPrinter.writeResults(scores);

        XSSFWorkbook workbook = excelPrinter.getWorkbook();
		String testname = name1;
		int testbasescore = 0;
		for (int i = 0; i < 2; i++) {
			if(i == 1){
				testname = name2;
				testbasescore = 200;
			}

			XSSFSheet sheet = workbook.getSheet(testname);

			Row row = sheet.getRow(0);
			Cell cell = row.getCell(0);
			assertEquals("Discipline", cell.getStringCellValue());

			row = sheet.getRow(1);
			cell = row.getCell(0);
			assertEquals(event1, cell.getStringCellValue());
			cell = row.getCell(1);
			assertEquals(testbasescore + 100, cell.getNumericCellValue());

			row = sheet.getRow(2);
			cell = row.getCell(0);
			assertEquals(event2, cell.getStringCellValue());
			cell = row.getCell(1);
			assertEquals(testbasescore + 200, cell.getNumericCellValue());
		}
    }
}