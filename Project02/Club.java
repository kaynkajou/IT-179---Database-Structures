/**
 * ULID: <krhurdl>
 * Class: IT 168 
 */
package edu.ilstu;

import java.util.ArrayList;
import java.util.List;

/**
 * Class dedicated to storing information about a soccer club
 * including it's team name, the home stadium, and all the matches played that 
 * season.  
 * It also calculates information about the club including total wins, draws, losses, 
 * goals scored/conceded, total points, and total wins made at home/away.
 */
public class Club {
	private String name;
	private String stadium;
	private List<Match> season;
	
	/**
	 * A constructor for a soccer team club 
	 * for when the stadium is not yet known.
	 * Sets stadium to null until later it is 
	 * found in data. 
	 * 
	 * @param name of the team
	 */
	public Club(String name) {
		this.name = name;
		this.stadium = null;
		season = new ArrayList<>();
	}
	
	/**
	 * A constructor for a soccer club where the
	 * name and stadium are known
	 * 
	 * @param name of the team
	 * @param the home stadium
	 */
	public Club(String name, String stadium) {
		this(name);
		this.stadium = stadium;
	}
	
	/**
	 * Returns the name of the Soccer Club's team
	 * 
	 * @return name of the team
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Sets the name of the Soccer Club's team
	 * 
	 * @param name of the team
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Returns the name of the home stadium
	 * 
	 * @return the home stadium
	 */
	public String getStadium() {
		return stadium;
	}
	
	/**
	 * Sets the name of the home stadium
	 * 
	 * @param the home stadium
	 */
	public void setStadium(String stadium) {
		this.stadium = stadium;
	}
	
	/**
	 * Returns a list of all the matches played that season
	 * by this Soccer Club
	 * 
	 * @return a list of all the matches played that season
	 */
	public List<Match> getSeason() {
		return season;
	}
	
	/**
	 * Sets a list of all the matches played that season
	 * by this Soccer Club
	 * @param a list of all the matches played that season
	 */
	public void setSeason(List<Match> season) {
		this.season = season;
	}
	
	
	/**
	 * Returns the total number of wins made that season
	 * by this club
	 * 
	 * @return total number of wins made that season
	 */
	public int calcWins() {
		int totalWins = 0;
		
		for (int i = 0; i < season.size(); i++) {
			Match currMatch = season.get(i);
			//checks if they were home team or away team
			if (currMatch.getHomeTeam().equals(name)) {
				if (currMatch.getGoalsByAwayTeam() > currMatch.getGoalsByHomeTeam()) {
					totalWins ++;
				}
			}
			else {
				if (currMatch.getGoalsByAwayTeam() < currMatch.getGoalsByHomeTeam()) {
					totalWins ++;
				}
			}
		}
		
		return totalWins;
	}
	
	/**
	 * Returns the total number of draws made that season
	 * by this club
	 * 
	 * @return total number of draws made that season
	 */
	public int calcDraws() {
		int totalDraws = 0;
		
		for (int i = 0; i < season.size(); i++) {
			Match currMatch = season.get(i);
			// checks if score was equal
			if (currMatch.getGoalsByAwayTeam() == currMatch.getGoalsByHomeTeam()) {
				totalDraws ++;
			}
			
		}
		
		return totalDraws;
	}
	
	/**
	 * Returns the total number of losses made that season
	 * by this club
	 * 
	 * @return total number of losses made that season
	 */
	public int calcLosses() {
		// finds losses by finding remaining matches that were not a win or draw
		int totalLosses = season.size() - this.calcWins() - this.calcDraws();
		return totalLosses;
	}
	
	/**
	 * Returns the total number of goals scored that season
	 * by this team
	 * 
	 * @return the total number of goals scored that season
	 */
	public int calcGoalsScored() {
		int scored = 0;
		
		for (int i = 0; i < season.size(); i++) {
			Match currMatch = season.get(i);
			//checks if they were home team or away team
			if (currMatch.getHomeTeam().equals(name)) {
				scored += currMatch.getGoalsByHomeTeam();
			}
			else {
				scored += currMatch.getGoalsByAwayTeam();
			}
		}
		
		return scored;
	}
	
	/**
	 * Returns the total number of goals scored against 
	 *  this team that season
	 * 
	 * @return the total number of goals scored against this team that season
	 */
	public int calcGoalsConceded() { 
		int conceded = 0;
		
		for (int i = 0; i < season.size(); i++) {
			Match currMatch = season.get(i);
			//checks if they were home team or away team
			if (!currMatch.getHomeTeam().equals(name)) {
				conceded += currMatch.getGoalsByHomeTeam();
			}
			else {
				conceded += currMatch.getGoalsByAwayTeam();
			}
		}
		
		return conceded;
	}
	
	/**
	 * Calculates the points this team earned
	 * by giving 3 points for each win and 1 point
	 * for each draw
	 * 
	 * @return the total number of points 
	 */
	public int calcPoints() { 
		int points = 0;
		// gives 3 points for each win and 1 point for each draw
		points += this.calcWins() * 3;
		points += this.calcDraws();
		
		return points;
	}
	
	/**
	 * Calculates the goal difference by subtracting and then returning
	 * the total number of goals scored by total number of goals conceded
	 * 
	 * @return the difference between the goals score and the goals conceded
	 */
	public int calcGoalDifference() {
		return this.calcGoalsScored() - this.calcGoalsConceded();
	}
	
	/**
	 * Calculates the total wins made at home stadium by finding
	 * each match that was at home and adding 1 to the total if 
	 * they won at that game then returns the total
	 * 
	 * @return total number of wins made at home during the season
	 */
	public int calcHomeWins() {
		int totalWins = 0;
		
		for (int i = 0; i < season.size(); i++) {
			Match currMatch = season.get(i);
			//checks if they were home team or away team
			if (currMatch.getHomeTeam().equals(name)) {
				if (currMatch.getGoalsByAwayTeam() > currMatch.getGoalsByHomeTeam()) {
					totalWins ++;
				}
			}
			
		}
		
		return totalWins;
	}
	
	/**
	 * Calculates the total wins made away from stadium by finding
	 * each match that was away and adding 1 to the total if 
	 * they won at that game then returns the total
	 * 
	 * @return total number of wins made away from stadium during the season
	 */
	public int calcAwayWins() {
		int totalWins = 0;
		
		for (int i = 0; i < season.size(); i++) {
			Match currMatch = season.get(i);
			//checks if they were home team or away team
			if (!currMatch.getHomeTeam().equals(name)) {
				if (currMatch.getGoalsByAwayTeam() < currMatch.getGoalsByHomeTeam()) {
					totalWins ++;
				}
			}
		}
		
		return totalWins;
	}
	
	
}
