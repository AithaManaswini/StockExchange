package com.example.demo.helper;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.StockPrice;
@CrossOrigin(origins="http://localhost:4200")
public class ExcelHelper {
	  public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
	
	  static String[] HEADERs = {"Companycode","Stockexchange","currentprice","date","time" };
	  static String SHEET = "StockPrice";

	  public static boolean hasExcelFormat(MultipartFile file) {

	    if (!TYPE.equals(file.getContentType())) {
	      return false;
	    }

	    return true;
	  }

	  public static List<StockPrice> excelTosps(InputStream is) {
	    try {
	      Workbook workbook = new XSSFWorkbook(is);

	      Sheet sheet = workbook.getSheet(SHEET);
	      Iterator<Row> rows = sheet.iterator();

	      List<StockPrice> sp = new ArrayList<StockPrice>();

	      int rowNumber = 0;
	      while (rows.hasNext()) {
	        Row currentRow = rows.next();

	        // skip header
	        if (rowNumber == 0) {
	          rowNumber++;
	          continue;
	        }

	        Iterator<Cell> cellsInRow = currentRow.iterator();

	        StockPrice sp1 = new StockPrice();

	        int cellIdx = 0;
	        while (cellsInRow.hasNext()) {
	          Cell currentCell = cellsInRow.next();

	          switch (cellIdx) {
	          case 0:
	        	  sp1.setCompanycode(currentCell.getStringCellValue());
	            break;

	          case 1:
	            sp1.setStockexchange(currentCell.getStringCellValue());
	            break;

	          case 2:
	            sp1.setCprice(currentCell.getNumericCellValue());
	            break;

	          case 3:
	        	  sp1.setDate(currentCell.getStringCellValue());
	            break;
	          case 4:
	        	  sp1.setTime(currentCell.getStringCellValue());
	            break;

	          default:
	            break;
	          }

	          cellIdx++;
	        }

	        sp.add(sp1);
	      }

	      workbook.close();

	      return sp;
	    } catch (IOException e) {
	      throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
	    }
	  }
	}