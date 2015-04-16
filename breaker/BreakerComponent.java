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
        if(ball.getBounds().intersects(board.getBounds()))
        {
            return true;
        }
        if(ball.getBounds().intersects
        
        return false;
    }
}