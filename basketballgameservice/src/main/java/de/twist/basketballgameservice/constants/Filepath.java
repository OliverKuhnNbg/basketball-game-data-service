package de.twist.basketballgameservice.constants;

public enum Filepath {
	STATIC("/static"),
	GAME_SHEDULES("/game_shedules"),
	H1_FILENAME("/Spielplan_N-JPR_22-01-2024_bis_28-04-2024.ics"),
	H2_FILENAME("/Spielplan_ALT-GS_22-01-2024_bis_28-04-2024.ics");

	public final String value;

	private Filepath(String label) {
		this.value = label;
	}
}
