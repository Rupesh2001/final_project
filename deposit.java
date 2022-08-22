import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
class deposit extends JFrame implements ActionListener
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel jbl1;
	JTextField jtf1;
	JLabel jbl2;
	JTextField jtf2;
	JButton btn;
	public deposit()
	{
		jbl1=new JLabel("ENTER MONEY");
		jtf1=new JTextField(20);
		jbl2=new JLabel("ENTER EMAIL");
		jtf2=new JTextField(20);
		btn=new JButton("LOAD MONEY");
		add(jbl1);
		add(jtf1);
		add(jbl2);
		add(jtf2);
		
		add(btn);
		btn.addActionListener(this);
		setSize(250,600);
	    setVisible(true);
	    setLayout(new FlowLayout());
	    setLocationRelativeTo(null);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void actionPerformed(ActionEvent ae)
	{
		 try{ 

		    	DatabaseConnection ob=new DatabaseConnection();
			    Connection c = ob.con;
			    Statement st=(Statement) c.createStatement();
			   	 String em=jtf1.getText();
			   	 
		       // ResultSet rs=st.executeQuery("select email from  signup"); 
		        
		       // if(jtf2.getText().equals(rs.getString(1)))
		     //  {
		        	
		// st.executeUpdate("UPDATE 'signup' SET`money`='["+em+"]' WHERE email='"+jtf2.getText()+"'");
		        	st.executeUpdate("UPDATE signup SET money = '"+em+"' WHERE email = '"+jtf2.getText()+"'");
		       
				 // }
	    		}
		catch(Exception ee)
		{
			System.out.print("message"+ee);
		}
		 
	}
	public static void main (String[] args)
	{
		new deposit();
	}


}