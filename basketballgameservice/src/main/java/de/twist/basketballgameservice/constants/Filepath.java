package de.twist.basketballgameservice.constants;

public enum Filepath {
	STATIC("/static"),
	GAME_SHEDULES("/game_shedules"),
	H1_FILENAME("/Spielplan_N-JPR_22-01-2024_bis_28-04-2024.ics"),
	H2_FILENAME("/Spielplan_ALT-GS_22-01-2024_bis_28-04-2024.ics"),
	H1_FiLENAME_BRO("/Spielplan_NM-HSW_06-01-2025_bis_12-04-2025.ics");

	public final String value;

	private Filepath(String label) {
		this.value = label;
	}
}
