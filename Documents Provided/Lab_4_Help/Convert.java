// Program converts temperatures.
import Lab_4.ConvertFrame;

import javax.swing.JFrame;

public class Convert 
{
   public static void main(String[] args)
   {
      ConvertFrame convertFrame = new ConvertFrame();
      convertFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      convertFrame.setSize(320, 220); // set frame size
      convertFrame.setVisible(true); // display frame
   }
} // end class Convert
