import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.*;

class transaction extends JFrame implements ActionListener
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel ss;
	JLabel email;
	JTextField email1;
	JButton btn;
	JButton jbtn;
	public transaction()
	{
		ss=new JLabel("PLEASE CONFIRM YOUR EMAIL");
		ss.setBounds(20, 50, 10, 10);
		email= new JLabel("Enter your email");
		email.setBounds(30, 50, WIDTH, HEIGHT);
		email1= new JTextField(20);
		email1.setBounds(50, 40, WIDTH, HEIGHT);
		btn=new JButton("see transction");
		btn.setBounds(70, 60, WIDTH, HEIGHT);
		jbtn=new JButton("GO TO HOME");
		
		add(ss);
		add(email);
		add(email1);
		add(btn);
		add(jbtn);
		btn.addActionListener(this);
		jbtn.addActionListener(this);
		setSize(250,600);
	    setVisible(true);
	    setLayout(new FlowLayout());
	    setLocationRelativeTo(null);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	        public void actionPerformed(ActionEvent e)
	      {
	        	if(e.getSource()==btn)
	        	{
	        	 try{ 

	        	    DatabaseConnection ob=new DatabaseConnection();
	        		Connection c = ob.con;	      		
	        		Statement st=(Statement) c.createStatement();
				   	ResultSet rs=st.executeQuery("select * from transaction ");  
				    while(rs.next())
				   { 
					 			    
				   if(email1.getText().equals(rs.getString(5)))
				   {
					  JOptionPane.showMessageDialog(this, "your id is "+rs.getString(1)+"\n"+" Receiver name is:"+rs.getString(2)+"\n"+"date is:"+rs.getString(3)+"\n"+"amount is :"+rs.getString(4)+"\n"+"email is:"+rs.getString(5));
				   }
				  
					  
				   }
				  
				  
				}  
				catch(SQLException ee){System.out.println(ee.getMessage());
				}
	        	}
	        	if(e.getSource()==jbtn)
	        	{
	        		new welcome();
	        	}
	      
	}
	        public static void main(String args[])
	        {
	        	new transaction();
	        }

	
}