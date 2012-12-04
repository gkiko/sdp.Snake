import java.awt.*;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class Presenter extends JComponent {

	private int x;
	private int y;
	private final int width = 5;
	private final int height = 5;

	private JComponent container;
	private final int snakeValue = 1;
	private final int mealValue = 2;
	private JFrame window;
	JPanel panel;
	private Board board;

	public Presenter() {
		window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setBounds(30, 30, 600, 600);
		window.setVisible(true);
	}

//	public void showBoard(Board b) {
//		board = b;
//		repaint();
//		container = (JComponent) window.getContentPane();
//		container.add(this);
//	}
	
	public void show(Board b, Snake snake, Gardener gardener) {
		board = b;
		repaint();
		container = (JComponent) window.getContentPane();
		container.add(this);
	}

	public void showBoardStats(String name, int score, Stat stat) {
		JLabel label = new JLabel("" + name + " your current score is " + score);
		label.setHorizontalAlignment(JLabel.RIGHT);
		window.add(label, BorderLayout.NORTH);

	}

	public void paint(Graphics g) {
		for (int i = 0; i < board.getWidth(); i++) {
			for (int j = 0; j < board.getHeight(); j++) {
				Cell cur = board.getCellAt(i, j);
				if (cur.getValue() == snakeValue) {// tu snakis nawilia
					x = cur.getX();
					y = cur.getY();
					g.setColor(Color.RED);
					g.fillRect(x, y, width, height);
				} else if (cur.getValue() == mealValue) {// tu sachmelia
					x = cur.getX();
					y = cur.getY();
					g.setColor(Color.green);
					g.fillRect(x, y, width, height);
				}
			}
		}
	}
}