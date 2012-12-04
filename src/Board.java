public class Board {
	Cell[][] cellBoard;
	
	public Board(int rows, int cols) {
		cellBoard = new Cell[rows][cols];
	}

	public Cell getCellAt(int x, int y){
		return cellBoard[y][x];
	}

	public int getWidth(){
		return cellBoard[0].length;
	}

	public int getHeight(){
		return cellBoard.length;
	}
}
