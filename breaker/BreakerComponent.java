import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.JOptionPane;

public class BreakerComponent extends JPanel
{
    private Board board = new Board();
    private Ball ball = new Ball();
    private Brick[][] brickList = new Brick[9][3];
    double BX = 100;
    double BY = 50;
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
    
    /*
     * draws all objects and chacks and handles collisions
     * 
     * @param   g   graphics object
     */
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
                if (ball.getX() + ball.getWidth()/2 >= 1260)
                {
                    ball.revX();
                    break loop;
                }
                else if(ball.getX() < 0 )
                {
                    ball.setX(1);
                    ball.revX();
                    break loop;
                }
                else if(ball.getBounds().intersectsLine(brickList[i][j].getSideL()))
                {
                    ball.revX();
                    brickList[i][j] = null;
                    break loop;
                }
                else if(ball.getY() < 0) //top
                {
                    ball.setY(1);
                    ball.revY();
                    break loop;
                }
                else if(ball.getBounds().intersectsLine(brickList[i][j].getSideB()) 
                ||ball.getBounds().intersectsLine(brickList[i][j].getSideR())
                || ball.getBounds().intersectsLine(brickList[i][j].getSideT()))  
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
            double VX = Math.sqrt(8) * Math.sin((5*Math.PI)/12*boardLengthRatio);
            double VY = Math.sqrt(8) * -Math.cos((5*Math.PI)/12*Math.abs(boardLengthRatio));
            if( VX < 0){VX -= 1;}
            System.out.println("VX = " + VX + " VY = " + VY);
            ball.setSpeedX(VX);
            ball.setSpeedY(VY);
            ball.revX();
        }
        
        board.draw(g2);
        ball.draw(g2);
    }

    /*
     * Tells board to update location
     * 
     * @param   x   board x location to move to
     */
    public void updateBoardLocation(int x)
    {
        board.updateLocation(x);
        repaint();
    }
    
    /*
     * Checks if game won or lost
     * 
     * @return  won or lost, 0 = neither, 1 = won, 2 = lost
     */
    public int getWin()
    {
        //check if ball is OOB under screen
        if(ball.getY()+ball.getWidth() >= 800){return 2;}
        //checks if entire array of bricks is empty
        for (int i = 0; i < brickList.length; i++)
        {
            for (int j = 0; j < brickList[0].length; j++)
            {
                if (brickList[i][j] != null)
                {
                    return 0;
                }
            }
        }
        return 1;
    }
    
   
    
}