/**
 * 
 */
package org.migue.java8tuto.tests;

import java.time.Clock;
import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.Locale;

/**
 * @author migue
 * 
 * Class for testing the new API Date in Java8
 * Note that it's not a Unit Testing at all...
 */
@SuppressWarnings("unused")
public class DateApiTest {

	
	
	private static void testingTheClock() {
		Clock clock = Clock.systemDefaultZone();
		long millis = clock.millis();
		System.out.println("clock.millis() = " + millis);

		Instant instant = clock.instant();
		Date legacyDate = Date.from(instant);
		System.out.println("Date.from(clock.instant()) = " + legacyDate);
	}
	
	
	private static void testingTimeZones() {
		System.out.println("All available time zones in the World: " + ZoneId.getAvailableZoneIds());
		ZoneId myZone = ZoneId.of("Europe/Madrid");
		
		ZoneId londonZone = ZoneId.of("Europe/London");
		
		ZoneId moscowZone = ZoneId.of("Europe/Moscow");
		
		System.out.println("Time rules of my zone: " + myZone.getRules());
		System.out.println("Time rules of London: " +  londonZone.getRules());
		System.out.println("Time rules of Moscow: " + moscowZone.getRules());

	}
	
	private static void testingLocalDate() {
		LocalDate today = LocalDate.now();
		LocalDate tomorrow = today.plus(1, ChronoUnit.DAYS);
		LocalDate yesterday = tomorrow.minusDays(2);
		System.out.println("Today is: " + today.getDayOfWeek());
		System.out.println("Tomorrow is: " + tomorrow.getDayOfWeek());
		System.out.println("Yesterday was: " + yesterday.getDayOfWeek());
		
		LocalDate myBirthday = LocalDate.of(2014, Month.MAY, 20);
		DayOfWeek dayOfWeek = myBirthday.getDayOfWeek();
		System.out.println("My birthday this year is: " + dayOfWeek);
		
		/* with this code we can view all locales and choose ours...*/
//		Collection<String> localeCollection = new ArrayList<String>( Arrays.asList(Locale.getISOCountries()));
//		localeCollection.stream().forEach(System.out::println);
		
//		Locale myLocale =  Locale.forLanguageTag("ES");
//		System.out.println("My locale: " + myLocale);
//		DateTimeFormatter spanishFormatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM).withLocale(myLocale);
//		System.out.println("Spanish formatter: " + spanishFormatter);

		LocalTime lunchTime = LocalTime.parse("14:00");
		LocalTime siestaTime =   lunchTime.plusHours(1);
		System.out.println("Lunch time: " + lunchTime); 
		System.out.println("Siesta time: " + siestaTime);
		
	}
	
	private static void testingLocalDateTime() {
		
		LocalDateTime almostThere = LocalDateTime.of(2014, Month.DECEMBER, 31, 23, 59, 59);
		DayOfWeek almostThereDayOfTheWeek = almostThere.getDayOfWeek();
		System.out.println("Final day: " + almostThereDayOfTheWeek);
		
		Month almostThereMont = almostThere.getMonth();
		System.out.println("Month of the final day: " + almostThereMont);
		
		long minuteOfAlmostThereDay = almostThere.getLong(ChronoField.MINUTE_OF_DAY);
		System.out.println("Minute of the day in the final minute of the day: " + minuteOfAlmostThereDay);
		
		Instant instant = almostThere
		        .atZone(ZoneId.systemDefault())
		        .toInstant();		
		Date legacyDate = Date.from(instant);
		System.out.println("Legacy Date: " + legacyDate);
	}
	
	private static void testingDateTimeFormatter() {
		DateTimeFormatter formatter =
			    DateTimeFormatter
			        .ofPattern("MMM dd, yyyy - HH:mm");

		String formatedDate = LocalDateTime.now().format(formatter);
		System.out.println("Formated date/time: " +  formatedDate); 
	}
	
	public static void main(String args[]) {
		//testingTheClock();
		//testingTimeZones();
		//testingLocalDate();
		testingLocalDateTime();
		testingDateTimeFormatter();
	}
}
