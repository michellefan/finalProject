package finalProject;

import javax.swing.JFrame;
import java.awt.Component;

public class BurgerTester extends JFrame
{
	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;

	public BurgerTester()
	{
		super("BURGER GAME");
		setSize(WIDTH,HEIGHT);

		TheGame theGame = new TheGame();
		((Component)theGame).setFocusable(true);

		getContentPane().add(theGame);

		setVisible(true);
	}

	public static void main( String args[] )
	{
		BurgerTester run = new BurgerTester();
		
		
	}
}