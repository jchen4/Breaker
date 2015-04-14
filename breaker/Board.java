import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.event.*;
import java.awt.geom.*;

public class Board
{
    private Rectangle2D.Double rect;
    public Board()
    {
        rect = new Rectangle2D.Double(500, 850, 200, 25);
    }
    
    public void draw(Graphics2D g2)
    {
        g2.draw(rect);
    }
    
    public void updateLocation(int x)
    {
        rect.setRect(x - rect.getWidth()/2, 850, 200, 25);
        
    }
}
