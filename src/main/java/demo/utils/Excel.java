package demo.utils;

import demo.entity.Boy;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.Iterator;
import java.util.List;

public class Excel {

    public void writeData(String[] tittles, List<Boy> listBoy) throws Exception {

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Sheet1");

        int rowCount = 0;
        int colCount = 0;

        Row row = sheet.createRow(rowCount++);
        Cell cell = row.createCell(colCount++);
        for (String field : tittles) {

            cell.setCellValue(field);
            cell = row.createCell(colCount++);

        }

        for (int i = 0; i < listBoy.size(); i++) {
            Boy boy = listBoy.get(i);
            row = sheet.createRow(rowCount++);
            colCount = 0;
            cell = row.createCell(colCount++);
            cell.setCellValue(boy.getId());
            cell = row.createCell(colCount++);
            cell.setCellValue(boy.getName());
            cell = row.createCell(colCount++);
            cell.setCellValue(boy.getAge());
            cell = row.createCell(colCount++);
            cell.setCellValue(boy.getCity());
            cell = row.createCell(colCount++);
            cell.setCellValue(boy.getHeight());
            cell = row.createCell(colCount++);
            cell.setCellValue(boy.getWeight());
            cell = row.createCell(colCount++);
            cell.setCellValue(boy.getHobbit());
            cell = row.createCell(colCount++);
            cell.setCellValue(boy.getHairColor());
        }

        try (FileOutputStream outputStream = new FileOutputStream("boy_management.xlsx")) {
            workbook.write(outputStream);
        } catch (IOException e) {
            throw new Exception(e);
        }
    }


    public void readData(String pathname) throws IOException {

        File file = new File(pathname);
        FileInputStream input = null;
        try {
            input = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        XSSFWorkbook workbook = new XSSFWorkbook(input);
        XSSFSheet sheet = workbook.getSheetAt(0);
        Cell out = null;
        Iterator<Row> rowIterator = sheet.iterator();


        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();

            Iterator<Cell> cellIterator = row.cellIterator();

            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();

                CellType cellType = cell.getCellType();

                switch (cellType) {
                    case _NONE:
                        System.out.print("");
                        System.out.print("\t");
                        break;
                    case BOOLEAN:
                        System.out.print(cell.getBooleanCellValue());
                        System.out.print("\t");
                        break;
                    case BLANK:
                        System.out.print("");
                        System.out.print("\t");
                        break;
                    case FORMULA:

                        System.out.print(cell.getCellFormula());
                        System.out.print("\t");

                        FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();

                        System.out.print(evaluator.evaluate(cell).getNumberValue());
                        break;
                    case NUMERIC:
                        System.out.printf("%-10.0f", cell.getNumericCellValue());
                        System.out.print("\t");
                        break;
                    case STRING:
                        System.out.printf("%-18s", cell.getStringCellValue());
                        System.out.print("\t");
                        break;
                    case ERROR:
                        System.out.print("!");
                        System.out.print("\t");
                        break;
                }

            }
            System.out.println("");
        }
        workbook.close();

    }

    public String[] getTittles(String pathname) throws Exception {
            File file = new File(pathname);

        FileInputStream input = null;
        try {
            input = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            System.out.print("File "+pathname +"not found");
            e.printStackTrace();
        }
        XSSFWorkbook workbook = new XSSFWorkbook(input);
        XSSFSheet sheet = workbook.getSheetAt(0);
        Row headerRow = sheet.getRow(0);
        int lastCell = headerRow.getLastCellNum();
        String[] tittles = new String[lastCell - 1];
        for (int i = 0; i < lastCell - 1; i++) {
            Cell headerCell = headerRow.getCell(i);
            String header = headerCell.getStringCellValue();
            tittles[i] = header;
        }
        return tittles;
    }

}

