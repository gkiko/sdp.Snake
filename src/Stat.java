import java.util.ArrayList;

public class Stat {

	// The name of the file the results are saved in;
	private static final String FILENAME = "top5.txt";

	/**
	 * This list should contain top 5 pleyers names and their scores stored in a
	 * saved text file
	 * 
	 * @return: top5 list
	 * */
	public static ArrayList<String> getTop5List() {
		// TODO: implement bufferedReader and write results to ArrayList
		return null;
	}

	/**
	 * Checking the result of a player, if it is worthy to be in a top 5 players
	 * list
	 * 
	 * @param: player's score
	 * @param: players's name
	 * */
	public static void save(int score, String name) {
		if (isWorthy(score)) {
			setInTop5(score, name);
		}
	}

	/**
	 * @param: players score
	 * @return: true if the player is worthy to be in a top5 list
	 * */
	private static boolean isWorthy(int score) {
		// TODO: implement top 5 check;
		return false;
	}

	/**
	 * Set the player in a top 5 list
	 * 
	 * @param: player's score
	 * @param: players's name
	 * */
	private static void setInTop5(int score, String name) {
		// TODO: implement a bufferedWriter to save results in the text file;
	}

}