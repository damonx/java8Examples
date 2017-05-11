package chapter12;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateFormatter {
   public static void main(String[] args) {
	  LocalDate date = LocalDate.of(2017, 5, 18);
	  System.out.println(date.format(DateTimeFormatter.BASIC_ISO_DATE));
	  System.out.println(date.format(DateTimeFormatter.ISO_LOCAL_DATE));
   }
}
