package de.twist.basketballgameservice.models;

import java.util.Date;

import de.twist.basketballgameservice.models.submodels.Location;


public class CalendarGameEvent {

	private long gameId;
	
	private Date lastDataUpdate;
	private Date startGameDate;
	private Date endGameDate;
	private boolean gamePlayed;

	private String homeTeam;
	private String guestTeam;
	
	private Location location;

	/** Getters */
	public long getGameId() {
		return gameId;
	}
	public Date getLastDataUpdate() {
		return lastDataUpdate;
	}
	public Date getStartGameDate() {
		return startGameDate;
	}
	public Date getEndGameDate() {
		return endGameDate;
	}
	public boolean isGamePlayed() {
		return gamePlayed;
	}
	public String getHomeTeam() {
		return homeTeam;
	}
	public String getGuestTeam() {
		return guestTeam;
	}
	public Location getLocation() {
		return location;
	}

	/** Setters */
	public void setGameId(long gameId) {
		this.gameId = gameId;
	}
	public void setLastDataUpdate(Date lastDataUpdate) {
		this.lastDataUpdate = lastDataUpdate;
	}
	public void setStartGameDate(Date startGameDate) {
		this.startGameDate = startGameDate;
	}
	public void setEndGameDate(Date endGameDate) {
		this.endGameDate = endGameDate;
	}
	public void setGamePlayed(boolean gamePlayed) {
		this.gamePlayed = gamePlayed;
	}
	public void setHomeTeam(String homeTeam) {
		this.homeTeam = homeTeam;
	}
	public void setGuestTeam(String guestTeam) {
		this.guestTeam = guestTeam;
	}
	public void setLocation(Location location) {
		this.location = location;
	}

	
	
}
