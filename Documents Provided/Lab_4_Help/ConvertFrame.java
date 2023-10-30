package Lab_4_Help;
// Program converts temperatures.
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class ConvertFrame extends JFrame
{
   private JPanel fromJPanel;
   private JPanel toJPanel;
   private JLabel label1;
   private JLabel label2;
   private JLabel label3;
   private JLabel label4;
   private JTextField tempJTextField1;
   private JTextField tempJTextField2;
   private ButtonGroup fromButtonGroup;
   private ButtonGroup toButtonGroup;
   private JRadioButton celsiusToJRadioButton;
   private JRadioButton fahrenheitToJRadioButton;
   private JRadioButton kelvinToJRadioButton;
   private JRadioButton celsiusFromJRadioButton;
   private JRadioButton fahrenheitFromJRadioButton;
   private JRadioButton kelvinFromJRadioButton;


   // constructor sets up GUI
   public ConvertFrame()
   {
      super("Temperature Conversion");
      //menu starts here
      JMenu fileMenu = new JMenu("File");
      fileMenu.setMnemonic('F');
      JMenuItem convertItem = new JMenuItem("Convert");
      convertItem.setMnemonic('C');
      JMenuItem exitItem = new JMenuItem("Exit");
      exitItem.setMnemonic('x');
      fileMenu.add(convertItem);
      MyEventHandler covertItemHandler = new MyEventHandler();
      convertItem.addActionListener(covertItemHandler);

      fileMenu.add(exitItem);
      exitItem.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            System.exit(0);
         }
      });

      JMenuBar bar = new JMenuBar();
      bar.add(fileMenu);
      setJMenuBar(bar);
      //Menu ends here

      // create ButtonGroup for from JRadioButtons
      fahrenheitFromJRadioButton = 
         new JRadioButton("Fahrenheit", true);
      celsiusFromJRadioButton = new JRadioButton("Celsius", false);
      kelvinFromJRadioButton = new JRadioButton("Kelvin",   false);
      fromButtonGroup = new ButtonGroup();
      fromButtonGroup.add(fahrenheitFromJRadioButton);
      fromButtonGroup.add(celsiusFromJRadioButton);
      fromButtonGroup.add(kelvinFromJRadioButton);

      // create ButtonGroup for to JRadioButtons
      fahrenheitToJRadioButton = 
         new JRadioButton("Fahrenheit", false);
      celsiusToJRadioButton = new JRadioButton("Celsius", true);
      kelvinToJRadioButton = new JRadioButton("Kelvin", false);
      toButtonGroup = new ButtonGroup();
      toButtonGroup.add(fahrenheitToJRadioButton);
      toButtonGroup.add(celsiusToJRadioButton);
      toButtonGroup.add(kelvinToJRadioButton);

      // create from JPanel
      fromJPanel = new JPanel();
      fromJPanel.setLayout(new GridLayout(1, 3));
      fromJPanel.add(fahrenheitFromJRadioButton);
      fromJPanel.add(celsiusFromJRadioButton);
      fromJPanel.add(kelvinFromJRadioButton);

      // create to JPanel
      toJPanel = new JPanel();
      toJPanel.setLayout(new GridLayout(1, 3));
      toJPanel.add(fahrenheitToJRadioButton);
      toJPanel.add(celsiusToJRadioButton);
      toJPanel.add(kelvinToJRadioButton);

      // create labels
      label1 = new JLabel("Convert from:");
      label2 = new JLabel("Convert to:");
      label3 = new JLabel("Enter Numeric Temperature: ");
      label4 = new JLabel("Comparable Temperature is: ");

      // create JTextField for getting temperature to be converted 
      tempJTextField1 = new JTextField(10);
      tempJTextField1.setText("0");

      // event handling using inner class (Style 1)
      MyEventHandler handler = new MyEventHandler();//create object
      tempJTextField1.addActionListener(handler);//register ActionEvent to text field

      // JTextField to display temperature after conversion
      tempJTextField2 = new JTextField(10);
      tempJTextField2.setEditable(false);

      // add components to GUI
      setLayout(new GridLayout(8, 1));
      add(label1);
      add(fromJPanel);
      add(label3);
      add(tempJTextField1);
      add(label2);
      add(toJPanel);
      add(label4);
      add(tempJTextField2);
   }

   //inner class
   private class MyEventHandler implements ActionListener{

      @Override
      public void actionPerformed(ActionEvent event) {
         int convertTemp =0 , temp;
         String result = ""; // for Pop up window

         //getting the value from the text field
         temp = Integer.parseInt(tempJTextField1.getText());

         // Fahrenheit to Celsius
         if (fahrenheitFromJRadioButton.isSelected() &&
                 celsiusToJRadioButton.isSelected())
         {
            convertTemp = (int) (5.0f / 9.0f * (temp - 32));
            tempJTextField2.setText(
                    String.valueOf(convertTemp));
            result = "fahrenheit to celsius";
         }
         // Fahrenheit to Kelvin
         else if (fahrenheitFromJRadioButton.isSelected() &&
                 kelvinToJRadioButton.isSelected())
         {
            convertTemp = (int)
                    (5.0f / 9.0f * (temp - 32) + 273.15);
            tempJTextField2.setText(
                    String.valueOf(convertTemp));
            result = "fahrenheit to kelvin";
         }
         // Celsius to Fahrenheit
         else if (celsiusFromJRadioButton.isSelected() &&
                 fahrenheitToJRadioButton.isSelected())
         {
            convertTemp = (int) (9.0f / 5.0f * temp + 32);
            tempJTextField2.setText(
                    String.valueOf(convertTemp));
            result = "celsius to fahrenheit";
         }
         // Celsius to Kelvin
         else if (celsiusFromJRadioButton.isSelected() &&
                 kelvinToJRadioButton.isSelected())
         {
            convertTemp = (int) (temp + 273.15);
            tempJTextField2.setText(
                    String.valueOf(convertTemp));
            result = "celsius to kelvin";
         }
         // Kelvin to Celsius
         else if (kelvinFromJRadioButton.isSelected() &&
                 celsiusToJRadioButton.isSelected())
         {
            convertTemp = (int) (temp - 273.15);
            tempJTextField2.setText(
                    String.valueOf(convertTemp));
            result = "kelvin to celsius";
         }
         // Kelvin to Fahrenheit
         else if (kelvinFromJRadioButton.isSelected() &&
                 fahrenheitToJRadioButton.isSelected())
         {
            convertTemp =
                    (int) (9.0f / 5.0f * (temp - 273.15) + 32);
            tempJTextField2.setText(
                    String.valueOf(convertTemp));
            result = "kelvin to fahrenheit";
         }
         // source and destination are the same; just copy value
         else {
            tempJTextField2.setText(String.valueOf(temp));
            result = "No conversion selected";
         }

          result += "\n"+ temp + "  to \t\t  " + convertTemp + "";

         JOptionPane.showMessageDialog(ConvertFrame.this,result,"Converted Temperature",JOptionPane.INFORMATION_MESSAGE);
      } // end method actionPerformed
   }//end of inner class
} // end class ConvertFrame
