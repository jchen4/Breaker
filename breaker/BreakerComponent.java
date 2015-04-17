import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.event.*;
import java.awt.geom.*;

public class BreakerComponent extends JPanel
{
    private Board board = new Board();
    private Ball ball = new Ball();
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        board.draw(g2);
        ball.draw(g2);
    }
    
    public void updateBoardLocation(int x)
    {
        board.updateLocation(x);
        repaint();
    }
    
    public boolean checkBoardCollision()
    {
        double boardX = board.getX();
        double boardY = board.getY();
        double ballX = ball.getX();
        double ballY = ball.getY();
        if(ball.getBounds().intersectsLine(boardX, boardY, boardX + 200, boardY))
        {
            return true;
        }
        if(ball.getBounds().intersectsLine(0, 0, 1678, 0) ||
            ball.getBounds().intersectsLine(0, 0, 0, 1048) || 
            ball.getBounds().intersectsLine(1678, 0, 1678, 1048))
        {
            return true;
        }
        
        return false;
    }
    
    public void updateBallVelocity()
    {
        ball.updateVelocity();
    }
}