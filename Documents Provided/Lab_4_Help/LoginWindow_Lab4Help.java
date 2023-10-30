package Lab_4_Help;
import javax.swing.*;
public class LoginWindow_Lab4Help {
    //main() method start
    public static void main(String arg[])
    {
            //create instance of the CreateLoginForm
            CreateLoginForm form = new CreateLoginForm();
            form.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            form.setSize(320,220);  //set size of the frame
            form.setVisible(true);  //make form visible to the user
    }
}
