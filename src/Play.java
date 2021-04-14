// java Program to create a simple JWindow 
import java.awt.event.*;
import java.util.Random;
import javax.swing.*; 

enum Piece {Knot, Cross}
class Play extends JFrame implements ActionListener { 

	/**
	 *
	 */
	private static final long serialVersionUID = 4280745301036645779L;
	/**
	 *
	 */

	//Grid assignments
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

	static Player player;
	static Player computer;

	int moves = 0;

	// main class 
	public static void main(String[] args) { 

		Random random = new Random();
		int x = random.nextInt(1);

		//x == 0 means Player goes first, x == 1 means Computer goes first
		if (x == 0) {
			player = new Player("Andrew", Piece.Knot, true);
			computer = new Player("Computer", Piece.Cross, false);
		} else { 
			player = new Player("Andrew", Piece.Knot, false);
			computer = new Player("Computer", Piece.Cross, true);
		}
		

		// create a new frame 
		f = new JFrame("frame"); 

		// create a object 
		Play s = new Play(); 

		// create a panel 
		JPanel p = new JPanel(); 

		JButton tr = new JButton("Top Right");
		JButton tm = new JButton("Top Middle");
		JButton tl = new JButton("Top Left");

		JButton mr = new JButton("Middle Right");
		JButton c = new JButton("Centre");
		JButton ml = new JButton("Middle Left");

		JButton br = new JButton("Bottom Right");
		JButton bm = new JButton("Bottom Middle");
		JButton bl = new JButton("Bottom Left");


		// add actionlistener to button 
		tr.addActionListener(s);
		tm.addActionListener(s);
		tl.addActionListener(s);

		mr.addActionListener(s);
		c.addActionListener(s);
		ml.addActionListener(s);

		br.addActionListener(s);
		bm.addActionListener(s);
		bl.addActionListener(s);

		// add button to panel 

		p.add(tr);
		p.add(tm);
		p.add(tl);
		
		p.add(mr);
		p.add(c);
		p.add(ml);

		p.add(br);
		p.add(bm);
		p.add(bl);

		f.add(p); 

		// set the size of frame 
		f.setSize(500, 500); 

		f.setVisible(true);

		f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	} 

	// if button is pressed 
	public void actionPerformed(ActionEvent e) 
	{ 
		String s = e.getActionCommand(); 
		if (s.equals("Top Right")) {
			JWindow a = new JWindow(f);
			Display(a, s);
			a.setLocation(0, 100);

			if (moves >= 5) {
				checkWin();
			}
			moves += 1;

		} else if (s.equals("Top Middle")) {
			JWindow a = new JWindow(f);
			Display(a, s);
			a.setLocation(190, 100);

			if (moves >= 5) {
				checkWin();
			}
			moves += 1;

		} else if (s.equals("Top Left")) {
			JWindow a = new JWindow(f);
			Display(a, s);
			a.setLocation(380, 100);

			if (moves >= 5) {
				checkWin();
			}
			moves += 1;

		} else if (s.equals("Middle Right")) {
			JWindow a = new JWindow(f);
			Display(a, s);
			a.setLocation(0, 265);

			if (moves >= 5) {
				checkWin();
			}
			moves += 1;

		} else if (s.equals("Centre")) {
			JWindow a = new JWindow(f);
			Display(a, s);;
			a.setLocation(190, 265);

			if (moves >= 5) {
				checkWin();
			}
			moves += 1;

		} else if (s.equals("Middle Left")) {
			JWindow a = new JWindow(f);
			Display(a, s);
			a.setLocation(380, 265);

			if (moves >= 5) {
				checkWin();
			}
			moves += 1;

		} else if (s.equals("Bottom Right")) {
			JWindow a = new JWindow(f);
			Display(a, s);
			a.setLocation(0, 430);

			if (moves >= 5) {
				checkWin();
			}
			moves += 1;

		} else if (s.equals("Bottom Middle")) {
			JWindow a = new JWindow(f);
			Display(a, s);
			a.setLocation(190, 430);

			if (moves >= 5) {
				checkWin();
			}
			moves += 1;

		} else if (s.equals("Bottom Left")) {
			JWindow a = new JWindow(f);
			Display(a, s);
			a.setLocation(380, 430);

			if (moves >= 5) {
				checkWin();
			}
			moves += 1;
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

	public void Display(JWindow a, String s){
		JPanel b = new JPanel();
		ImageIcon i = null;
		String pic;

		if (player.getTurn()) {
			pic = String.valueOf(player.getPiece())+".jpg";
			i = new ImageIcon(pic);
			player.setTurn(false);
			computer.setTurn(true);
		} else {
			pic = String.valueOf(computer.getPiece())+".jpg";
			i = new ImageIcon(pic);
			player.setTurn(true);
			computer.setTurn(false);
		}
		
		JLabel l = new JLabel(i);

		switch(s){
			case "Top Right":
				TopRight.setPicture(pic);
			case "Top Middle":
				TopMiddle.setPicture(pic);
			case "Top Left":
				TopLeft.setPicture(pic);
			case "Middle Right":
				MiddleRight.setPicture(pic);
			case "Centre":
				Centre.setPicture(pic);
			case "Middle Left":
				MiddleLeft.setPicture(pic);
			case "Bottom Right":
				BottomRight.setPicture(pic);
			case "Bottom Middle":
				BottomMiddle.setPicture(pic);
			case "Bottom Left":
				BottomLeft.setPicture(pic);
		}


		b.add(l);
		a.add(b);
		
		a.setSize(185, 160); 
		a.setVisible(true);  
	}
} 
