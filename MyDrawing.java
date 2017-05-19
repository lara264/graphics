import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;


/**
 * Write a description of class MyDrawing here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyDrawing extends JPanel
{
  public Color getRandomColor() {
      int r = (int)(Math.random() * 256);
      int g = (int)(Math.random() * 256);
      int b = (int)(Math.random() * 256);
      
      return new Color(r, g, b);
  }    
    
   public void paintComponent(Graphics g)
  {
    super.paintComponent(g);
    int w = getWidth();
    int h = getHeight();
    
    g.setColor(getRandomColor());
    g.drawRect(w/4, h/4, w/2, h/2);
    
    /*
    g.fillRect(50, 25, 100, 200);
    
    g.setColor(new Color(33,38,237));
    g.fillOval(100, 150, 50, 75);
    
    g.drawLine(0, 0, 200, 400);
    */
   
    int[] xVals = {50,20,100, 200, 400};
    int[] yVals = {30,100,45, 100, 20};
    g.drawPolygon(xVals,yVals,5);
    
    int[] x = {getWidth()/2, getHeight()/2, getWidth()/3+20, getHeight()/3};
    int[] y = {getWidth()/2, getHeight()/2, getWidth()/3+200, getHeight()/3};
    g.drawPolygon(x, y, 4);
    
    //hexago so far?
    int[] z = {100, 150, 175, 150};
    int[] v = {100, 100, 130, 160};
    g.drawPolygon(z, v, 4);
    
    
    for(int i = 0 ; i < w; i++) {
        for(int j = 0; j < h; j++) {
            int[] xA = {i};
            int[] yA = {j};
            
            
            g.setColor(getRandomColor());
            g.drawLine(100, 100, i, 5);
        }
    }
  }

  public static void main(String[] args)
  {
    JFrame window = new JFrame("Drawings");
    window.setBounds(100, 100, 600, 400);
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JPanel canvas = new MyDrawing();
    canvas.setBackground(Color.DARK_GRAY);
    //canvas.setBackground(Color.WHITE);
    window.getContentPane().add(canvas);
    window.setVisible(true);
  }
}
