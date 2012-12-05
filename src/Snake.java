import java.util.ArrayList;
import java.util.List;

public class Snake {
	private boolean alive; // es garedan unda icvlebodes
	private List<Cell> body;
	private Cell lastCell;
	private int x0, y0;
	private int initSize = 3;
	private int width, height;
	
	public Snake(Board b) {
		alive = true;
		body = new ArrayList<Cell>();
		width = b.getWidth();
		height = b.getHeight();
		initSnake(b);
	}

	private void initSnake(Board b) {
		x0 = b.getWidth() / 2;
		y0 = b.getHeight() / 2;
		for (int i = 0; i < initSize; i++) {
			body.add(new Cell(x0, y0+i, 1));
		}
	}

	/**
	 * Grows the length of snake Appends a Cell object at the end of the body
	 * List
	 */
	public void grow() {
		System.out.println("grow1");
		body.add(lastCell);
		System.out.println("grow2");
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
		Cell tale = body.get(body.size() - 1);
		Cell head = body.get(0);
		System.out.println("snake: "+head.getX()+" "+head.getY());
		int x1 = head.getX();
		int y1 = head.getY();

		switch (direction) {
		case moveToRight:
			x1 = (x1+1)%width;
			break;
		case moveToLeft:
			x1 = (x1-1+width)%width;
			break;
		case moveToDown:
			y1 = (y1+1)%height;
			break;
		case moveToUp:
			y1 = (y1-1+height)%height;
			break;
		default:
			break;
		}

		if (checkMove(x1, y1)) {
			body.add(0, new Cell(x1, y1, 1));
			body.remove(body.size()-1);
			lastCell = tale;//new Cell(tale.getX(), tale.getY(), tale.getValue());
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