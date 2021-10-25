import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class GameFrame
{

  public static void main(String[] args)
  {
    // schedule this for the event dispatch thread (edt)
    SwingUtilities.invokeLater(new Runnable()
    {
      public void run()
      {
        displayJFrame();
      }
    });
  }

  static void displayJFrame()
  {
    // set the jframe title in the constructor
    JFrame jframe = new JFrame("Assesment");

    // all the other jframe setup stuff
    jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    jframe.setPreferredSize(new Dimension(1500, 900));
    jframe.pack();
    jframe.setLocationRelativeTo(null);
    jframe.setVisible(true);
  }

}