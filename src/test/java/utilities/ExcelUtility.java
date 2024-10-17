package utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	public FileInputStream fi;
	public FileOutputStream fo;
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;
	public CellStyle Style;
	String path;

	public ExcelUtility(String path) {
		this.path = path;
	}

	public int getRowCount( String xlsheet) throws IOException {
		fi = new FileInputStream(path);
		workbook = new XSSFWorkbook(fi);
		sheet = workbook.getSheet(xlsheet);
		int rowcount = sheet.getLastRowNum();
		workbook.close();
		fi.close();

		return rowcount;
	}

	public int getCellCount( String xlsheet, int rownum) throws IOException {
		fi = new FileInputStream(path);
		workbook = new XSSFWorkbook(fi);
		sheet = workbook.getSheet(xlsheet);
		row = sheet.getRow(rownum);
		int cellcount = row.getLastCellNum();
		workbook.close();
		fi.close();
		return cellcount;
	}

	public String geCellData( String xlsheet, int rownum, int colnum) throws IOException {
		fi = new FileInputStream(path);
		workbook = new XSSFWorkbook(fi);
		sheet = workbook.getSheet(xlsheet);
		row = sheet.getRow(rownum);
		cell = row.getCell(colnum);
		String data;
		try {
			// data=cell.ToString();
			DataFormatter formatter = new DataFormatter();
			return data = formatter.formatCellValue(cell);
		} catch (Exception e) {
			data = "";
			workbook.close();
			fi.close();
			return data;
		}
	}

	public void SetCellData( String xlsheet, int rownum, int colnum, String data) throws IOException {
		fi = new FileInputStream(path);
		workbook = new XSSFWorkbook(fi);
		sheet = workbook.getSheet(xlsheet);
		row = sheet.getRow(rownum);
		cell = row.createCell(colnum);
		cell.setCellValue(data);
		fo = new FileOutputStream(path);
		workbook.write(fo);
		workbook.close();
		fi.close();
		fo.close();

	}

	public void fillGreenColour(String xlsheet, int rownum, int colnum) throws IOException {
		fi = new FileInputStream(path);
		workbook = new XSSFWorkbook(fi);
		sheet = workbook.getSheet(xlsheet);
		row = sheet.getRow(rownum);
		cell = row.getCell(colnum);
		Style = workbook.createCellStyle();
		Style.setFillBackgroundColor(IndexedColors.GREEN.getIndex());

		Style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		cell.setCellStyle(Style);
		fo = new FileOutputStream(path);
		workbook.write(fo);
		workbook.close();
		fi.close();
		fo.close();

	}

	public void fillRedColour(String xlsheet, int rownum, int colnum) throws IOException {
		fi = new FileInputStream(path);
		workbook = new XSSFWorkbook(fi);
		sheet = workbook.getSheet(xlsheet);
		row = sheet.getRow(rownum);
		cell = row.getCell(colnum);
		Style = workbook.createCellStyle();
		Style.setFillBackgroundColor(IndexedColors.RED.getIndex());

		Style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		cell.setCellStyle(Style);
		fo = new FileOutputStream(path);
		workbook.write(fo);
		workbook.close();
		fi.close();
		fo.close();

	}
}
