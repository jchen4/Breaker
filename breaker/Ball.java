import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.event.*;
import java.awt.geom.*;

public class Ball extends JPanel
{
    private Rectangle2D.Double rect;
    public Ball()
    {
        rect = new Rectangle2D.Double(500, 500, 200, 25);
    }
    
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.draw(rect);
    }
    
    public void updateLocation(int x)
    {
        rect.setRect(x - rect.getWidth()/2, 500, 200, 25);
        repaint();
    }
}