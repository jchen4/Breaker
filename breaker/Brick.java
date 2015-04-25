import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.*;
import java.awt.geom.*;

public class Brick
{
   private Line2D.Double top, left, right, bot;
   //length of brick
   private final double BX = 100;
   //height of brick
   private final double BY = 50;
   public Brick(int x, int y)
   {
       top = new Line2D.Double(x, y, x+BX, y);
       left = new Line2D.Double(x, y, x, y+BY);
       right = new Line2D.Double(x+BX, y, x+BX, y+BY);
       bot = new Line2D.Double(x, y+BY, x+BX, y+BY);
   }
   
   /*
    * Draws all 4 lines of brick
    * 
    * @param    graphics object
    */
   public void draw(Graphics2D g2)
   {
       g2.draw(top);
       g2.draw(left);
       g2.draw(right);
       g2.draw(bot);
   }
   
   /*
    * Gets top side
    * 
    * @return   top side as line
    */
   public Line2D.Double getSideT()
   {
       return top;
   }
   
   /*
    * Gets bottom side
    * 
    * @return   bottom side as line
    */
   public Line2D.Double getSideB()
   {
       return bot;
   }
   
   /*
    * Gets left side
    * 
    * @return   left side as line
    */
   public Line2D.Double getSideL()
   {
       return left;
   }
   
   /*
    * Gets right side
    * 
    * @return   right side as line
    */
   public Line2D.Double getSideR()
   {
       return right;
   }
   
}
