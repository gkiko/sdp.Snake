public class Game {
	
	private static final long pauseTime = 500;
	
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
			gardener.addRemoveFood();
			presenter.show(board, snake, gardener);
			pause();
		}
		stat.save(referee.getScore(), player.getName());
		presenter.showBoardStats(player.getName(), referee.getScore(), stat);
	}
	
	
	private void pause(){
		try {
			Thread.sleep(pauseTime);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}