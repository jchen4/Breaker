import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.event.*;
import java.awt.geom.*;

public class Brick
{
   private Rectangle2D.Double brick;
   public Brick(int x, int y)
   {
       brick = new Rectangle2D.Double(x, y, 50, 20);
   }
   
   public void draw(Graphics2D g2)
   {
       g2.draw(brick);
   }
}
