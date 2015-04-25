import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.event.*;
import java.awt.geom.*;
import java.util.ArrayList;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import javax.swing.KeyStroke;
import javax.swing.JOptionPane; 

public class BreakerComponent extends JPanel
{
    private Board board = new Board();
    private Ball ball = new Ball();
    private final double BX = 100;
    private final double BY = 50;
    private Brick[][] brickList = new Brick[9][3];
    
    
    public BreakerComponent()
    {
        //initializes brick array
        int ctY = 0;
        int ctX = 0;
        for (int x = 200; x < 1080; x += BX)
        {
            for (int y = 150; y < 300; y += BY)
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
        int bounce = 0;
        
        //draws all bricks
        for (int i = 0; i < brickList.length; i++)
        {
            for (int j = 0; j < brickList[0].length; j++)
            {
                if (brickList[i][j] != null)
                {
                    brickList[i][j].draw(g2);
                }
            }
        }
        
        
        //check for brick and side collision, reverse velocity accordingly
        loop:
        for (int i = 0; i < brickList.length; i++)
        {
            for (int j = 0; j < brickList[0].length; j++)
            {
                if(brickList[i][j] != null)
                if (ball.getX() + 50 >= 1280)
                {
                    ball.setX(1250);
                    ball.revX();
                    break loop;
                }
                else if(ball.getX() < 0 )
                {
                    ball.setX(5);
                    ball.revX();
                    break loop;
                }
                else if(ball.getBounds().intersectsLine(brickList[i][j].getSideR())
                || ball.getBounds().intersectsLine(brickList[i][j].getSideT()))
                {
                    ball.revX();
                    brickList[i][j] = null;
                    break loop;
                }
                else if(ball.getY() < 0) //top
                {
                    ball.setY(5);
                    ball.revY();
                    break loop;
                }
                else if(ball.getBounds().intersectsLine(brickList[i][j].getSideL()) 
                ||ball.getBounds().intersectsLine(brickList[i][j].getSideB()))  
                {
                    ball.revY();
                    brickList[i][j] = null;
                    break loop;
                }
            }
        }
        
        //check board collision, bounce angle based on distance of ball from middle of paddle
        if(ball.getBounds().intersects(board.getBounds()))  
        {
            double boardLengthHalf = (board.getX()+board.getLength()/2);
            double boardLengthRatio = (boardLengthHalf-(ball.getX()+ball.getWidth()/2)) / (board.getLength()/2);
            double VX = Math.sqrt(8) * Math.sin(Math.PI/6*boardLengthRatio);
            double VY = Math.sqrt(8) * -Math.cos(Math.PI/6*boardLengthRatio);
            ball.setSpeedX(VX);
            ball.setSpeedY(VY);
            ball.revX();
        }
        
        board.draw(g2);
        ball.draw(g2);
    }

    public void updateBoardLocation(int x)
    {
        board.updateLocation(x);
        repaint();
    }
    
    public boolean getWin()
    {
        int win = 0; //checks if entire array of bricks is empty
        for (int i = 0; i < brickList.length; i++)
        {
            for (int j = 0; j < brickList[0].length; j++)
            {
                if (brickList[i][j] != null)
                {
                    win++;
                }
            }
        }
        return win == 0;
    }
    
   
    
}