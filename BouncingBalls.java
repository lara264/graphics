import java.awt.*;
import javax.swing.*;
import java.util.*;

public class BouncingBalls
{
	private int numBalls = 13;
	private int width = 800;
	private int height = 600;
	private int delay = 6;
	private ArrayList<Ball> bouncingBalls = new ArrayList();
		
	public void animate()
	{
		JFrame frame = new JFrame("Bouncing Balls");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MyDrawPanel drawPanel = new MyDrawPanel();
		frame.getContentPane().add(drawPanel);
		frame.setSize(width,height);
		frame.setVisible(true);

		for (int i=0; i<numBalls; i++)
			bouncingBalls.add(new Ball(width,height));
						
		while (true)
		{
			for(Ball b: bouncingBalls)
			{
				b.move(drawPanel.getWidth(),drawPanel.getHeight(),bouncingBalls);
			}
			
			drawPanel.repaint();
			try
			{
				Thread.sleep(delay);
			} catch(Exception ex) {}
		}
	}
	
	public static void main(String[] args)
	{
		BouncingBalls asdf = new BouncingBalls();
		asdf.animate();
	}
	
	class MyDrawPanel extends JPanel
	{
		public void paintComponent(Graphics g)
		{
			g.setColor(Color.BLACK);
			g.fillRect(0,0,this.getWidth(), this.getHeight());

			for(Ball b: bouncingBalls)
			{
				b.draw(g);
			}
		}
	}
}