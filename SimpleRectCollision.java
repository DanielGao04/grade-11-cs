/* SimpleRectCollision
 * Desc: Demonstrates how to detect collision using java.awt.Rectangle class
 * @author ICS3U
 * @version May 2018
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SimpleRectCollision{ 
    // Game Window properties
    static JFrame gameWindow;
    static GraphicsPanel canvas;
    static final int WIDTH = 800;
    static final int HEIGHT = 600;
    // key listener
    static MyKeyListener keyListener = new MyKeyListener();    

    static final int GROUND = 565;
    static final int RUN_SPEED = 10;
    
    // ship properties
    static int shipW = 40;
    static int shipH = 60;
    static int shipX = 3*WIDTH/4;
    static int shipY = GROUND - shipH;
    static int shipVx = 0;
    static Rectangle shipBox = new Rectangle(shipX, shipY, shipW, shipH);
    
    // obstacle properties
    static int obstacleW = 40;
    static int obstacleH = 60;
    static int obstacleX = WIDTH/4;
    static int obstacleY = GROUND - obstacleH;
    static Rectangle obstacleBox = new Rectangle(obstacleX, obstacleY, obstacleW, obstacleH);    
    
//------------------------------------------------------------------------------    
    public static void main(String[] args){
        gameWindow = new JFrame("Game Window");
        gameWindow.setSize(WIDTH,HEIGHT);
        gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        canvas = new GraphicsPanel();
        canvas.addKeyListener(keyListener);
        gameWindow.add(canvas); 
        
        gameWindow.setVisible(true);
        runGameLoop();
        
    } // main method end
    
//------------------------------------------------------------------------------   
    public static void runGameLoop(){
        while (true) {
            gameWindow.repaint();
            try  {Thread.sleep(20);} catch(Exception e){}
        // move the ship
            shipX = shipX + shipVx;
            shipBox.setLocation(shipX,shipY);
        // check for collision
            if (shipBox.intersects(obstacleBox)){
                System.out.println("Collision!\n");
                // bounce the ship if it collided with the obstacle
                shipVx = -shipVx;
            }
        }
    } // runGameLoop method end
    
//------------------------------------------------------------------------------  
    static class GraphicsPanel extends JPanel{
        public GraphicsPanel(){
            setFocusable(true);
            requestFocusInWindow();
        }
        public void paintComponent(Graphics g){ 
            super.paintComponent(g); //required
        // draw the ship    
            g.setColor(Color.blue);
            g.fillRect(shipX,shipY,shipW,shipH);
        // draw the obstacle
            g.setColor(Color.red);
            g.fillRect(obstacleX,obstacleY,obstacleW,obstacleH);
        } // paintComponent method end 
    } // GraphicsPanel class end
    
//------------------------------------------------------------------------------     
    static class MyKeyListener implements KeyListener{   
        public void keyPressed(KeyEvent e){
            int key = e.getKeyCode();
            if (key == KeyEvent.VK_LEFT){
                shipVx = -RUN_SPEED;
            } else if (key == KeyEvent.VK_RIGHT){
                shipVx = RUN_SPEED;
            } else if (key == KeyEvent.VK_A){
                obstacleX = obstacleX -RUN_SPEED;
                obstacleBox.setLocation(obstacleX,obstacleY);
            } else if (key == KeyEvent.VK_D){
                obstacleX = obstacleX + RUN_SPEED;    
                obstacleBox.setLocation(obstacleX,obstacleY);
            } else{
                shipVx = 0;
            }  
        }
        public void keyReleased(KeyEvent e){ 
        }   
        public void keyTyped(KeyEvent e){
        }           
    } // MyKeyListener class end   
    
} // SimpleRectCollision class end