package de.twist.basketballgameservice.helpers.date;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class StringDateHelper {

	/** get LocalDate & LocalTime from current dataString */
	public static Date getDateFromString(String dataString) {
		String[] dateStringArr = dataString.split("T");
		String dateString = dateStringArr[0];
		LocalDate localDate = LocalDate.parse(dateString, DateTimeFormatter.BASIC_ISO_DATE);

		String timeString = dateStringArr[1].replace("Z", "");
		timeString = timeString.substring(0, 2) + ":" + timeString.substring(2, 4) + ":" + timeString.substring(4, 6);
		LocalTime localTime = LocalTime.parse(timeString);

		return getDateFromLocalDateAndLocalTime(localDate, localTime);
	}

	/** get Date from LocalDate & LocalTime */
	private static Date getDateFromLocalDateAndLocalTime (LocalDate localDate, LocalTime localTime) {
		LocalDateTime ldt = LocalDateTime.of(localDate, localTime);
		Date date = Date.from(ldt.atZone(ZoneId.systemDefault()).toInstant());
		return date;
	}
}
