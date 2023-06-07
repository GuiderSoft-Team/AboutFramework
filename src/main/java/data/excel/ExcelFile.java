package data.excel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import utils.Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class ExcelFile {

    public static ExcelFile create(String fileName){
        return new ExcelFile(fileName);
    }

    public static ExcelFile create(String fileName, String sheetName){
        return new ExcelFile(fileName, sheetName);
    }

    public static ExcelFile read(String fileName){
        return new ExcelFile(fileName, true);
    }

    public static ExcelFile read(String fileName, String sheetName){
        return new ExcelFile(fileName, sheetName, true);
    }


    private String filePath;
    private String sheetName;
    private XSSFWorkbook workbook;
    private XSSFSheet sheet;
    private boolean isFileExist = false;
    File file;
    private FileInputStream inputStream;
    private FileOutputStream outputStream;


    private ExcelFile(String filePath, String sheetName){
        this.filePath = filePath;
        this.sheetName = sheetName;
        create();
    }

    private ExcelFile(String filePath){
        this(filePath, "Sheet1");
    }

    private ExcelFile(String filePath, String sheetName, boolean read){
        this.filePath = filePath;
        this.sheetName = sheetName;
        read();
    }
    private ExcelFile(String filePath, boolean read){
        this(filePath, "Sheet1", read);
    }

    public ExcelFile setSheetName(String sheetName){
        this.sheetName = sheetName;
        return this;
    }

    private void create(){
        Utils.createDirectory(filePath);
        workbook = new XSSFWorkbook();
        sheet = workbook.createSheet(sheetName);
    }

    public void read(){
        file = new File(filePath);
        try {
            inputStream = new FileInputStream(filePath);
            workbook = (XSSFWorkbook) WorkbookFactory.create(inputStream);
            sheet = workbook.getSheet(sheetName);
            isFileExist = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void close(){
        try {
            outputStream = new FileOutputStream(filePath);
            workbook.write(outputStream);
            workbook.close();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ExcelFile setHeader(List<String> headers){
        if (!isFileExist) {
            Row row = sheet.createRow(0);
            for (int i = 0; i < headers.size(); i++) {
                Cell cell = row.createCell(i);
                cell.setCellValue(headers.get(i));
            }
        }
        return this;
    }

    public ExcelFile setHeader(String...headers){
        if (!isFileExist) {
            Row row = sheet.createRow(0);
            for (int i = 0; i < headers.length; i++) {
                Cell cell = row.createCell(i);
                cell.setCellValue(headers[i]);
            }
        }
        return this;
    }

    public ExcelFile writeData(List<List<String>> rows){
        int rowNum = sheet.getPhysicalNumberOfRows();
        for (int i = 0; i < rows.size(); i++) {
            Row row = sheet.createRow(rowNum++);
            for (int j = 0; j < rows.get(i).size(); j++) {
                Cell cell = row.createCell(j);
                cell.setCellValue(rows.get(i).get(j));
            }
        }
        return this;
    }

    public ExcelFile writeData(String...args){
        if (!isFileExist) {
            int rowNum = sheet.getPhysicalNumberOfRows();
            Row row = sheet.createRow(rowNum++);
            for (int i = 0; i < args.length; i++) {
                Cell cell = row.createCell(i);
                cell.setCellValue(args[i]);
            }
        }
        return this;
    }

    public List<List<String>> getData() {
        List<List<String>> lists = new LinkedList<>();

        int rowCount = sheet.getPhysicalNumberOfRows();

        for(int i = 0; i < rowCount; i++) {
            List<String> rowList = new LinkedList<>();
            Row row = sheet.getRow(i);

            int cellCount = row.getPhysicalNumberOfCells();

            for(int j = 0; j < cellCount; j++) {
                rowList.add(row.getCell(j).toString());
            }
            lists.add(rowList);
        }
        return lists;
    }


    public List<String> getHeader() {
        List<String> list = new LinkedList<>();

        sheet = workbook.getSheet(sheetName);

        Row row = sheet.getRow(0);

        int cellCount = row.getPhysicalNumberOfCells();

        for(int i = 0; i < cellCount; i++) {
            list.add(row.getCell(i).toString());
        }
        return list;
    }

    public List<String> getRow(int rowNumber) {
        List<String> list = new LinkedList<>();

        sheet = workbook.getSheet(sheetName);

        Row row = sheet.getRow(rowNumber);

        int cellCount = row.getPhysicalNumberOfCells();

        for(int i = 0; i < cellCount; i++) {
            list.add(row.getCell(i).toString());
        }
        return list;
    }

    /**
     * Bu method exeldeki belirtilen sütun degerlerini list olarak return eder
     * @param colNum verisi istenilen column numarasi
     * @return list
     */
    public List<String> getColumn(int colNum) {
        List<String> list = new LinkedList<>();

        int rowCount = sheet.getPhysicalNumberOfRows();
        int colNumExcel = sheet.getRow(0).getPhysicalNumberOfCells();
        colNum = Math.min(colNum, colNumExcel)-1;
        for(int i = 0; i < rowCount; i++) {
            Row row = sheet.getRow(i);
            list.add(row.getCell(colNum).toString());
        }
        return list;
    }

    /**
     * Bu method exeldeki belirtilen sütun degerlerini list olarak return eder
     * @param colName verisi istenilen column adi
     * @return list
     */
    public List<String> getColumn(String colName, int startFromRow) {
        List<String> list = new LinkedList<>();
        int requiredColNum = 0;
        int rowCount = sheet.getPhysicalNumberOfRows();
        int colNumExcel = sheet.getRow(0).getPhysicalNumberOfCells();
        Row row0 = sheet.getRow(0);
        for (int i = 0; i < colNumExcel; i++) {
            if (row0.getCell(i).toString().toLowerCase().equals(colName.toLowerCase())){
                requiredColNum = i;
                break;
            }
        }
        for(int i = startFromRow; i < rowCount; i++) {
            Row row = sheet.getRow(i);
            list.add(row.getCell(requiredColNum).toString());
        }
        return list;
    }
}
