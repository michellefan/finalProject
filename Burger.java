package finalProject;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;

public class Burger extends MovingThing
{
	private int speed;

	public Burger()
	{
		this(0,0,0);
	}

	public Burger(int x, int y)
	{
		this(x,y,0);
	}

	public Burger(int x, int y, int s)
	{
		super(x, y);
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
		window.setColor(Color.YELLOW);
		window.fillArc(getX(), getY(), 100, 80, 0, -180);
	}

	public String toString()
	{
		return super.toString() + getSpeed();
	}
}
