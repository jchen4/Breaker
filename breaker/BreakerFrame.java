import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class BreakerFrame extends JFrame
{
    private Board board;
    
    public class MotionListener implements MouseMotionListener
    {
        public void mouseMoved(MouseEvent event)
        {
            int x = event.getX();
            int y = event.getY();
            board.updateLocation(x, y);
        }
        
        public void mouseDragged(MouseEvent event){}
    }
    
    public BreakerFrame()
    {
        board = new Board();
        this.setSize(1680, 1050);
        this.add(board);
        MouseMotionListener listener = new MotionListener();
        board.addMouseMotionListener(listener);
    }

}
