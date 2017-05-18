/**
 * This program uses loops to make stars and a fence.
 *
 * @author Jon Cooper
 * @version Aug 25, 2008
 */
 
import java.awt.*;
import javax.swing.*;

public class StarryNight extends JPanel
{	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
	
	
		// stars
		g.setColor(Color.WHITE);
		
		for (int i=0; i<200; i=i+1)
		{
			int starX = (int)(800*Math.random());
			int starY = (int)(400*Math.random());
			int starD = (int)(5*Math.random()+1);
			
			g.fillOval(starX, starY, starD, starD);
		}
		
	    // grass
		g.setColor(new Color(0,150,0));
		g.fillRect(0,400,800,200);
	
		// moon
		g.setColor(new Color(220,220,100));
		g.fillOval(670,80,50,50);
		g.setColor(Color.BLACK);
		g.fillOval(690,80,50,50);
	
		// fence
		g.setColor(Color.WHITE);
		for (int i=10; i<800; i=i+40)
		{
			int x = i;
			int y = 380;
			
		    int[] fenceXs = {x  , x+5, x+10, x+10, x   };
		    int[] fenceYs = {y+5, y  , y+5 , y+60, y+60};
		    
		    g.fillPolygon(fenceXs,fenceYs, 5);
		}
		g.fillRect(0, 390, 800, 10);
		g.fillRect(0, 420, 800, 10);
		
  	}

	public static void main(String[] args)
	{
		JFrame window = new JFrame("Starry Night");
		window.setBounds(30, 30, 800, 600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		StarryNight panel = new StarryNight();
		panel.setBackground(Color.BLACK);
		Container c = window.getContentPane();
		c.add(panel);
		
		window.setVisible(true);
	}
}

