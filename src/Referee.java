import java.util.*;

public class Referee {
	public Referee(Board board, Snake snake) {
		this.board = board;
		this.snake = snake;
	}

	// Returns whether the game is still in progress.
	public boolean isAlive(Snake snake) {
		ArrayList<Cell> snakeBody = (ArrayList<Cell>) snake.getSnakeBody();
		HashSet<String> set = new HashSet<String>();
		for(int i=0; i<snakeBody.size(); i++){
			Cell current = snakeBody.get(i);
	//		if(!isInBounds(current)) return false;
			String key = toKey(current);
			if(set.contains(key)) return false;
			set.add(key);
		}
		return true;
	}
	
	private String toKey(Cell cell){
		int x = cell.getX(), y = cell.getY();
		return x+","+y;
	}
	
	private boolean isInBounds(Cell cell){
		return cell.getX()>=0 && cell.getY()>=0 && cell.getX()<board.getHeight() && cell.getY()<board.getWidth();
	}

	// Returns the score.
	public int getScore() {
		return snake.getSnakeLength()-3;
	}
	
	private Board board;
	private Snake snake;
	
}