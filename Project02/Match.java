/**
 * ULID: <krhurdl>
 * Class: IT 168 
 */
package edu.ilstu;

/**
 * A class dedicated towards storing the information
 * for one Match including information about name of home
 * and away team, name of stadium that match took place at, 
 * the date the match happened, and goals made by home and
 * away team
 */
public class Match {
	private String homeTeam;
	private String awayTeam;
	private String stadium;
	private String date;
	private int goalsByHomeTeam;
	private int goalsByAwayTeam;
	
	/**
	 * Constructor for match that takes in
	 * the name of home and away team, name of 
	 * stadium it took place, date the match 
	 * happened, and goals made by home and away
	 * team
	 * 
	 * @param home team name
	 * @param away team name
	 * @param stadium that match took place
	 * @param date that the match took place
	 * @param goals made by the home team that match
	 * @param goals made by the away team that match
	 */
	public Match(String home, String away, String stadium, String date, int goalsByHome, int goalsByAway) {
		this.homeTeam = home;
		this.awayTeam = away;
		this.stadium = stadium;
		this.date = date;
		this.goalsByHomeTeam = goalsByHome;
		this.goalsByAwayTeam = goalsByAway;
	}
	
	/**
	 * Returns the date when the match happened
	 * as a String
	 * 
	 * @return the date the match happpened
	 */
	public String getDate() {
		return this.date;
	}
	
	/**
	 * Sets the date the match happened 
	 * preferably in the format YEAR-MONTH-DAY
	 * 
	 * @param the date the match happened
	 */
	public void setDate(String date) {
		this.date = date;
	}

	/**
	 * Returns the name of the home team
	 * participating that match
	 * 
	 * @return the name of the home team
	 */
	public String getHomeTeam() {
		return this.homeTeam;
	}

	/**
	 * Sets the name of the home team 
	 * participating that match
	 * 
	 * @param the name of the home team 
	 */
	public void setHomeTeam(String home) {
		this.homeTeam = home;
	}

	/**
	 * Returns the name of the away team
	 * participating that match
	 * 
	 * @return the name of the away team
	 */
	public String getAwayTeam() {
		return awayTeam;
	}

	/**
	 * Sets the name of the away team 
	 * participating that match
	 * 
	 * @param the name of the away team 
	 */
	public void setAwayTeam(String away) {
		this.awayTeam = away;
	}

	/**
	 * Returns the name of the stadium the match took place at
	 * 
	 * @return the name of the stadium the match took place
	 */
	public String getStadium() {
		return stadium;
	}

	/**
	 * Sets the name of the stadium the match took place at
	 * 
	 * @param the name of the stadium the match took place
	 */
	public void setStadium(String stadium) {
		this.stadium = stadium;
	}

	/**
	 * Returns the goals that the home team made
	 * that match
	 * 
	 * @return the total goals that the home team made
	 */
	public int getGoalsByHomeTeam() {
		return goalsByHomeTeam;
	}

	/**
	 * Sets the goals that the home team made
	 * that match
	 * 
	 * @param the total goals that the home team made
	 */
	public void setGoalsByHomeTeam(int goalsByHome) {
		this.goalsByHomeTeam = goalsByHome;
	}

	/**
	 * Returns the goals that the away team made
	 * that match
	 * 
	 * @return the total goals that the away team made
	 */
	public int getGoalsByAwayTeam() {
		return goalsByAwayTeam;
	}

	/**
	 * Sets the goals that the away team made
	 * that match
	 * 
	 * @param the total goals that the away team made
	 */
	public void setGoalsByAwayTeam(int goalsByAway) {
		this.goalsByAwayTeam = goalsByAway;
	}
	
}
