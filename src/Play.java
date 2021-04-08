// java Program to create a simple JWindow 
import java.awt.event.*; 
import java.awt.*; 
import javax.swing.*; 


class Play extends JFrame implements ActionListener { 

	/**
	 *
	 */
	private static final long serialVersionUID = 4280745301036645779L;
	/**
	 *
	 */
	Grid TopRight = new Grid(1);
	Grid TopMiddle = new Grid(2);
	Grid TopLeft = new Grid(3);
	Grid MiddleRight = new Grid(4);
	Grid Centre = new Grid(5);
	Grid MiddleLeft = new Grid(6);
	Grid BottomRight = new Grid(7);
	Grid BottomMiddle = new Grid(8);
	Grid BottomLeft = new Grid(9);

	// frame 
	static JFrame f; 

	// main class 
	public static void main(String[] args) { 

		//Grid assignments
		

		// create a new frame 
		f = new JFrame("frame"); 

		// create a object 
		Play s = new Play(); 

		// create a panel 
		JPanel p = new JPanel(); 

		JButton b = new JButton("click"); 

		// add actionlistener to button 
		b.addActionListener(s);

		// add button to panel 
		p.add(b);

		f.add(p); 

		// set the size of frame 
		f.setSize(400, 400); 

		f.setVisible(true);

		f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	} 

	// if button is pressed 
	public void actionPerformed(ActionEvent e) 
	{ 
		String s = e.getActionCommand(); 
		if (s.equals("click")) { 
			// create a window 
			JWindow w = new JWindow(f); 

			// set panel 
			JPanel p = new JPanel(); 

			// create a label 
			JLabel l = new JLabel("this is a window"); 

			// set border 
			p.setBorder(BorderFactory.createLineBorder(Color.black)); 

			p.add(l); 
			w.add(p); 

			// set background 
			p.setBackground(Color.blue); 

			// setsize of window 
			w.setSize(200, 100); 

			// set visibility of window 
			w.setVisible(true); 

			// set location of window 
			w.setLocation(100, 100); 
		}
	}

	public boolean checkWin() {
		boolean win = false;

		while (!win) {
			//Horizontal Patterns
			win = checkGrid(TopRight, MiddleRight, BottomLeft);
			win = checkGrid(TopMiddle, Centre, BottomMiddle);
			win = checkGrid(TopLeft, MiddleLeft, BottomLeft);

			//Vertical Patterns
			win = checkGrid(TopRight, TopMiddle, TopLeft);
			win = checkGrid(MiddleRight, Centre, MiddleLeft);
			win = checkGrid(BottomRight, BottomMiddle, BottomLeft);

			//Diagonal Patterns
			win = checkGrid(TopRight, Centre, BottomLeft);
			win = checkGrid(TopLeft, Centre, BottomRight);

			//No Winning Pattern
			break;
		}
		return win;
	}

	public boolean checkGrid(Grid a, Grid b, Grid c) {
		if (a != null && b != null && c != null) {
			if (a.getPicture().equals(b.getPicture()) && a.getPicture().equals(c.getPicture()) && 
			b.getPicture().equals(c.getPicture())) {
				return true;
			} 
		}
		return false;
	}
} 
