import java.util.ArrayList;
import java.util.Collection;

public class Snake {
	private boolean alive;
	private Collection<Cell> body;

	public Snake(Board b) {
		alive = true;
		body = new ArrayList<Cell>();
	}

	// Grows the snake.
	public void grow() {
		
	}

	/**
	 * @return length of the snake
	 */
	public int getSnakeLength() {
		return 0;
	}

	/**
	 * @return true if snake is alive
	 */
	public boolean isSnakeAlive() {
		return alive;
	}

	/**
	 * 
	 * @param direction
	 *            moves snake by one step to given direction
	 */
	public void move(Direction direction) {

	}

	/**
	 * 
	 * @return list of all dots which is covered by snake the first element is a
	 *         head of the snake
	 */
	public Collection<Cell> getSnakeBody() {
		return null;
	}

}