package com.gha.wa.excel.reader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import com.gha.wa.model.Withdrawal;
import com.gha.wa.model.data.WithdrawalService;

public class Reader {
	
	
	private int numberOfRows = 0;
	private int numberOfCells = 0;
	private int numberOfSheets = 0;
	private FileInputStream file;
	private Workbook workbook;
	private WithdrawalService withdrawalService;
	
	/**
	 * @throws IOException 
	 * 
	 */
	public Reader(){
		super();
		withdrawalService = new WithdrawalService();
	}
	
	public Map<String,List<Withdrawal>> getSheetMap(Workbook workbook){
		
		 Map<String,List<Withdrawal>> sheetMap = new HashMap<>();
		
		for(Sheet sheet : workbook) {
			
			System.out.println("Opening : "+sheet.getSheetName());
			
			sheetMap.put(sheet.getSheetName(), getWithdrawalList(sheet));
		}
		
		return sheetMap;
	}
	
	public List<Withdrawal> getWithdrawalList(Sheet sheet){
		
		List<Withdrawal> withdrawalList = new ArrayList<>();
		
		for(Row row : sheet) {
			
			System.out.println("Opening row : "+row.getRowNum()+" "+sheet.getSheetName());
			
			Withdrawal withdrawal = new Withdrawal();
			
			withdrawal.setDate(DateUtils.dateOf(row.getCell(0).getDateCellValue()));
			withdrawal.setAccountNumber(row.getCell(1).getRichStringCellValue().getString());
			withdrawal.setAccountName((row.getCell(2).getRichStringCellValue().getString()));
			withdrawal.setCurrency(row.getCell(3).getRichStringCellValue().getString());
			withdrawal.setAmount(row.getCell(4).getNumericCellValue());
			
			System.out.println("Row : "+row.getRowNum()+" read successfully");
			
			withdrawalList.add(withdrawal);
			System.out.println("Row : "+row.getRowNum()+" read and addd to withdrawalList");
			
		}
		
		return withdrawalList;
	}
	
	public void saveWorkBook(String pathName) {
		
		Workbook workbook = null;
		try {
			workbook = acquireWorkBook(pathName);
			
			System.out.println("Workbook object object acquired successfully");
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		for(Sheet sheet : workbook) {
			
			withdrawalService.initialize();
			
			try {
				withdrawalService.saveWorkSheet(getWithdrawalList(sheet));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			withdrawalService.cleanUp();
		}
	}
	
	public Workbook acquireWorkBook(String pathName)throws IOException{
		
       FileInputStream file = acquireFile(pathName);
		
		return new HSSFWorkbook(file);
		
	}
	
	public void acquireSheetMetrics(String pathName) throws IOException {
		
		Workbook workbook = acquireWorkBook(pathName);
		
		getSheetMetrics(workbook);
		
	}
	
	public void getSheetMetrics(Workbook workbook) throws IOException {
		
		int[] metrics = acquireMetricsOn(workbook);
		
		numberOfRows = metrics[1];
		numberOfCells = metrics[0];
		numberOfSheets = metrics[2];
		
		System.out.println("# of sheets : " + numberOfSheets);
		System.out.println("# of rows : " + numberOfRows);
		System.out.println("# of cells : " + numberOfCells);
		
	}

	public int[] acquireMetricsOn(Workbook workbook) throws IOException {
		
		int numberOfRows = 0;
		int numberOfCells = 0;
		int numberOfSheets = 0;
		
		for (Sheet sheet : workbook) {
			
			numberOfSheets++;
			
			for (Row row : sheet) {
				
				numberOfRows++;
				
				for (Cell cell : row) {
						
						numberOfCells++;
				}
			}
			
			System.out.println("No of Rows in :"+sheet+" : "+sheet.getPhysicalNumberOfRows());
		}
		return new int[] {numberOfCells,numberOfRows,numberOfSheets};
	}
	
	

	private Map<String, Sheet> populateSheetMap(Workbook workbook, Map<String, Sheet> sheetMap) {
		
		
		for(int i = 0; i < workbook.getNumberOfSheets() - 1 ; i++) {
			
			sheetMap.put(workbook.getSheetName(i), workbook.getSheetAt(i));
		}
		
		return sheetMap;
	}

	private void cleanUp(FileInputStream file, Workbook workbook) throws IOException {
		// clean up
		file.close();
		workbook.close();
	}

	private FileInputStream acquireFile(String pathName) throws FileNotFoundException {
		
		FileInputStream file = null;
		try {
			file = new FileInputStream(new File(pathName));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return file;
	}


}
