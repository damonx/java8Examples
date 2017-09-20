package chapter12;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

public class LocalTimeParser {
  public static void main(String[] args) {
	  LocalDate date = LocalDate.parse("2014-03-19");
	  
	  //LocalDate is immutable
	  System.out.println("before date: " + date.toString());
	  LocalDate date1 = date.plusWeeks(1);
	  LocalDate date2 = date.minusYears(2);
	  LocalDate date3 = date.plus(6, ChronoUnit.MONTHS);
	  
	  System.out.println("after date: " + date.toString());
	  System.out.println("date1: " + date1.toString());
	  System.out.println("date2: " + date2.toString());
	  System.out.println("date3: " + date3.toString());
	  
	  date = LocalDate.now();
	  
	  for (int i = 1; i<10; i++){
		  LocalDate tempDate = date.plusDays(i);
		  LocalDate nextWorkingDay = tempDate.with(temporal -> { DayOfWeek dow =
				  DayOfWeek.of(temporal.get(ChronoField.DAY_OF_WEEK)); int dayToAdd = 1;
				  if (dow == DayOfWeek.FRIDAY) dayToAdd = 3;
				  else if (dow == DayOfWeek.SATURDAY) dayToAdd = 2; return temporal.plus(dayToAdd, ChronoUnit.DAYS);
				  });
		  System.out.println("Next working day: " + nextWorkingDay.toString() + "-" + nextWorkingDay.getDayOfWeek().toString());
	  }
	  
      // Using TemporalAdjuster
	  TemporalAdjuster nextWorkingDay = TemporalAdjusters.ofDateAdjuster(temporal ->{
		  DayOfWeek dow = DayOfWeek.of(temporal.get(ChronoField.DAY_OF_WEEK));
		  int dayToAdd = 1;
		  if (dow == DayOfWeek.FRIDAY) dayToAdd = 3;
		  if (dow == DayOfWeek.SATURDAY) dayToAdd = 2; return temporal.plus(dayToAdd, ChronoUnit.DAYS);
	  });
	  
	  System.out.println("TemporalAdjuster Next working day: " + date.with(nextWorkingDay).toString() + "-" + date.with(nextWorkingDay).getDayOfWeek().toString());
  }
}
