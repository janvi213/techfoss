package ehub;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@SuppressWarnings("serial")

public class login extends JFrame {
	JFrame frame;
	JPanel panel,Lp;
	JButton b ;
	JLabel L,U,P;
	JTextField Ut;
	JPasswordField pass;
	java.sql.Connection conn = null;
	
	login(){
	conn = postconnection.dbconnector();
		frame = new JFrame("Login Page");
	  frame.getContentPane();
	  
	  Image icon = Toolkit.getDefaultToolkit().getImage("D:\\applications\\eclipse\\ehub\\src\\techfoss.jpeg");  
    	frame.setIconImage(icon);
		
	  panel = new JPanel();
	  panel.setLayout(null);
	  panel.setBounds(0,80,400,450);
      frame.add(panel);
	  Lp = new JPanel();
	  
	  frame.add(Lp); 
      L = new JLabel("LOGIN");
	  L.setBounds(143,35,150,20);
	  L.setFont(new Font("Times New Roman",Font.BOLD,30));
	  L.setForeground(new Color(255,255,255));
	  Lp.setBackground(new Color(0, 89, 100));
	  Lp.add(L);
	  
	  U= new JLabel("User ID :");
	  U.setBounds(12,80,250,25); 
	  panel.add(U);
	  
	  Ut = new JTextField("");
	  Ut.setEditable(true);
	  Ut.setBounds(100,80,230,25);
	  panel.add(Ut);
	  
	  P= new JLabel("Password :");
	  P.setBounds(12,150,230,25); 
	  panel.add(P);
	  
	  pass = new JPasswordField();
	  pass.setBounds(100, 150, 230, 25);
	  panel.add(pass);
	  
	  
	 
	b = new JButton("Login");
	b.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try {
				String  query="select admin_id,a_password from login where admin_id=? and a_password=? ";
				PreparedStatement stmt=conn.prepareStatement(query);
				stmt.setString(1,Ut.getText()); 
				stmt.setString(2,pass.getText()); 
				ResultSet rs=stmt.executeQuery();
				int count=0;
				while(rs.next())
				{
					count=count+1;
				}
				if(count==1)
				{
					JOptionPane.showMessageDialog(null,"user_id and password correct");
					
					
					
				}
				else if(count>1)
				{
					JOptionPane.showMessageDialog(null," duplicate user_id and password ");
				}
				else
				{
					JOptionPane.showMessageDialog(null," incorrect user_id and password!");
				}
				rs.close();
				stmt.close();		}
			catch(Exception e1)
			{
				JOptionPane.showMessageDialog(null,"show  problem!");
				e1.printStackTrace();
			}
		}
	});
    b.setBounds(15,209,100,47);
    b.setBackground(new Color(0, 89, 100));
    b.setForeground(new Color(255,255,255));
    b.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
        	//admin home 
        }
    });
    b.setFont(new Font("Times New Roman",Font.BOLD,14));
	  panel.add(b);
	  
	  frame.setSize(400, 450);
    frame.setVisible(true);
    
   
	}
	public static void main(String[] args) {
	  new login();
	}}
