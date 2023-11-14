import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class ConvertFrame extends JFrame
{
    private JRadioButton dollarRadioButtonFrom;
    private JRadioButton pesoRadioButtonFrom;
    private JRadioButton euroRadioButtonFrom;
    private ButtonGroup fromButtonGroup;
    private JPanel fromJPanel;
    private JRadioButton dollarRadioButtonTo;
    private JRadioButton pesoRadioButtonTo;
    private JRadioButton euroRadioButtonTo;
    private ButtonGroup toButtonGroup;
    private JPanel toJPanel;
    private JTextField userJTextField;
    private JTextField convertedJTextField;
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
        JMenu convertItem = new JMenu("Convert");
        convertItem.setMnemonic('C');
        JMenu aboutItem = new JMenu("About");
        aboutItem.setMnemonic('a');
        JMenu exitItem = new JMenu("Exit");
        exitItem.setMnemonic('e');
        
        // Adds all items to menu
        fileMenu.add(convertItem);
        fileMenu.add(aboutItem);
        fileMenu.add(exitItem);
        MyEventHandler convertItemHandler = new MyEventHandler();
        convertItem.addActionListener(convertItemHandler);

        // Setup exit action
        exitItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        // Initializes actual Menu Bar
        JMenuBar bar = new JMenuBar();
        bar.add(fileMenu);
        setJMenuBar(bar);

        // Icon group above from
        JPanel fromIconJPanel = new JPanel();
        fromIconJPanel.setLayout(new GridLayout(1, 3));
        JLabel dollarFromImage = new JLabel();
        dollarFromImage.setIcon(new ImageIcon("dollar.jpg"));
        JLabel pesoFromImage = new JLabel();
        pesoFromImage.setIcon(new ImageIcon("peso.jpg"));
        JLabel euroFromImage = new JLabel();
        euroFromImage.setIcon(new ImageIcon("euro.jpg"));
        fromIconJPanel.add(dollarFromImage);
        fromIconJPanel.add(pesoFromImage);
        fromIconJPanel.add(euroFromImage);

        // Button group for from selection
        dollarRadioButtonFrom = new JRadioButton("Dollar", true);
        pesoRadioButtonFrom = new JRadioButton("Peso", false);
        euroRadioButtonFrom = new JRadioButton("Euro", false);
        fromButtonGroup = new ButtonGroup();
        fromButtonGroup.add(dollarRadioButtonFrom);
        fromButtonGroup.add(pesoRadioButtonFrom);
        fromButtonGroup.add(euroRadioButtonFrom);

        // Icon group above to
        JPanel toIconJPanel = new JPanel();
        toIconJPanel.setLayout(new GridLayout(1,3));
        JLabel dollarToImage = new JLabel();
        dollarToImage.setIcon(new ImageIcon("dollar.jpg"));
        JLabel pesoToImage = new JLabel();
        pesoToImage.setIcon(new ImageIcon("peso.jpg"));
        JLabel euroToImage = new JLabel();
        euroToImage.setIcon(new ImageIcon("euro.jpg"));
        toIconJPanel.add(dollarToImage);
        toIconJPanel.add(pesoToImage);
        toIconJPanel.add(euroToImage);

        //Button group for to selection
        dollarRadioButtonTo = new JRadioButton("Dollar", true);
        pesoRadioButtonTo = new JRadioButton("Peso", false);
        euroRadioButtonTo = new JRadioButton("Euro", false);
        toButtonGroup = new ButtonGroup();
        toButtonGroup.add(dollarRadioButtonTo);
        toButtonGroup.add(pesoRadioButtonTo);
        toButtonGroup.add(euroRadioButtonTo);
        
        // create from JPanel
        fromJPanel = new JPanel();
        fromJPanel.setLayout(new GridLayout(1, 3));
        fromJPanel.add(dollarRadioButtonFrom);
        fromJPanel.add(pesoRadioButtonFrom);
        fromJPanel.add(euroRadioButtonFrom);

        // create to JPanel
        toJPanel = new JPanel();
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
        MyEventHandler handler = new MyEventHandler();
        userJTextField.addActionListener(handler);

        // Field to display currency after conversion
        convertedJTextField = new JTextField(10);
        convertedJTextField.setEditable(false);

        // Add components to GUI
        setLayout(new GridLayout(11, 1));
        add(convertFrom);
        add(fromIconJPanel);
        add(fromJPanel);
        add(userJTextField);
        add(toIconJPanel);
        add(toJPanel);
        add(convertedJTextField);
    }

    private class MyEventHandler implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent event) {
            double convertCurr = 0.0;
            int userCurr = 0;
            String result = "";

            userCurr = Integer.parseInt(userJTextField.getText());

            // Dollar to Dollar
            if(dollarRadioButtonFrom.isSelected() && 
            dollarRadioButtonTo.isSelected()){
                convertCurr = (double) (userCurr);
                convertCurr = round(convertCurr, 2);
                result = "dollar to dollar";
            } 
            
            // Dollar to Peso
            else if (dollarRadioButtonFrom.isSelected() && 
            pesoRadioButtonTo.isSelected()){
                convertCurr = userCurr * 17.62;
                convertCurr = round(convertCurr, 2);
                result = "dollar to peso";
            }

            // Dollar to euro
            else if (dollarRadioButtonFrom.isSelected() &&
            euroRadioButtonTo.isSelected()){
                convertCurr = userCurr * 0.93;
                convertCurr = round(convertCurr, 2);
                result = "dollar to euro";
            }

            // Peso to dollar
            else if (pesoRadioButtonFrom.isSelected() && 
            dollarRadioButtonTo.isSelected()){
                convertCurr = userCurr / 17.62;
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
                convertCurr = userCurr * 0.05;
                convertCurr = round(convertCurr, 2);
                result = "peso to euro";
            }

            // Euro to Dollar
            else if (euroRadioButtonFrom.isSelected() && 
            dollarRadioButtonTo.isSelected()){
                convertCurr = userCurr / 0.93;
                convertCurr = round(convertCurr, 2);
                result = "euro to dollar";
            }

            // Euro to Peso
            else if (euroRadioButtonFrom.isSelected() && 
            pesoRadioButtonTo.isSelected()){
                convertCurr = userCurr / 0.05;
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
            result += "\n" + userCurr + "  to \t\t  " + convertCurr + "";
            JOptionPane.showMessageDialog(ConvertFrame.this, result, "Converted Currency", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static double round(double value, int places){
        if(places < 0) throw new IllegalArgumentException();

        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}