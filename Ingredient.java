package finalProject;

import java.awt.Color;
import java.awt.Graphics;

public class Ingredient extends MovingThing {
	
	private int speed;

	public Ingredient()
	{
		this(0);
	}

	public Ingredient(int s)
	{
		super((int)(Math.random()*(800) - 100), 0);
		speed=s;
	}


	public void setSpeed(int s)
	{
	   speed = s;
	}

	public int getSpeed()
	{
	   return speed;
	}
	

	public void draw( Graphics window )
	{
		int r = (int)(Math.random() * 256);
		int g = (int)(Math.random() * 256);
		int b = (int)(Math.random() * 256);
		Color color = new Color(r, g, b);
		window.setColor(color);
		window.fillRect(getX(), getY(), 100, 20);
	}

	public String toString()
	{
		return super.toString() + getSpeed();
	}
}

