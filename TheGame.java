package finalProject;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import static java.lang.Character.*;
import java.awt.image.BufferedImage;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class TheGame extends Canvas implements KeyListener, Runnable
	{
		private Burger ship;
		private ArrayList<Ingredient> ingredients;
		

		private boolean[] keys;
		private BufferedImage back;

		public TheGame()
		{
			setBackground(Color.black);

			keys = new boolean[5];
	        ingredients = new ArrayList<Ingredient>();
	        for(int i = 0; i < 5; i++) {
	        ingredients.add(new Ingredient(10));
	        }
	        
			ship = new Burger(100,200,5);

			this.addKeyListener(this);
			new Thread(this).start();

			setVisible(true);
		}

	   public void update(Graphics window)
	   {
		   paint(window);
	   }

		public void paint( Graphics window )
		{
			//set up the double buffering to make the game animation nice and smooth
			Graphics2D twoDGraph = (Graphics2D)window;

			//take a snap shop of the current screen and same it as an image
			//that is the exact same width and height as the current screen
			if(back==null)
			   back = (BufferedImage)(createImage(getWidth(),getHeight()));

			//create a graphics reference to the back ground image
			//we will draw all changes on the background image
			Graphics graphToBack = back.createGraphics();
			graphToBack.setColor(Color.BLACK);
			graphToBack.fillRect(0,0,800,600);
			graphToBack.setColor(Color.PINK);
			graphToBack.drawString("mmmmm burger", 25, 50 );
		

			if(keys[0] == true)
			{
				ship.move("LEFT");
			}
			if(keys[1] == true)
			{
				ship.move("RIGHT");
			}
			if(keys[2] == true)
			{
				ship.move("UP");
			}
			if(keys[3] == true)
			{
				ship.move("DOWN");
			}
			
			boolean go = false;
			if(keys[4] == true) 
				go = true;
			
			if(go) 
			{ System.out.println("hello");   //test
			System.out.println(ingredients);
			for(int i = 0; i < ingredients.size(); i++) {
				boolean previousDone = false;
				if(i > 0) {
					System.out.println("i > 0");
					if(hasAttached(i-1)) {
						previousDone = true;
						System.out.println("previous hasAttached true");
					}
				}
				else {
					previousDone = true;
					System.out.println("i = 0 checked");
				}
				
				if(previousDone) {
				ingredients.get(i).move("DOWN");
				System.out.println("moving down" + i);
				}
			}
			}
			for(int j = 0; j < ingredients.size(); j++) {
				ingredients.get(j).draw(graphToBack);

			twoDGraph.drawImage(back, null, 0, 0);
			ship.draw(window);
			
			}
		}
		
		public void fallingObjects() {
			
		}

		public boolean hasAttached(int i) {
			int bottomBound = ingredients.get(i).getY();
			if(bottomBound == (ship.getY() - 80))
				return true;
			else
				return false;
		}

		public void keyPressed(KeyEvent e)
		{
			if (e.getKeyCode() == KeyEvent.VK_LEFT)
			{
				keys[0] = true;
			}
			if (e.getKeyCode() == KeyEvent.VK_RIGHT)
			{
				keys[1] = true;
			}
			if (e.getKeyCode() == KeyEvent.VK_UP)
			{
				keys[2] = true;
			}
			if (e.getKeyCode() == KeyEvent.VK_DOWN)
			{
				keys[3] = true;
			}
			if (e.getKeyCode() == KeyEvent.VK_SPACE)
			{
				keys[4] = true;
			}
			repaint();
		}

		public void keyReleased(KeyEvent e)
		{
			if (e.getKeyCode() == KeyEvent.VK_LEFT)
			{
				keys[0] = false;
			}
			if (e.getKeyCode() == KeyEvent.VK_RIGHT)
			{
				keys[1] = false;
			}
			if (e.getKeyCode() == KeyEvent.VK_UP)
			{
				keys[2] = false;
			}
			if (e.getKeyCode() == KeyEvent.VK_DOWN)
			{
				keys[3] = false;
			}
			if (e.getKeyCode() == KeyEvent.VK_SPACE)
			{
				keys[4] = false;
			}
			repaint();
		}

		public void keyTyped(KeyEvent e)
		{

		}

	   public void run()
	   {
	   	try
	   	{
	   		while(true)
	   		{
	   		   Thread.currentThread().sleep(5);
	            repaint();
	         }
	      }catch(Exception e)
	      {
	      }
	  	}
	}

