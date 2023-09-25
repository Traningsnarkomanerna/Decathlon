package testrunner;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import excel.ExcelReader;

public class ExcelReaderTest {
    //Test assumes c:\Eclipse\ exists and also that the file resultat_test.xlsx exists in that folder
    //also that the file contains the data from the testAdd() test in ExcelPrinterTest.java
    @Test
    public void testGetCellInfo() throws IOException {
        ExcelReader excelReader = new ExcelReader();
        String cellInfo = excelReader.getCellInfo("test", 0, 0, 0);
        Assertions.assertEquals("Bob", cellInfo);
    }

    @Test
    public void testGetCellInfoWithInvalidSheetNumber() throws IOException {
        ExcelReader excelReader = new ExcelReader();
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            excelReader.getCellInfo("test", 1, 0, 0);
        });
    }

    @Test
    public void testGetCellInfoWithInvalidRowNumber() throws IOException {
        ExcelReader excelReader = new ExcelReader();
        Assertions.assertThrows(NullPointerException.class, () -> {
            excelReader.getCellInfo("test", 0, 10, 0);
        });
    }

    @Test
    public void testGetCellInfoWithInvalidColNumber() throws IOException {
        ExcelReader excelReader = new ExcelReader();
        Assertions.assertThrows(NullPointerException.class, () -> {
            excelReader.getCellInfo("test", 0, 0, 10);
        });
    }
}
