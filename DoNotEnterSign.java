/* BouncingBall
 * Desc: Draws a moving ball that bounces from the edges
 * @author ICS3U
 * @version Dec 2017
 */
import javax.swing.*;
import java.awt.*;

public class BouncingBall{ 
    // Game Window properties
    static JFrame gameWindow;
    static GraphicsPanel canvas;
    static final int WIDTH = 800;
    static final int HEIGHT = 600;    
    
    // ball properties
    static int ballX = 0;
    static int ballY = HEIGHT/2;
    static int ballD = 50;
    static int stepX = 5;
    static int stepY = 5;

//------------------------------------------------------------------------------    
    public static void main(String[] args) {
        gameWindow = new JFrame("Game Window");
        gameWindow.setSize(WIDTH,HEIGHT);
        gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        canvas = new GraphicsPanel();
        gameWindow.add(canvas); 
        
        gameWindow.setVisible(true);
        runGameLoop();
        
    } // main method end

//------------------------------------------------------------------------------   
    public static void runGameLoop(){
        while (true) {
            gameWindow.repaint();
            try  {Thread.sleep(20);} catch(Exception e){} 
            
        // Move the ball
            if (ballX+ballD+stepX>WIDTH || ballX+stepX<0)
                stepX = -stepX;
            if (ballY+ballD+stepY>HEIGHT || ballY+stepY<0)
                stepY = -stepY;
            ballX = ballX+stepX;
            ballY = ballY+stepY;
        }
    } // runGameLoop method end
    
//------------------------------------------------------------------------------  
    static class GraphicsPanel extends JPanel {
        public void paintComponent(Graphics g) { 
            super.paintComponent(g); //required
            g.setColor(Color.red);
            g.fillOval(ballX,ballY,ballD,ballD);
            // do all your drawings here        
            
        } // paintComponent method end
    } // GraphicsPanel class end
    
} // BouncingBall class end