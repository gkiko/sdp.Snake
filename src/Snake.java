import java.util.ArrayList;
import java.util.List;

public class Snake {
	private boolean alive; // es garedan unda icvlebodes
	private List<Cell> body;
	private Cell lastCell;
	private int x0, y0;

	public Snake(Board b) {
		alive = true;
		body = new ArrayList<Cell>();
		x0 = b.getWidth() / 2;
		y0 = b.getHeight() / 2;
		body.add(b.getCellAt(x0, y0));
	}

	/**
	 * Grows the length of snake Appends a Cell object at the end of the body
	 * List
	 */
	public void grow() {
		body.add(lastCell);
	}

	/**
	 * @return length of the snake
	 */
	public int getSnakeLength() {
		return body.size();
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
		Cell tale = body.remove(body.size() - 1);
		lastCell = new Cell(tale.getX(), tale.getY(), tale.getValue());
		Cell head = body.get(0);
		int x1 = head.getX();
		int y1 = head.getY();

		switch (direction) {
		case moveToRight:
			x1 -= 1;
			break;
		case moveToLeft:
			x1 += 1;
			break;
		case moveToDown:
			y1 += 1;
			break;
		case moveToUp:
			y1 -= 1;
			break;
		default:
			break;
		}

		if (checkMove(x1, y1)) {
			body.add(0, tale);
		}
	}

	/**
	 * 
	 * @param x1
	 *            new x coordinate of snake head
	 * @param y1
	 *            new y coordinate of snake head
	 * @return true if the move is valid, otherwise false
	 */
	private boolean checkMove(int x1, int y1) {
		if (body.size() == 1) return true;
		Cell second = body.get(1);
		if(x1 == second.getX() && y1 == second.getY()){
			return false;
		}
		return true;
	}

	/**
	 * 
	 * @return list of all dots which is covered by snake the first element is a
	 *         head of the snake
	 */
	public List<Cell> getSnakeBody() {
		List<Cell> b = new ArrayList<Cell>(body);
		return b;
	}

}