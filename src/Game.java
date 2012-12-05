import java.util.ArrayList;

public class Game {
	
	private static final long pauseTime = 100;
	
	private Board board;
	private Stat stat;
	private Snake snake;
	private Player player;
	private Gardener gardener;
	private Presenter presenter;
	private Referee referee;
	
	public Game(Board b, Stat st, Snake sn, Player pl, Gardener g, Presenter pr, Referee ref){
		board = b;
		stat = st;
		snake = sn;
		player = pl;
		gardener = g;
		presenter = pr;
		referee = ref;
	}
	
	@SuppressWarnings("static-access")
	public void Play(){
		Direction dir;
		while(referee.isAlive(snake)){
			dir = player.getDirection();
			snake.move(dir);
			if(cecxla()){
				System.out.println("Asdasdasd");
				gardener.addRemoveFood();
				snake.grow();
			}
			presenter.show(board, snake, gardener);
			pause();
		}
		stat.save(referee.getScore(), player.getName());
		presenter.showBoardStats(player.getName(), referee.getScore(), stat);
	}
	
	
	private boolean cecxla() {
		ArrayList<Cell> b = (ArrayList<Cell>) snake.getSnakeBody();
		Cell head = b.get(0);
		ArrayList<Cell> l = gardener.getFoodCell();
		for (int i = 0; i < l.size(); i++) {
			if(head.getX()==l.get(i).getX() && head.getY()==l.get(i).getY())return true;
		}
		return false;
	}

	private void pause(){
		try {
			Thread.sleep(pauseTime);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}