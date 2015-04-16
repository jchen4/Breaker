import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Ellipse2D.Double;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Color;

public class Ball
{
    private Ellipse2D.Double ball;
    private int angle;
    private int x = 500;
    private int y = 500;
    public Ball()
    {
        ball = new Ellipse2D.Double(x, y, 50, 50);
        angle = 1;
    }
    
    public void draw(Graphics2D g2)
    {
        if(angle % 4 == 1)
        {
            x += 3;
            y += 3;
            ball.setFrame(x, y, 50, 50);
        }
        
        g2.draw(ball);
    }
    
    public Rectangle2D getBounds()
    {
        return ball.getBounds2D();
    }
}
