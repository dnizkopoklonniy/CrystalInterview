package data;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.util.HashMap;

/**
 * Utils for excel.
 */
public class ExcelUtils {

    /**
     * Excel sheet.
     */
    private static XSSFSheet excelSheet;

    /**
     * Excel book.
     */
    private static XSSFWorkbook excelBook;

    /**
     * Prepares excel utils.
     * @param path Path to excel file.
     * @param sheetName Sheet name.
     */
    public static void prepare(String path, String sheetName) throws Exception {
        FileInputStream ExcelFile = new FileInputStream(path);

        excelBook = new XSSFWorkbook(ExcelFile);
        excelSheet = excelBook.getSheet(sheetName);
    }

    /**
     * Gets cell data.
     * @param rowNum Row number.
     * @param colNum Column number.
     * @return Cell data.
     */
    public static String getCellData(int rowNum, int colNum) throws Exception {
        XSSFCell cell = excelSheet.getRow(rowNum).getCell(colNum);
        String cellData = cell.getStringCellValue();

        return cellData;
    }

    /**
     * Gets hash map data for row number.
     * @param rowNum Row number.
     * @return Hash map data.
     */
    public static HashMap<String, String> getData(int rowNum) throws Exception{
        int countCells = excelSheet.getRow(0).getLastCellNum();

        HashMap<String, String> data = new HashMap<String, String>();

        for (int i=0; i<countCells; i++) {
            String columnName = getCellData(0, i);
            String cellData = getCellData(rowNum, i);

            data.put(columnName, cellData);
        }

        return data;
    }
}
