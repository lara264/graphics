import java.awt.*;
import javax.swing.*;

public class Sailboat extends JPanel
{
  public void paintComponent(Graphics g)
  {
    super.paintComponent(g);
    
	g.setColor(new Color(250,175,75)); 
	g.fillOval(550,325,150,150); 

	g.setColor(new Color(0,50,125));
	g.fillRect(0,400,800,200);
	
	g.setColor(Color.WHITE);
	g.fillOval(500,100,150,100);
	g.fillOval(475,125,75,75);
	g.fillOval(600,125,75,75);
			
	g.setColor(new Color(255,255,50));
	int[] xList1 = {550,700,775,475};
	int[] yList1 = {400,400,600,600};
	g.fillPolygon(xList1,yList1,4);
	
	g.setColor(new Color(100,75,25));
	g.fillRect(295,200,10,250);
	int[] xList2 = {100,500,450,150};
	int[] yList2 = {450,450,500,500};
	g.fillPolygon(xList2,yList2,4);
	
	g.setColor(new Color(255,255,255));
	int[] xList3 = {290,290,125};
	int[] yList3 = {200,440,440};
	g.fillPolygon(xList3,yList3,3);
	
	int[] xList4 = {310,310,475};
	int[] yList4 = {200,440,440};
	g.fillPolygon(xList4,yList4,3);
	
	g.setColor(Color.BLACK);
	g.drawString("S.S. Java",150,470);
	
	g.drawArc(125,125,75,50,45,90);
	g.drawArc(175,125,75,50,45,90);
	
	g.setColor(new Color(150,150,150,50));
	for (int i=0; i<600; i+=25)
		g.drawLine(0, i, 800, i);
	for (int i=0; i<800; i+=25)
		g.drawLine(i, 0, i, 600);
		
  }

  public static void main(String[] args)
  {
    JFrame window = new JFrame("A Beautiful Scene");
    window.setBounds(30, 30, 800, 600);
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    Sailboat panel = new Sailboat();
    panel.setBackground(new Color(150,190,240));
    Container c = window.getContentPane();
    c.add(panel);

    window.setVisible(true);
  }
}