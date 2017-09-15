package com.gha.wa.excel.reader;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateUtils {
	
	public static LocalDate dateOf(String string) {
		
		DateTimeFormatter formatter = 
				DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		return LocalDate.parse(string, formatter);
	}
	
	public static LocalDate dateOf(Date date) {
		
		Instant instant = Instant.ofEpochMilli(date.getTime()); 
		LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault()); 
		LocalDate localDate = localDateTime.toLocalDate();
		
		return localDate;
	}

}
