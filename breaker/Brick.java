import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.event.*;
import java.awt.geom.*;

public class Brick
{
   private Rectangle2D.Double brick;
   private Line2D.Double top, left, right, bot;
   private Line2D.Double[] lineList;
   private final double BX = 100;
   private final double BY = 50;
   public Brick(int x, int y)
   {
       top = new Line2D.Double(x, y, x+BX, y);
       left = new Line2D.Double(x, y, x, y+BY);
       right = new Line2D.Double(x+BX, y, x+BX, y+BY);
       bot = new Line2D.Double(x, y+BY, x+BX, y+BY);
   }
   
   public void draw(Graphics2D g2)
   {
       g2.draw(top);
       g2.draw(left);
       g2.draw(right);
       g2.draw(bot);
   }
   
   public Line2D.Double getSideT()
   {
       return top;
   }
   
   public Line2D.Double getSideB()
   {
       return bot;
   }
   
   public Line2D.Double getSideL()
   {
       return left;
   }
   
   public Line2D.Double getSideR()
   {
       return right;
   }
   
}
