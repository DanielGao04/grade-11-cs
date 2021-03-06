/* ShootingExample
 * Desc: Demonstrates how to create and move "bullets"
 * @author ICS3U
 * @version Dec 2017
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.util.Arrays;

public class ShootingExample{ 
    // Game Window properties
    static JFrame gameWindow;
    static GraphicsPanel canvas;
    static final int WIDTH = 800;
    static final int HEIGHT = 600;
    // key listener
    static MyKeyListener keyListener = new MyKeyListener();    
    
    // ship properties
    static final int GROUND = 565;
    static final int RUN_SPEED = 10;
    static int shipW = 40;
    static int shipH = 60;
    static int shipX = WIDTH/2;
    static int shipY = GROUND - shipH;
    static int shipVx = 0;
    
    // bullets properties
    static int numBullets = 40;    
    static int[] bulletX = new int[numBullets];
    static int[] bulletY = new int[numBullets];
    static boolean[] bulletVisible = new boolean[numBullets];
    static int bulletW = 6;
    static int bulletH = 10;
    static int bulletSpeed = -10;
    static int currentBullet = 0;
    
//------------------------------------------------------------------------------    
    public static void main(String[] args){
        gameWindow = new JFrame("Game Window");
        gameWindow.setSize(WIDTH,HEIGHT);
        gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        canvas = new GraphicsPanel();
        canvas.addKeyListener(keyListener);
        gameWindow.add(canvas); 
        
        // generate bullets
        Arrays.fill(bulletX,0);
        Arrays.fill(bulletY,0);
        Arrays.fill(bulletVisible,false);
        
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
        // move the bullets
            for (int i=0; i<numBullets; i++){
                if (bulletVisible[i]){
                    bulletY[i] = bulletY[i] + bulletSpeed;
                    if (bulletY[i]<0)
                        bulletVisible[i] = false;
                }
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
        // draw the bullets
            g.setColor(Color.red);
            for (int i=0; i<numBullets; i++){
                if (bulletVisible[i])
                    g.fillOval(bulletX[i],bulletY[i],bulletW,bulletH);
            }
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
            } else if (key == KeyEvent.VK_SPACE){
                // assign the coordinates of the top middle point of the ship to the current bullet
                bulletX[currentBullet] = shipX + shipW/2 - bulletW/2;
                bulletY[currentBullet] = shipY;
                bulletVisible[currentBullet] = true;
                currentBullet = (currentBullet + 1)%numBullets;
            } else{
                shipVx = 0;
            }  
        }
        public void keyReleased(KeyEvent e){ 
        }   
        public void keyTyped(KeyEvent e){
        }           
    } // MyKeyListener class end    
    
} // ShootingExample class end