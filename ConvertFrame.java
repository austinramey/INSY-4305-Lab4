import java.awt.GridLayout;
import java.awt.event.ActionListener;
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
        // MyEventHandler convertItemHandler = new MyEventHandler();
        // convertItem.addActionListener(convertItemHandler);

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

        // Button group for from selection
        dollarRadioButtonFrom = new JRadioButton("Dollar", true);
        pesoRadioButtonFrom = new JRadioButton("Peso", false);
        euroRadioButtonFrom = new JRadioButton("Euro", false);
        fromButtonGroup = new ButtonGroup();
        fromButtonGroup.add(dollarRadioButtonFrom);
        fromButtonGroup.add(pesoRadioButtonFrom);
        fromButtonGroup.add(euroRadioButtonFrom);

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
        
    }
}