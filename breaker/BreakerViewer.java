import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * Write a description of class BreakerViewer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BreakerViewer
{
    public static void main(String[] args)
    {
        BreakerFrame frame = new BreakerFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        while(true)
        {
            if(frame.checkBoardCollision() == true)
            {
                frame.updateBallVelocity();
            }
            frame.repaint();
        }
    }
}
