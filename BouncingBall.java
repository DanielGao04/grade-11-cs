/* BasicAnimation
 * Desc: Demonstrates how to create basic animation - moving ball
 * @author ICS3U
 * @version Dec 2017
 */
import javax.swing.*;
import java.awt.*;

public class BasicAnimation{ 
    // Game Window properties
    static JFrame gameWindow;
    static GraphicsPanel canvas;
    static final int WIDTH = 800;
    static final int HEIGHT = 600;
    
    // box properties
    static int boxX = 0;
    static int boxY = HEIGHT/2;
    static int boxW = 50;
    static int boxH = 50;
    static int step = 5;

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
    /* runGameLoop method
     * Executes the animation sequence (1.clear, 2.draw, 3.wait, 4.repeat)
     * Updates the objects on the game window, i.e. moves objects, etc.
     */
    public static void runGameLoop(){
        while (true) {
        // 1. and 2. Clear the game window and draw everything
            gameWindow.repaint();
            
        // 3. Wait enough time, so human eye can perceive the drawing
            try  {Thread.sleep(20);} catch(Exception e){} // pause the program for 20 mS

        // Move the objects
            if (boxX+boxW+step>WIDTH || boxX+step<0)
                step = -step;
            boxX = boxX+step;

        }// 4. Repeat
    } // runGameLoop method end
    
//------------------------------------------------------------------------------  
    static class GraphicsPanel extends JPanel {
        public void paintComponent(Graphics g) { 
            super.paintComponent(g); //required
            g.setColor(Color.blue);
            g.fillRect(boxX,boxY,boxW,boxH);
            // do all your drawings here      
            
        } // paintComponent method end
    } // GraphicsPanel class end
    
} // BasicAnimation class end