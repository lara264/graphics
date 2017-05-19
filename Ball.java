import java.awt.*;
import java.util.*;
import javax.swing.*;

public class Ball
{
	private int x,y;
	private Color c;
	private int d;
	private boolean movingRight;
	private boolean movingDown;
	
	public Ball(int w, int h)
	{
		boolean movingRight = Math.random()<0.5;
		boolean movingDown  = Math.random()<0.5;
		
		x = (int)((w-d)*Math.random());
		y = (int)((h-d)*Math.random());
		c = randomColor();
		
		d = (int)((50)*Math.random() + 10);;
	}
	
	private Color randomColor()
	{
		int r,g,b;
		
		do 
		{
			r = (int)(256*Math.random());
			g = (int)(256*Math.random());
			b = (int)(256*Math.random());
			
		} while (r<20 && g<20 & b<20);
		
		return new Color(r,g,b);	
	}
	
	public int getX() 		 {return x;};
	public int getY() 		 {return y;};
	public int getDiameter() {return d;};
	
	private double distanceBetweenCenters(int x1, int y1, int x2, int y2)
	{
		return Math.sqrt( (x1-x2)*(x1-x2) + (y1-y2)*(y1-y2) );
	}
	
	public void reverseX() { movingRight = !movingRight; }
	public void reverseY() { movingDown = !movingDown;	}
	public boolean movingRight() { return movingRight; }
	public boolean movingDown()  { return movingDown;  }
	
	public void move(int w, int h, ArrayList<Ball> allBalls)
	{		
		for (Ball other: allBalls)
		{
			int thisCenterX  = x+d/2;
			int thisCenterY  = y+d/2;
			int otherCenterX = other.getX()+other.getDiameter()/2;
			int otherCenterY = other.getY()+other.getDiameter()/2;
			
			if (distanceBetweenCenters(thisCenterX,thisCenterY,otherCenterX,otherCenterY) <= d/2+other.getDiameter()/2)
			{
				if(this.movingRight() != other.movingRight()) { this.reverseX(); other.reverseX(); }
				if(this.movingDown()  != other.movingDown())  { this.reverseY(); other.reverseY(); }
			}
			
			if (x<0)   {movingRight=true;}
			if (x+d>w) {movingRight=false;}
			if (y<0)   {movingDown=true;}
			if (y+d>h) {movingDown=false;}
		}		
		
		if (movingRight) x++; else x--;
		if (movingDown)  y++; else y--;
	}
	
	public void draw(Graphics g)
	{
		g.setColor(c);
		g.fillOval(x,y,d,d);
	}
}