/**
 * ULID: <krhurdl>
 * Class: IT 168 
 */
package edu.ilstu;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * 
 * Takes in a file called 'epl-fitures-2025.csv' and then simulates
 * each match. Then displays the results for each club and determines 
 * who was the best attacking, defensing and home/away teams
 * 
 * @author Kayla-Ann Hurdle
 * 
 */
public class MatchSimulator {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Random rand = new Random();
		String[] tempMatches;
		ArrayList<String> allTeamNames = new ArrayList<>();
		ArrayList<Club> allClubs = new ArrayList<>();
		ArrayList<Club> bestAttacks, bestDefenses, bestHomeTeams, bestAwayTeams;
		// stores info from file into a String array
		tempMatches = readEPLFile();
		
		// breaks apart the Strings in the tempMatches array
		// to organize into Match(which will be added to) and Clubs
		for (int i = 0; i < tempMatches.length; i++) {
			String[] tempLine = tempMatches[i].split(",");
			String date = tempLine[1];
			String home = tempLine[4];
			String away = tempLine[5];
			String venue = tempLine[6];
			
			int homeIndex = allTeamNames.indexOf(home);
			//checks if home team already exists (if not, adds it)
			if (homeIndex == -1) {
				allTeamNames.add(home);
				Club club = new Club(home, venue);
				allClubs.add(club);
				homeIndex = allTeamNames.indexOf(home);
			}
			else if (allClubs.get(homeIndex).getStadium() == null) {// checks if home has a stadium assigned
				allClubs.get(homeIndex).setStadium(venue);
			}
			
			// checks if away team already exists (if not, adds it)
			int awayIndex = allTeamNames.indexOf(away);
			if (awayIndex == -1) {
				allTeamNames.add(away);
				Club club = new Club(away);
				allClubs.add(club);
				awayIndex = allTeamNames.indexOf(away);
			}
			
			// adds match to both home and away team 
			int homeGoals = rand.nextInt(5)+1;
			int awayGoals = rand.nextInt(5)+1;
			
			Match match = new Match (home, away, venue, date, homeGoals, awayGoals);
			// adds match to home team
			List<Match> homeMatches = allClubs.get(homeIndex).getSeason();
			homeMatches.add(match);
			allClubs.get(homeIndex).setSeason(homeMatches);
			// adds match to away team
			List<Match> awayMatches = allClubs.get(awayIndex).getSeason();
			awayMatches.add(match);
			allClubs.get(awayIndex).setSeason(awayMatches);
			
		}
		
		allClubs = rankClubs(allClubs);
		printClubs(allClubs);
		
		// Finds best attacking team, defensing team, home team, & away team then display summary of each
		
		// --attacking team --
		bestAttacks = findBestAttack(allClubs);
		
		// checks if there was a tie, then prints best attacking team(s)
		if (bestAttacks.size() < 2) {
			System.out.println("\nBest attacking team(s):\nname                        stadium                     GS ");
			System.out.println(formatWord(bestAttacks.get(0).getName(), 28) + formatWord(bestAttacks.get(0).getStadium(), 28) + bestAttacks.get(0).calcGoalsScored());
		}
		else {
			// if multiple, prints each stats
			printBestAttDef(bestAttacks, "attack");
		}
		
		// --defending team --
		bestDefenses = findBestDefense(allClubs);
		
		// checks if there was a tie, then prints best defensing team(s)
		if (bestAttacks.size() < 2) {
			System.out.println("\nBest defensing team(s):\nname                        stadium                     GC ");
			System.out.println(formatWord(bestDefenses.get(0).getName(), 28) + formatWord(bestDefenses.get(0).getStadium(), 28) + bestDefenses.get(0).calcGoalsConceded());
		}
		else {
			// if multiple, prints each stats
			printBestAttDef(bestDefenses, "defense");
		}
		
		// --home team --
		bestHomeTeams = findBestHome(allClubs);
		
		// checks if there was a tie, then prints best home team(s)
		if (bestHomeTeams.size() < 2) {
			System.out.println("\nBest home team(s):\nname                        stadium                     home wins ");
			System.out.println(formatWord(bestHomeTeams.get(0).getName(), 28) + formatWord(bestHomeTeams.get(0).getStadium(), 28) + bestHomeTeams.get(0).calcHomeWins());
		}
		else {
			// if multiple, prints each stats
			printBestHomeAway(bestHomeTeams, "home");
		}
		
		// --away team --
		bestAwayTeams = findBestAway(allClubs);
		
		// checks if there was a tie, then prints best away team(s)
		if (bestAwayTeams.size() < 2) {
			System.out.println("\nBest away team(s):\nname                        stadium                     away wins ");
			System.out.println(formatWord(bestAwayTeams.get(0).getName(), 28) + formatWord(bestAwayTeams.get(0).getStadium(), 28) + bestAwayTeams.get(0).calcAwayWins());
		}
		else {
			// if multiple, prints each stats
			printBestHomeAway(bestAwayTeams, "away");
		}
	}
	
	
	
	/**
	 * Formats the 'best of' teams based on the assumption there are multiple
	 * and either the best of home or away. 
	 * Shows name, stadium, and home/away wins then all matches where they where 
	 * the home/away team
	 * 
	 * @param list of best home or away clubs 
	 * @param type of club weather it is 'home' or 'away'
	 */
	public static void printBestHomeAway(ArrayList<Club> bestTeams, String type) {
		// prints each attack team and it's season
		System.out.println("\nBest " + type + " team(s):");
		
		for (int i = 0; i < bestTeams.size(); i++) {
			List<Match> season = bestTeams.get(i).getSeason();
			
			// changes header based on type of results displaying
			System.out.println("name                        stadium                     " + type + " wins ");
			if (type.equals("home")) {
				System.out.println(formatWord(bestTeams.get(i).getName(), 28) + formatWord(bestTeams.get(i).getStadium(), 28) + bestTeams.get(i).calcHomeWins() + "\n");
			}
			else if (type.equals("away")) {
				System.out.println(formatWord(bestTeams.get(i).getName(), 28) + formatWord(bestTeams.get(i).getStadium(), 28) + bestTeams.get(i).calcAwayWins() + "\n");
			
			}
			
			// prints each of the matches from the season where home/away team was best with attack
			System.out.println("Date           Home Team           Away Team           Result    ");
			for (int m = 0; m < season.size(); m++) {
				if (season.get(m).getGoalsByHomeTeam() > season.get(m).getGoalsByAwayTeam()) {
					if (type.equals("home") && season.get(m).getHomeTeam().equals(bestTeams.get(i).getName())) {
						System.out.println(formatWord(season.get(m).getDate(), 15) + formatWord(season.get(m).getHomeTeam(), 20) + formatWord(season.get(m).getAwayTeam(), 20) 
							+ season.get(m).getGoalsByHomeTeam() + ":" + season.get(m).getGoalsByAwayTeam() + "\n");
					}
				}
				else if (type.equals("away") && season.get(m).getAwayTeam().equals(bestTeams.get(i).getName())) {
					System.out.println(formatWord(season.get(m).getDate(), 15) + formatWord(season.get(m).getHomeTeam(), 20) + formatWord(season.get(m).getAwayTeam(), 20) 
							+ season.get(m).getGoalsByHomeTeam() + ":" + season.get(m).getGoalsByAwayTeam() + "\n");
				}
			}
			System.out.println("\n");
			
		}
	}
	
	/**
	 * Formats the 'best of' teams based on the assumption there are multiple
	 * and either the best of attack or defense. 
	 * Shows name, stadium, and home/away wins then all matches where they where 
	 * the home/away team
	 * 
	 * @param list of best attack or defense clubs 
	 * @param type of club weather it is 'attack' or 'defense'
	 */
	public static void printBestAttDef(ArrayList<Club> bestAttacks, String type) {
		// prints each attack team and it's season
		System.out.println("\nBest " + type + "ing team(s):");
		
		for (int i = 0; i < bestAttacks.size(); i++) {
			List<Match> season = bestAttacks.get(i).getSeason();
			
			// changes header based on type of results displaying
			if (type.equals("attack")) {
				System.out.println("name                        stadium                     GS ");
				System.out.println(formatWord(bestAttacks.get(0).getName(), 28) + formatWord(bestAttacks.get(0).getStadium(), 28) + bestAttacks.get(0).calcGoalsScored() + "\n");
			}
			else if (type.equals("defense")) {
				System.out.println("name                        stadium                     GC ");
				System.out.println(formatWord(bestAttacks.get(0).getName(), 28) + formatWord(bestAttacks.get(0).getStadium(), 28) + bestAttacks.get(0).calcGoalsConceded() + "\n");
			
			}
			
			// prints each of the matches from the season where home team was best with attack
			System.out.println("Date           Home Team           Away Team           Result    ");
			for (int m = 0; m < season.size(); m++) {
				
				System.out.println(formatWord(season.get(m).getDate(), 15) + formatWord(season.get(m).getHomeTeam(), 20) + formatWord(season.get(m).getAwayTeam(), 20) 
							+ season.get(m).getGoalsByHomeTeam() + ":" + season.get(m).getGoalsByAwayTeam() + "\n");
			}
			System.out.println("\n");
			
		}
	}
		
	/**
	 * Finds every clubs with the most wins made away from their stadium
	 * and returns a list of them
	 * 
	 * @param all clubs in the matches
	 * @return a list of all teams that had the most wins made away
	 */
	public static ArrayList<Club> findBestAway(ArrayList<Club> allClubs) {
		Club bestAway = allClubs.get(0);
		ArrayList<Club> bestAwayTeams = new ArrayList<>();
		int index = 0;
		
		// finds clubs most wins made away
		for (int i = 1; i < allClubs.size(); i++) {
			if (bestAway.calcAwayWins() < allClubs.get(i).calcAwayWins()) {
				bestAway = allClubs.get(i);
				index = i;
			}
		}
		
		bestAwayTeams.add(bestAway);
		
		//now that best defense is found, compares to see if any where a tie and adds it to list
		for (int i = 1; i < allClubs.size(); i++) {
			if (bestAway.calcAwayWins() == allClubs.get(i).calcAwayWins() && i != index) {
				bestAwayTeams.add(allClubs.get(i));
			}
		}
		
		return bestAwayTeams;
	}
	
	/**
	 * Finds every clubs with the most wins made at their stadium
	 * and returns a list of them
	 * 
	 * @param all clubs in the matches
	 * @return a list of all teams that had the most wins made at home
	 */
	public static ArrayList<Club> findBestHome(ArrayList<Club> allClubs) {
		Club bestHome = allClubs.get(0);
		ArrayList<Club> bestHomeTeams = new ArrayList<>();
		int index = 0;
		
		// finds clubs with least goals conceded
		for (int i = 1; i < allClubs.size(); i++) {
			if (bestHome.calcHomeWins() < allClubs.get(i).calcHomeWins()) {
				bestHome = allClubs.get(i);
				index = i;
			}
		}
		
		bestHomeTeams.add(bestHome);
		
		//now that best defense is found, compares to see if any where a tie and adds it to list
		for (int i = 1; i < allClubs.size(); i++) {
			if (bestHome.calcHomeWins() == allClubs.get(i).calcHomeWins() && i != index) {
				bestHomeTeams.add(allClubs.get(i));
			}
		}
		
		return bestHomeTeams;
	}
	
	/**
	 * Finds every clubs with the least amount of goals conceded
	 * and returns a list of them
	 * 
	 * @param all clubs in the matches
	 * @return a list of all teams that had the least amount of goals conceded
	 */
	public static ArrayList<Club> findBestDefense(ArrayList<Club> allClubs) {
		Club bestDefense = allClubs.get(0);
		ArrayList<Club> bestDefenses = new ArrayList<>();
		int index = 0;
		
		// finds clubs with least goals conceded
		for (int i = 1; i < allClubs.size(); i++) {
			if (bestDefense.calcGoalsConceded() > allClubs.get(i).calcGoalsConceded()) {
				bestDefense = allClubs.get(i);
				index = i;
			}
		}
		
		bestDefenses.add(bestDefense);
		
		//now that best defense is found, compares to see if any where a tie and adds it to list
		for (int i = 1; i < allClubs.size(); i++) {
			if (bestDefense.calcGoalsConceded() == allClubs.get(i).calcGoalsConceded() && i != index) {
				bestDefenses.add(allClubs.get(i));
			}
		}
		
		return bestDefenses;
	}
	
	/**
	 * Finds every clubs with the most of goals scored
	 * and returns a list of them
	 * 
	 * @param all clubs in the matches
	 * @return a list of all teams that had the most of goals scored
	 */
	public static ArrayList<Club> findBestAttack(ArrayList<Club> allClubs) {
		int index = 0;
		Club bestAttack = allClubs.get(0);
		ArrayList<Club> bestAttacks = new ArrayList<>();
		
		// finds clubs with most goals scored
		for (int i = 1; i < allClubs.size(); i++) {
			if (bestAttack.calcGoalsScored() < allClubs.get(i).calcGoalsScored()) {
				bestAttack = allClubs.get(i);
				index = i;
			}
		}
		
		bestAttacks.add(bestAttack);
		
		//now that best attack is found, compares to see if any where a tie and adds it to list
		//skips the index best Attack was found at
		for (int i = 1; i < allClubs.size(); i++) {
			if (bestAttack.calcGoalsScored() == allClubs.get(i).calcGoalsScored() && i != index) {
				bestAttacks.add(allClubs.get(i));
			}
		}
		
		return bestAttacks;
	}
	
	/**
	 * Takes a list of all clubs and shows their ranking, name, 
	 * stadium, wins, draws, losses, goals scored, goals conceded,
	 * goals difference along with whether they will be moved to 
	 * Champions League, Europa League, or Relegated League
	 * 
	 * @param all clubs in the matches
	 */
	public static void printClubs(ArrayList<Club> allClubs) {
		// header 
		System.out.println("ranking   name                stadium                       win    draw   loss   GS     GC     GD     points CL EL RL \n"
				+ "=====================================================================================================================");
		
		for (int i = 0; i < allClubs.size(); i ++) {
			// adds a breaking point between 4-5 and 17-18
			if (i == 4 || i == 17) {
				System.out.println("---------------------------------------------------------------------------------------------------------------------");
			}
			
			// prints 9 or 8 spaces behind number based on if it is 1 digit or 2
			if (i < 9) {
				System.out.print((i + 1) + "         ");
			}
			else {
				System.out.print((i + 1) + "        ");
			}
			
			// puts part of club into variables so it is easier for me to read
			Club club = allClubs.get(i);
			String name = club.getName();
			String stadium = club.getStadium();
			
			// prints information about Club stats
			System.out.print(formatWord(name, 20) + formatWord(stadium, 30) + formatNumber(club.calcWins()) + formatNumber(club.calcDraws()) 
									+ formatNumber(club.calcLosses()) + formatNumber(club.calcGoalsScored()) + formatNumber(club.calcGoalsConceded()) 
									+ formatNumber(club.calcGoalDifference()) + formatNumber(club.calcPoints()));
			
			// determines if to mark club as CL, EL, or RL
			if (i < 4) { 
				System.out.println("y  n  n ");
			}
			else if (i == 4) {
				System.out.println("n  y  n ");
			}
			else if (i > 16) {
				System.out.println("n  n  y ");
			}
			else {
				System.out.println("n  n  n ");
			}
		}
	}
	
	/**
	 * Ranks each club in given list based on if they had 
	 * the most points (& and if they tie then biggest 
	 * goal difference)
	 * 
	 * @param all clubs in the matches
	 * @return all the clubs now ranked
	 */
	public static ArrayList<Club> rankClubs(ArrayList<Club> allClubs) {
		ArrayList<Club> rankedClubs = new ArrayList<>();
		
		rankedClubs.add(allClubs.get(0));
		// Goes through each element and compares it to the elements before
		for (int o =1; o < allClubs.size(); o++) {
			Club club = allClubs.get(o);
			int max = o;
			for (int i = o-1; i >= 0; i--) {
				if (rankedClubs.get(i).calcPoints() < club.calcPoints()) {
					max --;// decreases max to put it earlier in list
				}
				else if (rankedClubs.get(i).calcPoints() == club.calcPoints() && rankedClubs.get(i).calcGoalDifference() < club.calcGoalDifference()) {
					max--;
				}
			}
			rankedClubs.add(max, club);
			
		}
		
		return rankedClubs;
	}
	
	/**
	 * Takes in a word and how much space is needed to be 
	 * taken up and then adds that many spaces to the end of the word
	 * 
	 * @param word that needs space added behind
	 * @param spaces in total the word needs to take up
	 * @return the word with the correct number of spaces added
	 */
	public static String formatWord(String word, int spaces) {
		int spacesLeft = spaces - word.length();
		for (int i = 0; i < spacesLeft; i++) {
			word += " ";
		}
		
		return word;
	}
	
	/**
	 * Figures out how long the number is and then adds 
	 * spaces the max spaces added being 7.
	 * 
	 * @param number that needs to take up more space
	 * @return the number as a String with the correct number of spaces
	 */
	public static String formatNumber(int number) {
		String finalNumber = "";
		// adds spaces max being 7 and 1 less for every extra digit including the negative sign
		if (number < 0 && number > -10) {
			finalNumber = number + "     ";
		}
		else if (number < -9) {
			finalNumber = number + "    ";
		}
		else if (number < 10) {
			finalNumber = number + "      ";
		}
		else if (number < 100)  { 
			finalNumber = number + "     ";
		}
		else if (number <1000) {
			finalNumber = number + "    ";
		}
		
		return finalNumber;
	}
	
	/**
	 * Reads the 'epl-fixtures-2025' file and returns every line of it in an 
	 * array
	 * 
	 * @return a String carrying every line from 'epl-fixtures-2025.csv' file
	 */
	public static String[] readEPLFile() {
		File file = new File("epl-fixtures-2025.csv");
		Scanner scan = null;
		// variables for storing parts of a match
		String[] matches = new String[380];
		
		try {
			scan = new Scanner(file);
			
			// skips header line:
			scan.nextLine();
			
			// goes through each line in file to 
			// add to the string array
			for (int i = 0; i < matches.length && scan.hasNextLine(); i++) {
				matches[i] = scan.nextLine();
			}
		}
		catch (FileNotFoundException e) {//change exception??
			
		}
		finally {
			scan.close();
		}
		
		
		return matches;
	}

}
