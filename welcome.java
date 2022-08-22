import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

class welcome extends JFrame implements ActionListener
{   
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel w;
    JButton login;
    JButton signup;
 
    
    public welcome()
        {
            
            w=new JLabel("WELCOME TO MONEY TRANSFER");
            login=new JButton("LOGIN");
            signup=new JButton("SIGNUP");
            login.addActionListener(this);
            signup.addActionListener(this);
          
            
            add(w);
            add(login);
            add(signup);
          
            
            setSize(300,400);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLayout(new FlowLayout());
            setVisible(true);
            setLocationRelativeTo(null);
            setTitle("welcome to E-Payment");

        }
        public void actionPerformed(ActionEvent e)
        {
            if(e.getSource()==login)
            {
                new login();
            }
            if(e.getSource()==signup)
            {
                new signup();
            }
           
           
        }
        public static void main(String[] args) {
            new welcome();
        }

    
}

