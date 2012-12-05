import java.util.ArrayList;
import java.util.Random;

public class Gardener {
	private Cell cell1;
	private Cell cell2;
	private Board b;
	private Snake s;
	private Random rg = new Random();
	
	public Gardener(Board b, Snake s) {
		this.b = b;
		this.s = s;
		cell1 = getRandomCell();
		cell2 = getRandomCell();
	}
	
	private boolean equalsCell(Cell c1, Cell c2){
		return c1.getX() == c2.getX() && c1.getY() == c2.getY();
	}
	
	private boolean containsSnake(Cell cell, ArrayList<Cell> list){
		Cell c;
		for(int i=0; i<s.getSnakeLength(); i++){
			c = list.get(i);
			if(equalsCell(c, cell)) return true;
		}
		return false;
	}
	
	private Cell getRandomCell(){
		int n = rg.nextInt(b.getHeight()*b.getWidth() - s.getSnakeLength())+1;
		ArrayList<Cell> list = (ArrayList<Cell>) s.getSnakeBody();
		Cell c;
		int p = 0;
		for(int i=0; i<b.getHeight(); i++){
			for(int j=0; j<b.getWidth(); j++){
				c = new Cell(j, i, 3);
				if(!containsSnake(c, list)) p++;
				if(p==n){
					return c;
				}
			}
		}
		return null;
	}

	/**
	 * amowmebs, gvelma tu aigo sachmeli, agebis shemtxvevashi, 
	 * irchevs random ujras, ise ro ar daemtxves snake-s da cell
	 * mianichebs axal mnishvnelobas.
	 */
	public void addRemoveFood() {
	//	if(equalsCell(s.getSnakeBody().get(0) , cell1)){
		if(containsSnake(cell1, (ArrayList<Cell>)s.getSnakeBody())){
		//	System.out.println("gardener1");
			cell1 = getRandomCell();
			System.out.println(cell1.getX()+" "+cell1.getY());
		//	System.out.println("gardener2");
		}
		//if(equalsCell(s.getSnakeBody().get(0) , cell2)){	
		if(containsSnake(cell2, (ArrayList<Cell>)s.getSnakeBody())){
		//	System.out.println("gardener1");
			cell2 = getRandomCell();
			System.out.println(cell2.getX()+" "+cell2.getY());
		//	System.out.println("gardener2");
		}
	}

	/**
	 * abrunebs cells
	 */
	public ArrayList<Cell> getFoodCell() {
		ArrayList<Cell> list= new ArrayList<Cell>();
		list.add(cell1);
		list.add(cell2);
		return list;
	}
}