import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.*;
import java.awt.geom.*;
import java.awt.Color;

public class Board
{
    private Rectangle2D.Double rect;
    public Board()
    {
        rect = new Rectangle2D.Double(200, 700, 200, 25);
    }
    
    /*
     * Draws yellow board
     * 
     * @param   graphics object
     */
    public void draw(Graphics2D g2)
    {
        g2.setColor(Color.YELLOW);
        g2.fill(rect);
        g2.draw(rect);
    }
    
    /*
     * Moves rectangle to x position
     * 
     * @param   x position to set to
     */
    public void updateLocation(int x)
    {
        rect.setRect(x - rect.getWidth()/2, 700, 200, 25);
    }
    
    /*
     * gets board x position
     * 
     * @return  x position
     */
    public double getX()
    {
        return rect.getX();
    }
    
    /*
     * gets board y position
     * 
     * @return  y position
     */
    public double getY()
    {
        return rect.getY();
    }
    
    /*
     * Gets board bounds
     * 
     * @return  board bounds as rectangle2D
     */
    public Rectangle2D getBounds()
    {
        return rect.getBounds();
    }
    
    /*
     * gets length of board
     * 
     * @return length of board
     */
    public double getLength()
    {
        return rect.getWidth();
    }
    
}
