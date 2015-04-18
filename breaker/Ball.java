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
    private int x = 350;
    private int y = 233;
    private double XVel = 2;
    private double YVel = 2;
    public Ball()
    {
        ball = new Ellipse2D.Double(x, y, 50, 50);
    }
    
    public void draw(Graphics2D g2, double boardX, double boardY)
    {
        
        if(ball.getBounds().intersectsLine(boardX, boardY, boardX + 200, boardY)) //board
        {
            YVel *= -1;
        }
        if(ball.getY() <= 0) //top
        {
            YVel *= -1;
        }
        if (ball.getX() <= 0)  //left
        {
            XVel *= -1;
        }
        if (ball.getX() + 50 >= 1280) //right
        {
            XVel *= -1;
        }
        x += XVel;
        y += YVel;
        ball.setFrame(x, y, 50, 50);
        g2.draw(ball);
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
