import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

class Presenter extends JComponent implements ActionListener{

	private int x;
	private int y;
	private final int width = 5;
	private final int height = 5;

	private JComponent container;
	private final int snakeValue = 1;
	private final int mealValue = 2;
	private JFrame window;
	private Snake snake;
	private Gardener gardener;
	private Board board;
	private JTextField field;
	public String name;

	public Presenter() {
		window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setBounds(30, 30, 250, 250);
		window.setVisible(true);
	//	window.add(new JTextField(10));
	}

	
	public void show(Board b, Snake snake, Gardener gardener) {
		board = b;
		this.snake=snake;
		this.gardener=gardener;
		repaint();
		container = (JComponent) window.getContentPane();
		container.add(this);
	}

	public void showBoardStats(String name, int score, Stat stat) {
		JLabel label = new JLabel("" + name + " your current score is " + score);
		label.setHorizontalAlignment(JLabel.RIGHT);
		ArrayList<String>names=stat.getTop5List();
		window.add(label, BorderLayout.NORTH);
		for(int i=0;i<names.size();i++){
			JLabel label2=new JLabel(names.get(i)+" ");
			window.add(label2,BorderLayout.NORTH);
		}

	}
	
	// problema isaa ro odnav gamozraveba unda frames ro gamochndes textfildi
	//es metodi gamoachens textfilds romelshic chweris emre enters tu daartyamen
	//public string name gaxdeba es mnishvneloba
	public void showNameField(){
		field=new JTextField("name",10);
		field.setSize(10, 60);
		field.setVisible(true);
		field.setHorizontalAlignment(JTextField.CENTER);
		JPanel panel=new JPanel();
		panel.add(field);
		panel.setVisible(true);		
	    window.getContentPane().add(panel);
	    repaint();
		field.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		          name=field.getText();
		          
		        }
		      });	
		
		
	}
	

	public void paint(Graphics g) {
		g.drawRect(0, 0, getWidth()-1, getHeight()-1);
		ArrayList<Cell>body=(ArrayList<Cell>) snake.getSnakeBody();
		for(int i=0;i<body.size();i++){
			Cell cur=body.get(i);
			x = cur.getX();
			y = cur.getY();
			g.setColor(Color.RED);
			g.fillRect(x, y, width, height);
		}	
		
		ArrayList<Cell> cells=gardener.getFoodCell();
		for(int i=0;i<cells.size();i++){
			Cell c=cells.get(i);
			x = c.getX();
			y = c.getY();
			g.setColor(Color.green);
			g.fillRect(x, y, width, height);
		}
		
		
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
	}
}