package chapter12;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoField;

public class LocalDateMain {
  public static void main(String[] args) {
    LocalDate date = LocalDate.of(2017, 3, 20);
	//LocalDate date = LocalDate.now();
	int year = date.getYear();
	Month month = date.getMonth();
	int day = date.getDayOfMonth();
	DayOfWeek dow = date.getDayOfWeek();
	int len = date.lengthOfMonth();
	boolean leap = date.isLeapYear();
	
	
	year = date.get(ChronoField.YEAR);
	System.out.println(year);
	int _month = date.get(ChronoField.MONTH_OF_YEAR);
	System.out.println(_month);
	day = date.get(ChronoField.DAY_OF_MONTH);
	System.out.println(day);
	
	
	
  }
}
