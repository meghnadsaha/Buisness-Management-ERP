package com.jcb.erp.utils;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import org.apache.poi.ss.usermodel.ConditionalFormattingRule;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.FontFormatting;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.PatternFormatting;
import org.apache.poi.ss.usermodel.SheetConditionalFormatting;
import org.apache.poi.ss.util.CellRangeAddress;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;

public class ExcelUtilits {


	private static final Logger LOGGER = LoggerFactory.getLogger(ExcelUtilits.class);
	
	String[] headerArray = { "HEADER 1", "HEADER 2", "HEADER 3" };
	List<String> headers = Arrays.asList(headerArray);

	public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";

	LinkedHashMap<Integer, List<String>> soucresOfCellValuesHm = new LinkedHashMap<Integer, List<String>>();
	//soucresOfCellValuesHm.put(counter, Arrays.asList(msisdn, circle, state, lenderName, date, timeStamp,eligible));

	String sheetName = "Transactions";

	
	
	byte[] in = createExcel(soucresOfCellValuesHm, TYPE, headers, sheetName, "A1", "H1", "H");

	/**
	 * Excel Reader function
	 */
	public void readExcelData(String xlsx_file_path) throws IOException, InvalidFormatException {

		Set<String> uniqueMsisdnSet = new HashSet<String>();
		try {
			// Creating a Workbook from an Excel file (.xls or .xlsx)
			Workbook workbook = WorkbookFactory.create(new File(xlsx_file_path));

			/*
			 * =================================================================
			 * Iterating over all the rows and columns in a Sheet (Multiple
			 * ways)
			 * =================================================================
			 */

			// Getting the Sheet at index zero
			Sheet sheet = workbook.getSheetAt(0);

			// 1. You can obtain a rowIterator and columnIterator and iterate
			// over them
			Iterator<Row> rowIterator = sheet.rowIterator();
			while (rowIterator.hasNext()) {

				Row row = rowIterator.next();
				if (row.getRowNum() == 0) {
					continue; // just skip the rows if row number is 0
				}
				// once get a row its time to iterate over the columns of the
				// current row
				Iterator<Cell> cellIterator = row.cellIterator();

				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					String cellValue = printCellValue(cell); // cellValue here
					uniqueMsisdnSet.add(cellValue);
					try {
						// msisdnStoringService.saveMsisdnFromExcel(msisdn);
					} catch (Exception e) {
						LOGGER.error("Exception occured while calling readExcelData() for cellValue {} due to {} ",
								cellValue, e);
					}

				}
				// System.out.println();
			}

			// Closing the workbook
			workbook.close();
		} catch (IOException e) {
			LOGGER.error("fail to export data from Excel file: {}", e.getMessage());
			throw new RuntimeException("fail to export data from Excel file:  " + e.getMessage());
		}
		// return uniqueMsisdnSet;

	}

	/**
	 * Excel Writer function
	 */
	public static byte[] createExcel(LinkedHashMap<Integer, List<String>> soucresOfCellValuesHm, String TYPE,
			List<String> headers, String SHEET, String fromColumnIndexOfHeader, String toColumnIndexOfHeader,
			String toColumnIndexOfBody) {

		try (XSSFWorkbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream();) {
			Sheet sheet = workbook.createSheet(SHEET);

			/***
			 * Header Writer
			 */
			Row headerRow = sheet.createRow(0);
			for (int colIndex = 0; colIndex < headers.size(); colIndex++) {
				Cell cell = headerRow.createCell(colIndex);
				cell.setCellValue(headers.get(colIndex));
				/**
				 * Un-comment when animation required
				 */
				// cell.setCellStyle(
				// setCustomHeaderStyle(workbook, sheet,
				// fromColumnIndexOfHeader, toColumnIndexOfHeader));// "A1",
				// "G1"
			}

			/***
			 * Body Writer
			 * 
			 * Create row object
			 */
			Row row;
			/***
			 * Iterate over data and write to sheet
			 */
			Set<Integer> keyid = soucresOfCellValuesHm.keySet();
			int rowid = 1;

			for (Integer key : keyid) {
				row = sheet.createRow(rowid++);
				List<String> objectArr = soucresOfCellValuesHm.get(key);
				int cellid = 0;

				for (Object obj : objectArr) {
					Cell cell = row.createCell(cellid++);
					cell.setCellValue((String) obj);
					/**
					 * Un-comment when animation required
					 */
					// setCustomBodyStyle(sheet, toColumnIndexOfBody +
					// soucresOfCellValuesHm.size());// G
					// cell.setCellStyle(setCustomCellStyle(workbook));
				}
			}

			workbook.write(out);
			out.close();
			// return new ByteArrayInputStream(out.toByteArray());
			return out.toByteArray();

		} catch (IOException e) {
			LOGGER.error("fail to import data to Excel file: {}", e.getMessage());
			throw new RuntimeException("fail to import data to Excel file: " + e.getMessage());
		}
	}

	private String printCellValue(Cell cell) {
		String cellValue = "";
		switch (cell.getCellTypeEnum()) {
		case BOOLEAN:
			cellValue = String.valueOf(cell.getBooleanCellValue());
			return cellValue;
		case STRING:
			cellValue = String.valueOf(cell.getRichStringCellValue().getString());
			return cellValue;
		case NUMERIC:
			if (DateUtil.isCellDateFormatted(cell)) {
				cellValue = String.valueOf(cell.getDateCellValue());
				return cellValue;
			} else {
				// NumberToTextConverter able to convert upto 12 digit only
				cellValue = NumberToTextConverter.toText(cell.getNumericCellValue());
				return cellValue;
			}
		case FORMULA:
			cellValue = String.valueOf(cell.getCellFormula());
			return cellValue;
		case BLANK:
			// LOGGER.info(cellValue);
		default:
			// LOGGER.info("");
		}
		return cellValue;
	}

	public static CellStyle setCustomHeaderStyle(XSSFWorkbook workbook, Sheet sheet, String fromColumnName,
			String toColumnName) {

		SheetConditionalFormatting sheetCF1 = sheet.getSheetConditionalFormatting();
		ConditionalFormattingRule rule = sheetCF1.createConditionalFormattingRule("MOD(ROW() - 1, 1) = 0");
		PatternFormatting fill = rule.createPatternFormatting();
		fill.setFillBackgroundColor(IndexedColors.GOLD.index);
		fill.setFillPattern(PatternFormatting.SOLID_FOREGROUND);
		FontFormatting ffRed = rule.createFontFormatting();
		ffRed.setFontColorIndex(IndexedColors.WHITE.index);
		CellRangeAddress[] regions = { CellRangeAddress.valueOf("" + fromColumnName + ":" + toColumnName + "") };// i.e.
		// "A1:G1"
		sheetCF1.addConditionalFormatting(regions, rule);
		Font font = workbook.createFont();
		font.setFontHeightInPoints((short) 12);
		font.setBold(true);
		// font.setColor(IndexedColors.BLUE.getIndex());
		CellStyle cellStyle = workbook.createCellStyle();
		cellStyle.setFont(font);

		return cellStyle;
	}

	private static void setCustomBodyStyle(Sheet sheet, String toColumnIndexOfBody) {

		SheetConditionalFormatting sheetCF = sheet.getSheetConditionalFormatting();
		ConditionalFormattingRule rule1 = sheetCF.createConditionalFormattingRule("MOD(ROW(),2)");
		PatternFormatting fill1 = rule1.createPatternFormatting();
		fill1.setFillBackgroundColor(IndexedColors.LEMON_CHIFFON.index);
		fill1.setFillPattern(PatternFormatting.SOLID_FOREGROUND);
		/*
		 * Starting from second column
		 **/
		CellRangeAddress[] regions1 = { CellRangeAddress.valueOf("A2:" + toColumnIndexOfBody) };
		sheetCF.addConditionalFormatting(regions1, rule1);
	}

	public static CellStyle setCustomCellStyle(XSSFWorkbook workbook) {
		CellStyle style = workbook.createCellStyle();
		style.setBorderBottom(BorderStyle.THIN);
		style.setBottomBorderColor(IndexedColors.GOLD.getIndex());
		style.setBorderLeft(BorderStyle.THIN);
		style.setLeftBorderColor(IndexedColors.GOLD.getIndex());
		style.setBorderRight(BorderStyle.THIN);
		style.setRightBorderColor(IndexedColors.GOLD.getIndex());
		style.setBorderTop(BorderStyle.THIN);
		style.setTopBorderColor(IndexedColors.GOLD.getIndex());

		return style;
	}

	public static Cell createAndInitializeCell(Row row, String cellValue, XSSFWorkbook workbook, int cellIndex) {
		Cell cell = row.createCell(cellIndex);
		cell.setCellValue(cellValue);
		cell.setCellStyle(setCustomCellStyle(workbook));
		return cell;
	}

}
