import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class createpassword extends JFrame implements ActionListener {

	JLabel em;
	JTextField jtf1;
	public JLabel jbl;
	JButton btn;
	JButton jbtn;
	public createpassword()
	{
		em=new JLabel("enter your email");
		jtf1=new JTextField(20);
		jbl=new JLabel("");
		btn= new JButton("see your password");
		jbtn=new JButton("GO TO HOME");
		add(em);
		add(jtf1);
		add(jbl);
		add(btn);
		add(jbtn);
		jbtn.addActionListener(this);
		btn.addActionListener(this);
		
		
		setSize(200,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		setVisible(true);
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==btn)
		{
		 try{ 

		    	DatabaseConnection ob=new DatabaseConnection();
			  Connection c = ob.con;
			
			  Statement st=(Statement) c.createStatement();
			  ResultSet rs=st.executeQuery("select * from signup where email='"+jtf1.getText()+"'");
			//  while(rs.next()) 
			 // {
				//  if(usertext.getText().equals(rs.getString(1))&&userpassword.getText().equals(rs.getString(2))&&jel.getText().equals(rs.getString(3)))
				if(rs.next())
			  { 
					 jbl.setText(rs.getString(2));
					  } 
				  else
				  {
					  JOptionPane.showMessageDialog(this,"invalid email ");
				  }
				//  }
			
			  } 
		    catch(SQLException ee)
		    {
		    	System.out.println(ee.getMessage()); 
		    } 
		    	}
		if(ae.getSource()==jbtn) {
			new welcome();
		}
	}
	
	public static void main(String[] args)
	{
		new createpassword();
	}
}
