package in.co.cg.weekday;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import javax.xml.bind.ValidationException;

//This class return week for a particular date 
public class WeekDay {
	public static void main(String[] args) throws ParseException, ValidationException {
		Scanner get = new Scanner(System.in);
		System.out.println("Date: ");
		String inputDate = get.next();
		String strdays[] = new String[] { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday",
				"Saturday", };
		String arrDate[] = inputDate.split("/");

		int day, days, years, months, month, year;
		day = Integer.parseInt(arrDate[0]);
		month = Integer.parseInt(arrDate[1]);
		year = Integer.parseInt(arrDate[2]);
		Period p;
		if (day > 31 || day < 1 || month < 1 || month > 12 || year < 0) {
			throw new ValidationException("Inavlid Date");// throw ValidationException
		} else {
			LocalDate today, firsttoday;
			int d = 1;
			firsttoday = LocalDate.of(year, Month.of(1), 1);
			today = LocalDate.of(year, Month.of(month), day);
			p = Period.between(firsttoday, today);// finds period between two dates
		}
		int eday = 0;
		System.out.println("Day on 1st January: ");
		String jan1st = get.next();
		jan1st = jan1st.toLowerCase();
		for (int i = 0; i < strdays.length; i++) {
			if (jan1st.equals(strdays[i].toLowerCase())) {
				eday = i;
			}
		}
		System.out.println("Day on " + inputDate + " : "
				+ strdays[Math.abs(((int) (p.toTotalMonths() * 30.4362934 + p.getDays() - eday + 1)) % 7)]);
	}
}
