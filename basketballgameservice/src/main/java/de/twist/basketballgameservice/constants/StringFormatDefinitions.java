package de.twist.basketballgameservice.constants;

public enum StringFormatDefinitions {
	DOUBLE_POINT(":"),
	EMPTY_STRING(""),
	BACK_SLASH("\\"),
	COMMA(","),
	SUMMARY("SUMMARY"),
	LOCATION("LOCATION"),
	UID("UID"),
	ORGANIZER("ORGANIZER"),
	END_VEVENT("END:VEVENT");
	
	public final String value;

	private StringFormatDefinitions(String label) {
		this.value = label;
	}
}
