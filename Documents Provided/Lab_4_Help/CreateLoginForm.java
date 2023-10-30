package Lab_4_Help;
//import required classes and packages

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//create CreateLoginForm class to create login form
//class extends JFrame to create a window where our component add
//class implements ActionListener to perform an action on button click
class CreateLoginForm extends JFrame implements ActionListener
{
    //initialize button, panel, label, and text field
    JButton b1, b2;
    JPanel newPanel;
    JLabel userLabel, passLabel,infoLabel;
    final JTextField  textField1, textField2;

    //calling constructor
    CreateLoginForm()
    {
        setTitle("Lab 4 Help Login Window");
        setLayout(new BorderLayout());
        Icon logo = new ImageIcon(getClass().getResource("user-login-305.png"));
        infoLabel = new JLabel(logo);
        infoLabel.setSize(new Dimension(20,20));
        //create label for username
        userLabel = new JLabel();
        userLabel.setText("Username");      //set label value for textField1

        //create text field to get username from the user
        textField1 = new JTextField(15);    //set length of the text

        //create label for password
        passLabel = new JLabel();
        passLabel.setText("Password");      //set label value for textField2

        //create text field to get password from the user
        textField2 = new JPasswordField(15);    //set length for the password

        //create submit button
        b1 = new JButton("SUBMIT"); //set label to button
        b2 = new JButton("EXIT");

        //create panel to put form elements
        newPanel = new JPanel(new GridLayout(3, 1));
        newPanel.add(userLabel);    //set username label to panel
        newPanel.add(textField1);   //set text field to panel
        newPanel.add(passLabel);    //set password label to panel
        newPanel.add(textField2);   //set text field to panel
        newPanel.add(b1);
        newPanel.add(b2);

        //add panel to frame
        add(infoLabel,BorderLayout.NORTH);
        add(newPanel,BorderLayout.CENTER);

        //perform action on button click
//        b1.addActionListener(this);     //add action listener to button
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userValue = textField1.getText();        //get user entered username from the textField1
                String passValue = textField2.getText();        //get user entered pasword from the textField2

                //check whether the credentials are authentic or not
                if (userValue.equals("insy4305") && passValue.equals("test")) {  //if authentic, navigate user to a new page

                    //create instance of the ConvertFrame
                    ConvertFrame page = new ConvertFrame();
                    page.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    page.setSize(350, 370); // set frame size
                    page.setVisible(true); // display frame
                    CreateLoginForm.this.dispose();
                }
                else{
                    //show error message
                    JOptionPane.showMessageDialog(null,"Please enter valid username and password");
                    System.out.println("Please enter valid username and password");
//            CreateLoginForm.this.dispose();
                }
            }
        });
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int r = JOptionPane.showConfirmDialog(null,
                        "Are you sure?", "Confirmation window", JOptionPane.YES_NO_OPTION);
                if(r == 0)
                    System.exit(0);
            }
        });

    }

    //define abstract method actionPerformed() which will be called on button click
    public void actionPerformed(ActionEvent ae)     //pass action listener as a parameter
    {
        String userValue = textField1.getText();        //get user entered username from the textField1
        String passValue = textField2.getText();        //get user entered pasword from the textField2

        //check whether the credentials are authentic or not
        if (userValue.equals("insy4305") && passValue.equals("test")) {  //if authentic, navigate user to a new page

            //create instance of the ConvertFrame
            ConvertFrame page = new ConvertFrame();
            page.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            page.setSize(350, 370); // set frame size
            page.setVisible(true); // display frame
            CreateLoginForm.this.dispose();
        }
        else{
            //show error message
            JOptionPane.showMessageDialog(null,"Please enter valid username and password");
            System.out.println("Please enter valid username and password");
//            CreateLoginForm.this.dispose();
        }
    }
}
//create the main class
class LoginFormDemo
{
    //main() method start
    public static void main(String arg[])
    {
            //create instance of the CreateLoginForm
            CreateLoginForm form = new CreateLoginForm();
            form.setSize(320,220);  //set size of the frame
            form.setVisible(true);  //make form visible to the user

    }
}
