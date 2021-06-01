import java.awt.event.*;
import java.awt.*;
import java.util.ArrayList;
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
	static Grid TopRight;
	static Grid TopMiddle;
	static Grid TopLeft;
	static Grid MiddleRight;
	static Grid Centre;
	static Grid MiddleLeft;
	static Grid BottomRight;
	static Grid BottomMiddle;
	static Grid BottomLeft;

	//frame 
	static JFrame f; 
	static JPanel p;

	//buttons
	static JButton tr;
	static JButton tm;
	static JButton tl;
	static JButton mr;
	static JButton c;
	static JButton ml;
	static JButton br;
	static JButton bm;
	static JButton bl;

	static JButton start;
	static JButton reset;

	static Player player;
	static Player computer;

	static int moves_made = 0;
	static ArrayList<Integer> moves_list = new ArrayList<Integer>();
	

	// main class 
	public static void main(String[] args) { 
		TopLeft = new Grid(null);
		TopMiddle = new Grid(null);
		TopRight = new Grid(null);
		MiddleLeft = new Grid(null);
		Centre = new Grid(null);
		MiddleRight = new Grid(null);
		BottomLeft = new Grid(null);
		BottomMiddle = new Grid(null);
		BottomRight = new Grid(null);

		// create a new frame 
		f = new JFrame("Knots & Crosses"); 

		// create a object 
		Play s = new Play(); 

		// create a panel 
		p = new JPanel(); 
		p.setLayout(null);

		//creates buttons for grid
		tl = new JButton("Top Left");
		tm = new JButton("Top Middle");
		tr = new JButton("Top Right");

		ml = new JButton("Middle Left");
		c = new JButton("Centre");
		mr = new JButton("Middle Right");

		bl = new JButton("Bottom Left");
		bm = new JButton("Bottom Middle");
		br = new JButton("Bottom Right");

		start = new JButton("Start");
		reset = new JButton("Reset");


		// add actionlistener to button 
		tl.addActionListener(s);
		tm.addActionListener(s);
		tr.addActionListener(s);

		ml.addActionListener(s);
		c.addActionListener(s);
		mr.addActionListener(s);

		bl.addActionListener(s);
		bm.addActionListener(s);
		br.addActionListener(s);

		start.addActionListener(s);
		reset.addActionListener(s);

		// add buttons to panel 
		p.add(tl);
		p.add(tm);
		p.add(tr);

		tl.setBounds(765, 100, 120, 30);
		tm.setBounds(885, 100, 120, 30);
		tr.setBounds(1005, 100, 120, 30);
		
		p.add(ml);
		p.add(c);
		p.add(mr);

		ml.setBounds(765, 140, 120, 30);
		c.setBounds(885, 140, 120, 30);
		mr.setBounds(1005, 140, 120, 30);

		p.add(bl);
		p.add(bm);
		p.add(br);

		bl.setBounds(765, 180, 120, 30);
		bm.setBounds(885, 180, 120, 30);
		br.setBounds(1005, 180, 120, 30);

		p.add(start);
		p.add(reset);

		start.setBounds(800, 600, 90, 30);
		reset.setBounds(900, 600, 90, 30);

		JLabel l = new JLabel("test");
		p.add(l);

		//add panel to the frame
		f.add(p); 

		

		// set the size of frame 
		f.setSize(1245, 690); 
		f.setVisible(true);
		f.setResizable(false);
		f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		hideGridButtons();
		reset.setVisible(false);
	} 

	// if button is pressed 
	public void actionPerformed(ActionEvent e) { 
		//name of button clicked
		String s = e.getActionCommand(); 

		if (s.equals("Start")) {
			//list of maximum number of moves that can be made
			//used for ease of the randomization of the computers moves
			for (int i = 0; i <=9; i++) {
				moves_list.add(i+1);
			}

			Random random = new Random();
			int x = random.nextInt(2);

			//x == 0 means Player goes first, x == 1 means Computer goes first
			if (x == 0) {
				player = new Player("Andrew", Piece.Knot, true);
				computer = new Player("Computer", Piece.Cross, false);
			} else { 
				player = new Player("Andrew", Piece.Knot, false);
				computer = new Player("Computer", Piece.Cross, true);
			}

			tr.setVisible(true);
			tm.setVisible(true);
			tl.setVisible(true);
			mr.setVisible(true);
			c.setVisible(true);
			ml.setVisible(true);
			br.setVisible(true);
			bm.setVisible(true);
			bl.setVisible(true);

			start.setVisible(false);

			//if computer goes first
			if (computer.getTurn()) {
				computerMove();
			}

		} else if (s.equals("Reset")) {
			TopLeft.setPicture(null);
			TopMiddle.setPicture(null);
			TopRight.setPicture(null);
			MiddleLeft.setPicture(null);
			Centre.setPicture(null);
			MiddleRight.setPicture(null);
			BottomLeft.setPicture(null);
			BottomMiddle.setPicture(null);
			BottomRight.setPicture(null);

			//reset.setVisible(false);
			start.setVisible(true);
			
			f.getContentPane().removeAll();
			f.getContentPane().repaint();

		} else {

			JLabel a = new JLabel();
			//JWindow a = new JWindow(f);
			JWindow d = new JWindow(f);
			int y = 0;

			//displays piece of the player's move
			Display(a, s);

			//determines where to display the piece based on what button was clicked
			if (s.equals("Top Right")) {
				a.setBounds(480, 100, 185, 160);
				tr.setVisible(false);
				y = moves_list.indexOf(3);

			} else if (s.equals("Top Middle")) {
				a.setBounds(290, 100, 185, 160);
				tm.setVisible(false);
				y = moves_list.indexOf(2);

			} else if (s.equals("Top Left")) {
				a.setBounds(100, 100, 185, 160);
				tl.setVisible(false);
				y = moves_list.indexOf(1);

			} else if (s.equals("Middle Right")) {
				a.setBounds(480, 265, 185, 160);
				mr.setVisible(false);
				y = moves_list.indexOf(6);

			} else if (s.equals("Centre")) {
				a.setBounds(290, 265, 185, 160);
				c.setVisible(false);
				y = moves_list.indexOf(5);

			} else if (s.equals("Middle Left")) {
				a.setBounds(100, 265, 185, 160);
				ml.setVisible(false);
				y = moves_list.indexOf(4);

			} else if (s.equals("Bottom Right")) {
				a.setBounds(480, 430, 185, 160);
				br.setVisible(false);
				y = moves_list.indexOf(9);

			} else if (s.equals("Bottom Middle")) {
				a.setBounds(290, 430, 185, 160);
				bm.setVisible(false);
				y = moves_list.indexOf(8);

			} else if (s.equals("Bottom Left")) {
				a.setBounds(100, 430, 185, 160);
				bl.setVisible(false);
				y = moves_list.indexOf(7);
			}
			moves_list.remove(y);

			p.add(a);
			f.repaint();

			boolean win = checkWin();

			if (win) {
				JPanel b = new JPanel();
				JLabel l = new JLabel("Player Wins!");

				b.add(l);
				d.add(b);
			
				d.setSize(100, 100);
				d.setLocation(250, 250);
				d.setVisible(true);

				reset.setVisible(true);
			} else {
				computerMove();
			}
		}
	}

	public static boolean checkWin() {
		moves_made += 1;
		System.out.println(moves_made);
		boolean win = false;

		if (moves_made == 9) {
			JWindow a = new JWindow(f);
			JPanel b = new JPanel();
			JLabel l = new JLabel("Draw");

			b.add(l);
			a.add(b);

			a.setSize(100, 100);
			a.setLocation(250, 250);
			a.setVisible(true);

			reset.setVisible(true);

		} else if (moves_made >= 5) {
			win = checkPatterns(1);
		}
		
		//sets button visibility to false if the game has ended in a win
		if (win) {
			hideGridButtons();
		}
		return win;
	}

	public static boolean checkGrid(Grid a, Grid b, Grid c) {
		//for ease of reading
		String a_pic = a.getPicture();
		String b_pic = b.getPicture();
		String c_pic = c.getPicture();

		if ((a_pic != null) && (b_pic != null) && (c_pic != null)) {
			if ((a.getPicture().equals(b.getPicture())) && (a.getPicture().equals(c.getPicture()))) {

				// System.out.println(a_pic);
				// System.out.println(b_pic);
				// System.out.println(c_pic);
				// System.out.println("this is true \n");
				return true;
			} 
		}
		// System.out.println(a_pic);
		// System.out.println(b_pic);
		// System.out.println(c_pic);
		// System.out.println("this is false \n");
		return false;
	}

	public static void Display(JLabel a, String s){
		JPanel b = new JPanel();
		ImageIcon i;
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
		
		System.out.println(pic);
		
		a.setIcon(i);


		if (s == "Top Left") {
			TopLeft.setPicture(pic);
		} else if (s == "Top Middle") {
			TopMiddle.setPicture(pic);
		} else if (s == "Top Right") {
			TopRight.setPicture(pic);
		} else if (s == "Middle Left") {
			MiddleLeft.setPicture(pic);
		} else if (s == "Centre") {
			Centre.setPicture(pic);
		} else if (s == "Middle Right") {
			MiddleRight.setPicture(pic);
		} else if (s == "Bottom Left") {
			BottomLeft.setPicture(pic);
		} else if (s == "Bottom Middle") {
			BottomMiddle.setPicture(pic);
		} else if (s == "Bottom Right") {
			BottomRight.setPicture(pic);
		}
	}

	public static void computerMove() {
		Random random = new Random();
		//JWindow a = new JWindow(f);
		JLabel a = new JLabel();
		JWindow d = new JWindow(f);
		int y = random.nextInt(moves_list.size());

		if (moves_list.get(y) == 1) {
			Display(a, "Top Left");
			a.setBounds(100, 100, 185, 160);

			tl.setVisible(false);

		} else if (moves_list.get(y) == 2) {
			Display(a, "Top Middle");
			a.setBounds(290, 100, 185, 160);

			tm.setVisible(false);

		} else if (moves_list.get(y) == 3) {
			Display(a, "Top Right");
			a.setBounds(480, 100, 185, 160);

			tr.setVisible(false);

		} else if (moves_list.get(y) == 4) {
			Display(a, "Middle Left");
			a.setBounds(100, 265, 185, 160);

			ml.setVisible(false);

		} else if (moves_list.get(y) == 5) {
			Display(a, "Centre");
			a.setBounds(290, 265, 185, 160);

			c.setVisible(false);

		} else if (moves_list.get(y) == 6) {
			Display(a, "Middle Right");
			a.setBounds(480, 265, 185, 160);

			mr.setVisible(false);

		} else if (moves_list.get(y) == 7) {
			Display(a, "Bottom Left");
			a.setBounds(100, 430, 185, 160);

			bl.setVisible(false);

		} else if (moves_list.get(y) == 8) {
			Display(a, "Bottom Middle");
			a.setBounds(290, 430, 185, 160);

			bm.setVisible(false);

		} else if(moves_list.get(y) == 9) {
			Display(a, "Bottom Right");
			a.setBounds(480, 430, 185, 160);

			br.setVisible(false);
		}
		moves_list.remove(y);

		p.add(a);
		f.repaint();

		boolean win = checkWin();

		if (win) {
			JPanel b = new JPanel();
			JLabel l = new JLabel("Computer Wins!");

			b.add(l);
			d.add(b);
			
			d.setSize(100, 100);
			d.setLocation(250, 250);
			d.setVisible(true);

			reset.setVisible(true);
		}
	}

	public static boolean checkPatterns(int i){
		boolean win = false;

		//Vertical Patterns
		if (i == 1) {
			win = checkGrid(TopRight, MiddleRight, BottomRight);
		} else if (i == 2) {
			win = checkGrid(TopMiddle, Centre, BottomMiddle);
		} else if (i == 3) {
			win = checkGrid(TopLeft, MiddleLeft, BottomLeft);
		//Horizontal Patterns
		} else if (i == 4) {
			win = checkGrid(TopLeft, TopMiddle, TopRight);
		} else if (i == 5) {
			win = checkGrid(MiddleLeft, Centre, MiddleRight);
		} else if (i == 6 ) {
			win = checkGrid(BottomLeft, BottomMiddle, BottomRight);

		//Diagonal Patterns
		} else if (i == 7) {
			win = checkGrid(BottomLeft, Centre, TopRight);
		} else if (i == 8) {
			win = checkGrid(TopLeft, Centre, BottomRight);
		}

		if (win || i == 8) {
			return win;
		}

		return checkPatterns(i+1);
	}

	public static void hideGridButtons() {
		tr.setVisible(false);
		tm.setVisible(false);
		tl.setVisible(false);
		mr.setVisible(false);
		c.setVisible(false);
		ml.setVisible(false);
		br.setVisible(false);
		bm.setVisible(false);
		bl.setVisible(false);
	}
}