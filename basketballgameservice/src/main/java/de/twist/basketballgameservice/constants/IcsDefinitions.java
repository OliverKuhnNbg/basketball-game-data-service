package de.twist.basketballgameservice.constants;

public enum IcsDefinitions {
	BEGIN_VEVENT("BEGIN:VEVENT"),
	DTSTAMP("DTSTAMP"),
	DTSTART("DTSTART"),
	DTEND("DTEND"),
	SUMMARY("SUMMARY"),
	LOCATION("LOCATION"),
	UID("UID"),
	ORGANIZER("ORGANIZER"),
	END_VEVENT("END:VEVENT");
	
	public final String value;

	private IcsDefinitions(String label) {
		this.value = label;
	}
}
