import javax.swing.JFrame;


public class Main{
	public static void main(String[] args) {
		Presenter presenter = new Presenter();
		Board board = new Board(250, 250);
		Player pl = new SnakePlayer(new JFrame());
		Snake snake = new Snake(board);
		Referee ref = new Referee(board, snake);
		Stat st = new Stat();
		Gardener g = new Gardener(board, snake);
		Game game = new Game(board, st, snake, pl, g, presenter, ref);
		game.Play();
	}
}