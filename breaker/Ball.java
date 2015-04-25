import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.*;
import java.awt.Color;

public class Ball
{
    private Ellipse2D.Double ball;
    //x and y values of ball
    private double x = 500;
    private double y = 400;
    //x and y velocities of ball
    private double XVel = 2;
    private double YVel = 2;
    //diameter of ball
    private double ballSize = 20;
    public Ball()
    {
        ball = new Ellipse2D.Double(x, y, ballSize, ballSize);
    }

    /*
     * Draws red ball and updates location based on velocity
     * 
     * @param   g2  graphics object
     */
    public void draw(Graphics2D g2)
    {
        x += XVel;
        y += YVel;
        ball.setFrame(x, y, ballSize, ballSize);
        g2.setColor(Color.RED);
        g2.fill(ball);
        g2.draw(ball);
    }
    
    /*
     * Gets rectangle bounds of ball
     * 
     * @return  bounds of ball
     */
    public Rectangle2D getBounds()
    {
        return ball.getBounds2D();
    }

    /*
     * Gets ball x position
     * 
     * @return  ball x position
     */
    public double getX()
    {
        return ball.getX();
    }

    /*
     * Gets ball y position
     * 
     * @return  ball y position
     */
    public double getY()
    {
        return ball.getY();
    }
    
    /*
     * reverses ball x velocity
     */
    public void revX()
    {
        XVel *= -1.0;
    }
    
    /*
     * reverses ball y velocity
     */
    public void revY()
    {
        YVel *= -1.0;
    }
    
    /*
     * Gets ball y position
     * 
     * @return  ball y position
     */
    public double getWidth()
    {
        return ball.getWidth();
    }
    
    /*
     * Sets ball x value 
     * 
     * @param   desired new x value
     */
    public void setX(double newX)
    {
        x = newX;
    }
    
    /*
     * Sets ball y value 
     * 
     * @param   desired new y value
     */
    public void setY(double newY)
    {
        y = newY;
    }
    
    /*
     * Sets y velocity
     * 
     * @param   desired new y velocity
     */
    public void setSpeedY(double YVel)
    {
        this.YVel = YVel;
    }
    
    /*
     * Sets x velocity
     * 
     * @param   desired new x velocity
     */
    public void setSpeedX(double XVel)
    {
        this.XVel = XVel;
    }
    
}

