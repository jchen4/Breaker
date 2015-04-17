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
    private int x = 350;
    private int y = 233;
    private int XVel = 1;
    private int YVel = 1;
    public Ball()
    {
        ball = new Ellipse2D.Double(x, y, 50, 50);
        angle = 1;
    }
    
    public void draw(Graphics2D g2)
    {
        x += XVel;
        y += YVel;
        ball.setFrame(x, y, 50, 50);
        g2.draw(ball);
    }
    
    public void updateVelocity()
    {
        if(XVel >= 0 && YVel >= 0)
        {
            YVel *= -1;
        }
        else if(XVel <= 0 && YVel <= 0)
        {
            XVel *= -1;
        }
        else if(XVel >= 0 && YVel <= 0)
        {
            XVel *= -1;
        }
        else if(XVel <= 0 && YVel >= 0)
        {
            YVel *= -1;
        }
    }
    
    public Rectangle2D getBounds()
    {
        return ball.getBounds2D();
    }
    
    public double getX()
    {
        return ball.getX();
    }
    
    public double getY()
    {
        return ball.getY();
    }
}
