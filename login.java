import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
//import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.*;
class login extends JFrame implements ActionListener
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel user;
    JLabel password;
    JLabel email;
    JLabel str;
    JTextField jel;
    JTextField usertext;
    JTextField userpassword;
    JButton btn;
    JButton forpwd;
    JButton back;
    
    public login(){
        user = new JLabel("NAME");
        password = new JLabel("PASSWORD");
        email=new JLabel("ENTER YOUR EMAIL");
        jel=new JTextField(10);
        str=new JLabel("PLEASE SIGNUP");
        usertext = new JTextField(10);
        userpassword = new JTextField(10);
        btn = new JButton("LOGIN "); 
        forpwd=new JButton("FORGOT PASSWORD");
        back=new JButton("GO TO HOME");
        add(email);
        add(usertext);      
        add(password);
        add(userpassword);
        add(user);
        add(jel);          
        add (btn);
        add(forpwd);
        add(back);
        btn.addActionListener(this);
        forpwd.addActionListener(this);
        back.addActionListener(this);
        setSize(100,250);
        setVisible(true);
        setLayout(new FlowLayout());
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("hello");
    }
    public void actionPerformed(ActionEvent fg)    
    { 
    	if(fg.getSource()==btn)
    	{

    try{ 

    	DatabaseConnection ob=new DatabaseConnection();
	    Connection c = ob.con;
	
	    Statement st=(Statement) c.createStatement();
	    ResultSet rs=st.executeQuery("select * from signup where email='"+usertext.getText()+"' and password='"+userpassword.getText()+"' and name='"+jel.getText()+"'");
	//  while(rs.next()) 
	 // {
		//  if(usertext.getText().equals(rs.getString(1))&&userpassword.getText().equals(rs.getString(2))&&jel.getText().equals(rs.getString(3)))
		 if(rs.next())
	     { 
			  new two();
			  } 
		  else
		  {
			  JOptionPane.showMessageDialog(this,"invalid");
		  }
		//  }
	
	  } 
    catch(SQLException ee)
    {
    	System.out.println(ee.getMessage()); 
    } 
    	}
    
    if(fg.getSource()==forpwd)
    {
    	new createpassword();
    }
    if(fg.getSource()==back)
    {
    	new welcome();
    }
    }
    public static void main(String [] args){
        new login();
    }
}
