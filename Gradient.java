/**
 * This program makes a nifty gradient.
 */
 
import java.awt.*;
import javax.swing.*;

public class Gradient extends JPanel
{
  public void paintComponent(Graphics g)
  {
    super.paintComponent(g);
    
    // initial RGB values
	int r1 = 200;
	int g1 = 30;
	int b1 = 240;
	
	// final RGB values
	int r2 = 155;
	int g2 = 150;
	int b2 = 75;
	
	for (int i=0; i<600; i++)
	{
		int red   = (int)( (i/600.0)*(r2-r1) + r1 );
		int green = (int)( (i/600.0)*(g2-g1) + g1 );
		int blue  = (int)( (i/600.0)*(b2-b1) + b1 );
		
		g.setColor(new Color(red,green,blue));
		g.drawLine(0,i,800,i);
	}
	
  }

  public static void main(String[] args)
  {
    JFrame window = new JFrame("Gradient Demo");
    window.setBounds(30, 30, 800, 600);
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    Gradient panel = new Gradient();
    panel.setBackground(Color.WHITE);
    Container c = window.getContentPane();
    c.add(panel);

    window.setVisible(true);
  }
}

