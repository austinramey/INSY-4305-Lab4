package Lab_4;

import java.awt.*;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class ConvertFrame extends JFrame
{
    private final JRadioButton dollarRadioButtonFrom;
    private final JRadioButton pesoRadioButtonFrom;
    private final JRadioButton euroRadioButtonFrom;
    private final JRadioButton dollarRadioButtonTo;
    private final JRadioButton pesoRadioButtonTo;
    private final JRadioButton euroRadioButtonTo;
    private final JTextField userJTextField;
    private final JTextField convertedJTextField;
    final JLabel convertFrom;
    final JLabel enterCurrency;
    final JLabel convertTo;
    final JLabel comparableCurrency;

    public ConvertFrame() 
    {
        // Sets title of application
        super("Currency Conversion");

        // Creates Menu Bar Items
        JMenu fileMenu = new JMenu("File");
        fileMenu.setMnemonic('F');
        JMenuItem convertItem = new JMenuItem("Convert");
        convertItem.setMnemonic('C');
        JMenuItem aboutItem = new JMenuItem("About");
        aboutItem.setMnemonic('a');
        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.setMnemonic('e');
        JMenuItem clearItem = new JMenuItem("Clear");
        clearItem.setMnemonic('c');


        // Adds all items to menu
        fileMenu.add(convertItem);
        fileMenu.add(clearItem);
        fileMenu.add(aboutItem);
        fileMenu.add(exitItem);

        // Setup exit action
        exitItem.addActionListener(new ExitHandler());
        convertItem.addActionListener(new ConversionHandler());
        aboutItem.addActionListener(new AboutHandler());
        clearItem.addActionListener(new ClearHandler());

        // Initializes actual Menu Bar
        JMenuBar bar = new JMenuBar();
        bar.add(fileMenu);
        setJMenuBar(bar);

        // Icon group above from
        JPanel fromIconJPanel = new JPanel();
        fromIconJPanel.setLayout(new GridLayout(1, 3));
        JLabel dollarFromImage = new JLabel();
        dollarFromImage.setIcon(new ImageIcon("Lab_4/dollar.jpg"));
        JLabel pesoFromImage = new JLabel();
        pesoFromImage.setIcon(new ImageIcon("Lab_4/peso.jpg"));
        JLabel euroFromImage = new JLabel();
        euroFromImage.setIcon(new ImageIcon("Lab_4/euro.jpg"));
        fromIconJPanel.add(dollarFromImage);
        fromIconJPanel.add(pesoFromImage);
        fromIconJPanel.add(euroFromImage);

        // Button group for from selection
        dollarRadioButtonFrom = new JRadioButton("Dollar", true);
        pesoRadioButtonFrom = new JRadioButton("Peso", false);
        euroRadioButtonFrom = new JRadioButton("Euro", false);
        ButtonGroup fromButtonGroup = new ButtonGroup();
        fromButtonGroup.add(dollarRadioButtonFrom);
        fromButtonGroup.add(pesoRadioButtonFrom);
        fromButtonGroup.add(euroRadioButtonFrom);

        // Icon group above to
        JPanel toIconJPanel = new JPanel();
        toIconJPanel.setLayout(new GridLayout(1,3));
        JLabel dollarToImage = new JLabel();
        dollarToImage.setIcon(new ImageIcon("Lab_4/dollar.jpg"));
        JLabel pesoToImage = new JLabel();
        pesoToImage.setIcon(new ImageIcon("Lab_4/peso.jpg"));
        JLabel euroToImage = new JLabel();
        euroToImage.setIcon(new ImageIcon("Lab_4/euro.jpg"));
        toIconJPanel.add(dollarToImage);
        toIconJPanel.add(pesoToImage);
        toIconJPanel.add(euroToImage);

        //Button group for to selection
        dollarRadioButtonTo = new JRadioButton("Dollar", true);
        pesoRadioButtonTo = new JRadioButton("Peso", false);
        euroRadioButtonTo = new JRadioButton("Euro", false);
        ButtonGroup toButtonGroup = new ButtonGroup();
        toButtonGroup.add(dollarRadioButtonTo);
        toButtonGroup.add(pesoRadioButtonTo);
        toButtonGroup.add(euroRadioButtonTo);
        
        // create from JPanel
        JPanel fromJPanel = new JPanel();
        fromJPanel.setLayout(new GridLayout(1, 3));
        fromJPanel.add(dollarRadioButtonFrom);
        fromJPanel.add(pesoRadioButtonFrom);
        fromJPanel.add(euroRadioButtonFrom);

        // create to JPanel
        JPanel toJPanel = new JPanel();
        toJPanel.setLayout(new GridLayout(1, 3));
        toJPanel.add(dollarRadioButtonTo);
        toJPanel.add(pesoRadioButtonTo);
        toJPanel.add(euroRadioButtonTo);

        // Create labels
        convertFrom = new JLabel("Convert from: ");
        convertTo = new JLabel("Convert to: ");
        enterCurrency = new JLabel("Enter Currency: ");
        comparableCurrency = new JLabel("Comparable Currency is: ");

        // User entered text field
        userJTextField = new JTextField(10);
        userJTextField.setText("");

        // event handling
        ConversionHandler handler = new ConversionHandler();
        userJTextField.addActionListener(handler);

        // Field to display currency after conversion
        convertedJTextField = new JTextField(10);
        convertedJTextField.setBackground(Color.gray);
        convertedJTextField.setEditable(false);

        // Button Group of Convert, Clear and Exit
        JButton convertButton = new JButton("Convert");
        JButton clearButton = new JButton("Clear");
        JButton exitButton = new JButton("Exit");

        // Setup actions
        convertButton.addActionListener(new ConversionHandler());
        clearButton.addActionListener(new ClearHandler());
        exitButton.addActionListener(new ExitHandler());

        // Add button group to panel
        JPanel bottomButtonGroup = new JPanel();
        bottomButtonGroup.setLayout(new GridLayout(1,3));
        bottomButtonGroup.add(convertButton);
        bottomButtonGroup.add(clearButton);
        bottomButtonGroup.add(exitButton);

        // Add components to GUI
        setLayout(new GridLayout(11, 1));
        add(convertFrom);
        add(fromIconJPanel);
        add(fromJPanel);
        add(userJTextField);
        add(toIconJPanel);
        add(toJPanel);
        add(convertedJTextField);
        add(bottomButtonGroup);
    }

    private class ConversionHandler implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent event) {
            double convertCurr = 0.0;
            int userCurr;
            String result = "";

            userCurr = Integer.parseInt(userJTextField.getText());

            // Dollar to Dollar
            if(dollarRadioButtonFrom.isSelected() && 
            dollarRadioButtonTo.isSelected()){
                convertCurr = userCurr;
                convertCurr = round(convertCurr, 2);
                result = "dollar to dollar";
            } 
            
            // Dollar to Peso
            else if (dollarRadioButtonFrom.isSelected() && 
            pesoRadioButtonTo.isSelected()){
                convertCurr = userCurr * 17.64;
                convertCurr = round(convertCurr, 2);
                result = "dollar to peso";
            }

            // Dollar to euro
            else if (dollarRadioButtonFrom.isSelected() &&
            euroRadioButtonTo.isSelected()){
                convertCurr = userCurr * 0.94;
                convertCurr = round(convertCurr, 2);
                result = "dollar to euro";
            }

            // Peso to dollar
            else if (pesoRadioButtonFrom.isSelected() && 
            dollarRadioButtonTo.isSelected()){
                convertCurr = userCurr * 0.057;
                convertCurr = round(convertCurr, 2);
                result = "peso to dollar";
            }

            // Peso to peso
            else if (pesoRadioButtonFrom.isSelected() &&
            pesoRadioButtonTo.isSelected()){
                convertCurr = userCurr;
                convertCurr = round(convertCurr, 2);
                result = "peso to peso";

            }

            // Peso to euro
            else if (pesoRadioButtonFrom.isSelected() && 
            euroRadioButtonTo.isSelected()){
                convertCurr = userCurr * 0.053;
                convertCurr = round(convertCurr, 2);
                result = "peso to euro";
            }

            // Euro to Dollar
            else if (euroRadioButtonFrom.isSelected() && 
            dollarRadioButtonTo.isSelected()){
                convertCurr = userCurr * 1.068;
                convertCurr = round(convertCurr, 2);
                result = "euro to dollar";
            }

            // Euro to Peso
            else if (euroRadioButtonFrom.isSelected() && 
            pesoRadioButtonTo.isSelected()){
                convertCurr = userCurr * 18.854;
                convertCurr = round(convertCurr, 2);
                result = "euro to peso";
            }

            // Euro to Euro
            else if (euroRadioButtonFrom.isSelected() && 
            euroRadioButtonTo.isSelected()){
                convertCurr = userCurr;
                convertCurr = round(convertCurr, 2);
                result = "euro to euro";
            }

            convertedJTextField.setText(String.valueOf(convertCurr));
            convertedJTextField.setBackground(Color.green);
            result += "\n" + userCurr + "  to \t\t  " + convertCurr + " ";
            JOptionPane.showMessageDialog(ConvertFrame.this, result, "Converted Currency", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private class ClearHandler implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent event){
            userJTextField.setText("");
            convertedJTextField.setText("");
            convertedJTextField.setBackground(Color.gray);
        }
    }

    private static class ExitHandler implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent event){
            // Initialize JFrame
            JFrame messageFrame = new JFrame();
            messageFrame.setTitle("Exit dialog");
            messageFrame.setLayout(new GridLayout(2,2));

            // Create JLabels for image and text
            JLabel innerImageLabel = new JLabel();
            ImageIcon logoutImage = new ImageIcon("Lab_4/user-login-305.png");
            innerImageLabel.setIcon(logoutImage);
            JLabel innerTextLabel = new JLabel("Are you sure?");

            // Creating buttons
            JButton yesButton = new JButton("Yes");
            JButton noButton = new JButton("No");

            // Button Actions
            yesButton.addActionListener(e -> System.exit(0));
            noButton.addActionListener(e -> messageFrame.setVisible(false));

            // Creating button panels
            JPanel yesPanel = new JPanel();
            yesPanel.add(yesButton);
            JPanel noPanel = new JPanel();
            yesPanel.add(noButton);

            // Adding components
            messageFrame.add(innerImageLabel);
            messageFrame.add(innerTextLabel);
            messageFrame.add(yesPanel);
            messageFrame.add(noPanel);
            messageFrame.setVisible(true);
            messageFrame.setSize(300,200);
        }
    }

    private class AboutHandler implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent event){
            String message = """
                    Currency Conversion Program
                    using menus and buttons
                    source: https://www.oanda.com/currency-converter/""";
            JOptionPane.showMessageDialog(ConvertFrame.this, message, "About Program", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static double round(double value, int places){
        if(places < 0) throw new IllegalArgumentException();

        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(places, RoundingMode.HALF_DOWN);
        return bd.doubleValue();
    }
}