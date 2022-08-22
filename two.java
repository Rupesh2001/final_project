import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class two extends JFrame implements ActionListener
{
	JButton btn;
	JButton btn1;
	   JButton tran;
		public two()
		{
			btn=new JButton("SEND MONEY");
			btn1= new JButton("LOAD MONEY");
			tran=new JButton("SEE TRANSACTION");
			  tran.addActionListener(this);
			add(btn);
			add(btn1);
			  add(tran);
			 setSize(250,600);
		       setVisible(true);
		        setLayout(new FlowLayout());
		        setLocationRelativeTo(null);
		        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			btn.addActionListener(this);
			btn1.addActionListener(this);
		}
		public void actionPerformed(ActionEvent ae)
		{
			if(ae.getSource()==btn)
			{
				new payment();
			}
			if(ae.getSource()==btn1)
			{
				new deposit();
			}
			 if(ae.getSource()==tran)
	            {
	            	new transaction();
	            }
		}
		public static void main(String[] args)
		{
			new two();
		}
}
