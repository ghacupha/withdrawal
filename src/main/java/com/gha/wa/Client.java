package com.gha.wa;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Sheet;

import com.gha.wa.excel.reader.Reader;
import com.gha.wa.model.MonthlyWithdrawal;
import com.gha.wa.model.MonthlyWithdrawalManager;
import com.gha.wa.model.Withdrawal;
import com.gha.wa.model.data.WithdrawalService;

public class Client {
	
	private final String pathName = 
			"C:\\ExcelFilesForAnalysis\\All_Debits.xls";
	private Reader reader;
	private WithdrawalService withdrawalService;
	private MonthlyWithdrawalManager manager;
	
	/**
	 * @param reader
	 * @throws IOException 
	 */
	public Client() throws IOException {
		super();
		reader = new Reader();	
		withdrawalService = new WithdrawalService();
		manager = new MonthlyWithdrawalManager(LocalDate.of(2016, 8,1), LocalDate.of(2017,9,1));
		
	}

	public static void main(String[] args) throws IOException {

		Client client = new Client();
		
		client.getReader().acquireSheetMetrics(client.getPathName());
		
		//client.getReader().saveWorksheet(client.getPathName());
		
		/*Map<String,List<Withdrawal>> sheetMap = 
				client.getReader().getSheetMap(client.getReader().acquireWorkBook(client.getPathName()));*/
		/*int noOfSheets = client.getReader().getNoOfSheets(client.getPathName());
		
		for(int i = 0; i < noOfSheets ; i++ ) {
			
			client.getReader()
		}
		*/
		
		client.getReader().saveWorkBook(client.getPathName());
		
		//client.getManager().getMonthlyWithdrawals();
		
		for(MonthlyWithdrawal monthlyWithdrawal : client.getManager().getMonthlyWithdrawals()){
			
			System.out.println("Month name : "+monthlyWithdrawal.getMonth());
			System.out.println("Month Withdrawals : "+monthlyWithdrawal.getTotalWithdrawal());
		}
		
	
	}

	/**
	 * @return the reader
	 */
	public Reader getReader() {
		return reader;
	}

	/**
	 * @param reader the reader to set
	 */
	public void setReader(Reader reader) {
		this.reader = reader;
	}

	/**
	 * @return the pathName
	 */
	public String getPathName() {
		return pathName;
	}

	/**
	 * @return the manager
	 */
	public MonthlyWithdrawalManager getManager() {
		return manager;
	}
	
	

}
