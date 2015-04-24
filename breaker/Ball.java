import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Ellipse2D.Double;
import java.awt.geom.*;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Color;
import java.util.ArrayList;

public class Ball
{
    private Ellipse2D.Double ball;
    private int x = 500;
    private int y = 400;
    private double XVel = 2;
    private double YVel = 2;
    
    private double ballSize = 20;
    public Ball()
    {
        ball = new Ellipse2D.Double(x, y, ballSize, ballSize);
    }

    public void draw(Graphics2D g2)
    {
        x += XVel;
        y += YVel;
        ball.setFrame(x, y, ballSize, ballSize);
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
    
    public void revX()
    {
        XVel *= -1;
    }
    
    public void revY()
    {
        YVel *= -1;
    }
    
    public double getHeight()
    {
        return ball.getHeight();
    }
    
    public double getWidth()
    {
        return ball.getWidth();
    }
    
    public void setX(double newX)
    {
        ball.setFrame(newX, this.y, ballSize, ballSize);
    }
    
    public void setY(double newY)
    {
        ball.setFrame(this.x, newY, ballSize, ballSize);
    }
    
    public void setSpeedY(double YVel)
    {
        this.YVel = YVel;
    }
    
    public void setSpeedX(double XVel)
    {
        this.XVel = XVel;
    }
    
    public double getSpeedY()
    {
        return YVel;
    }
    
    public double getSpeedX()
    {
        return XVel;
    }
}

