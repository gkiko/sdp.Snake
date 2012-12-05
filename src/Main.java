import javax.swing.JFrame;


public class Main{
	public static void main(String[] args) {
		JFrame j = new JFrame();
		Presenter presenter = new Presenter(j);
		Board board = new Board(250, 250);
		Player pl = new SnakePlayer(j);
		Snake snake = new Snake(board);
		Referee ref = new Referee(board, snake);
		Stat st = new Stat();
		Gardener g = new Gardener(board, snake);
		Game game = new Game(board, st, snake, pl, g, presenter, ref);
		game.Play();
	}
}