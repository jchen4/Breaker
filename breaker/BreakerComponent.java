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
    private Brick[][] brickList = new Brick[20][5];
    public BreakerComponent()
    {
        //initializes brick array
        int ctY = 0;
        int ctX = 0;
        for (int x = 140; x < 1140; x += 50)
        {
            for (int y = 140; y < 240; y += 20)
            {
                brickList[ctX][ctY] = new Brick(x, y);
                ctY += 1;
            }
            ctY = 0;
            ctX += 1;
        }
    }
    
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        for (int i = 0; i < brickList.length; i++)
        {
            for (int j = 0; j < brickList[0].length; j++)
            {
                brickList[i][j].draw(g2);
            }
        }
        board.draw(g2);
        ball.draw(g2, board.getX(), board.getY());
        
    }
    
    public void updateBoardLocation(int x)
    {
        board.updateLocation(x);
        repaint();
    }
}