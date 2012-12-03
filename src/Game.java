
public class Game {
	private Snake snake;
	private Board board;
	private Referee ref;
	private Direction dir;
	private Player player;
	private Gardener gardener;
	private Presenter presenter;
	private Stat stat;
	
	public Game(Board b, Stat st, Snake sn, Player pl, Gardener g, Presenter pr){
		board = b;
		snake = sn;
		ref = new Referee(board, snake);
		player = pl;
		gardener = g;
		presenter = pr;
		stat = new Stat();
	}

	public void Play(){
	while(ref.isAlive(snake)){
	dir = player.getDirection();
	snake.move(dir);
	gardener.addRemoveFood();
	presenter.showBoard(board);
	pause();
	}
	/* !!! */
	/* Playeris saxeli arsad ar gvchirdeba. qulis damaxsovrebisas bolos chavwert raime velshi */
		// stat.save(player.getName(), ref.getScore());
		// presenter.showBoardStats(player.getName(), ref.getScore(), stat);

	}

	private void pause() {
		// TODO Auto-generated method stub
		
	}
}
