/**
 * DVD Screen saver simulation
 * 
 * @author Jon Cooper
 * @version May 2, 2008
 */

import java.awt.*;
import javax.swing.*;

public class ScreenSaver
{
	private Image logo = new ImageIcon("dvd_logo.jpg").getImage();
	private int width = 800;
	private int height = 600;
	private int delay = 10;
	private int x,y;
	
	public void animate()
	{
		JFrame frame = new JFrame("Screen Saver");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MyDrawPanel drawPanel = new MyDrawPanel();
		frame.getContentPane().add(drawPanel);
		frame.setSize(width,height);
		frame.setVisible(true);
		
		int imageWidth = logo.getWidth(null);
		int imageHeight = logo.getHeight(null);
				
		boolean movingRight = Math.random()<0.5;
		boolean movingDown  = Math.random()<0.5;
		
		x = (int)((drawPanel.getWidth()-imageWidth)*Math.random());
		y = (int)((drawPanel.getHeight()-imageHeight)*Math.random());

		while (true)
		{
			if (x<0 || x+imageWidth>drawPanel.getWidth())   movingRight=!movingRight;
			if (y<0 || y+imageHeight>drawPanel.getHeight()) movingDown=!movingDown;

			if (movingRight) x++; else x--;
			if (movingDown)  y++; else y--;
			
			drawPanel.repaint();
			try
			{
				Thread.sleep(delay);
			} catch(Exception ex) {}
		}
	}
	
	public static void main(String[] args)
	{
		ScreenSaver dvd = new ScreenSaver();
		dvd.animate();
	}
	
	@SuppressWarnings("serial")
	class MyDrawPanel extends JPanel
	{
		public void paintComponent(Graphics g)
		{
			g.setColor(Color.BLACK);
			g.fillRect(0,0,this.getWidth(), this.getHeight());
			g.drawImage(logo,x,y,this);
		}
	}
}
