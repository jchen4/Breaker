import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.event.*;
import java.awt.geom.*;

public class BreakerComponent extends JPanel
{
    private Board board = new Board();
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        board.draw(g2);
    }
    
    public void updateBoardLocation(int x)
    {
        board.updateLocation(x);
        repaint();
    }
}