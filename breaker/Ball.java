import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.geom.Line2D.Double;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Color;

public class Ball
{
    private Elipse2D.Double ball;
    public Board()
    {
        ball = new Rectangle2D.Double(500, 850, 200, 25);
    }
    
    public void draw(Graphics2D g2)
    {
        g2.draw(ball);
    }
    
    public void updateLocation(int x)
    {
        rect.setRect(x - rect.getWidth()/2, 850, 200, 25);
        
    }
}
