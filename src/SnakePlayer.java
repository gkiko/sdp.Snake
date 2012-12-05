
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.*;
import java.util.concurrent.CountDownLatch;

import javax.swing.*;

public class SnakePlayer extends JComponent implements Player {

	private final String UP = "UP", DOWN = "DOWN", LEFT = "LEFT", RIGHT = "RIGHT";
	private Direction dir = Direction.moveToUp;
	private final JFrame jf;
	
		public SnakePlayer(JFrame jf) {
			this.jf = jf;
			jf.add(this);
			jf.setVisible(true);
		}
	

	@Override
	public Direction getDirection() {
		jf.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_S) {
					dir = Direction.moveToDown;
				} else if (e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A) {
					dir = Direction.moveToLeft;
				}else if (e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D) {
					dir = Direction.moveToRight;
				}else if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_W) {
					dir = Direction.moveToUp;
				}
			}
			@Override
			public void keyReleased(KeyEvent arg0) {
			}	
		});
		return dir;
	}
}