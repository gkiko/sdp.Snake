
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.*;
import java.util.concurrent.CountDownLatch;

import javax.swing.*;

public class SnakePlayer extends JComponent implements Player {

	private final String UP = "UP", DOWN = "DOWN", LEFT = "LEFT", RIGHT = "RIGHT";
	private Direction dir;
	private final JFrame jf;
	
		public SnakePlayer(JFrame jf) {
			this.jf = jf;
			jf.add(this);
		}
	
	public void action() throws InterruptedException {
		final CountDownLatch latch = new CountDownLatch(1);
		KeyEventDispatcher dispatcher = new KeyEventDispatcher() {
			public boolean dispatchKeyEvent(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_DOWN) {
					dir = Direction.moveToDown;
					latch.countDown();
				} else if (e.getKeyCode() == KeyEvent.VK_UP) {
					dir = Direction.moveToUp;
					latch.countDown();
				} else if (e.getKeyCode() == KeyEvent.VK_LEFT){
					dir = Direction.moveToLeft;
					latch.countDown();
				}else if (e.getKeyCode() == KeyEvent.VK_RIGHT){
					dir = Direction.moveToRight;
					latch.countDown();
				}
					return false;
			}
		};
		KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(dispatcher);
		latch.await();
		KeyboardFocusManager.getCurrentKeyboardFocusManager().removeKeyEventDispatcher(dispatcher);
	}

	@Override
	public Direction getDirection() {
		try {
			action();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return dir;
	}

}