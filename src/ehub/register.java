package ehub;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


@SuppressWarnings("serial")
public class register extends JFrame {
	public static String user_id;
	JFrame frame;
	JPanel L, R;
	JTabbedPane tabs;
	JLabel U,P,fname, EM, PS, CP,ph,EMAIL_ID;
	JTextField Ut, n, lname,pht,EMAIL;
	JPasswordField pass, p, C;
	JButton b, reg;
	java.sql.Connection conn = null;
	
	
	register(){
   conn=postconnection.dbconnector();
		
	frame = new JFrame("Welcome");
	frame.setSize(365,440);
	frame.setLayout(null);
	
	
	Image icon = Toolkit.getDefaultToolkit().getImage("D:\\applications\\eclipse\\ehub\\src\\techfoss.jpeg");  
  	frame.setIconImage(icon);
	
	L = new JPanel();
	L.setBounds(0, 80, 300, 350);
	L.setLayout(null);
	frame.add(L);
	
	R = new JPanel();
	R.setBounds(0, 80, 400, 450);
	R.setLayout(null);
	frame.add(R);
	
	
	tabs = new JTabbedPane();
	tabs.setBounds(0, 0, 350, 400);
	tabs.add("LOGIN",L);
	tabs.add("REGISTER",R);
	tabs.setBackground(new Color(0, 89, 100));
	tabs.setForeground(new Color(255, 255, 255));
	frame.add(tabs);
	
	  U= new JLabel("User ID :");
	  U.setBounds(12,80,250,25); 
	  L.add(U);
	  
	  Ut = new JTextField("");
	  Ut.setEditable(true);
	  Ut.setBounds(100,80,180,25);
	  L.add(Ut);
	  
	  P= new JLabel("Password :");
	  P.setBounds(12,150,180,25); 
	  L.add(P);
	  
	  pass = new JPasswordField();
	  pass.setBounds(100, 150, 180, 25);
	  L.add(pass);
	  
	  b = new JButton("LOGIN");
	  b.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				try {
					String  query="select client_id,c_password from login where client_id=? and c_password=? ";
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
						user_id=Ut.getText();
						dispose();
						clienthome obj1=new clienthome();
						obj1.setVisible(true);
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
					stmt.close();	
					dispose();
					frame.dispose();
					}
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null,"show  problem!");
					e1.printStackTrace();
				}
			}
		});
      b.setBounds(100,209,100,47);
      b.setBackground(new Color(0, 89, 100));
      b.setForeground(new Color(255, 255, 255));
	  L.add(b);
	
	  fname= new JLabel("First Name :");
	  fname.setBounds(10,50, 180, 25);
	  R.add(fname);
	  
	  n= new JTextField("");
	  n.setBounds(100, 50, 190, 25);
	  R.add(n);
	  
	  EM= new JLabel("	Last Name :");
	  EM.setBounds(10,90, 180, 25);
	  R.add(EM);
	  
	  lname = new JTextField("");
	  lname.setBounds(100, 90, 190, 25);
	  R.add(lname);
	  
	  PS= new JLabel("Password :");
	  PS.setBounds(10,130,180,25); 
	  R.add(PS);
	  
	  p = new JPasswordField();
	  p.setBounds(100, 130, 190, 25);
	  R.add(p);
	  
	  ph = new JLabel("Phone Number :");
	  ph.setBounds(10, 170, 190, 25);
	  R.add(ph);
	  
	  pht = new JTextField("");
	  pht.setColumns(10);
	  pht.setBounds(100, 170, 190, 25);
	  R.add(pht);
	  
	   EMAIL_ID = new JLabel("EMAIL_ID");
	  EMAIL_ID.setBounds(10, 210, 190, 25);
	  R.add(EMAIL_ID);
	  
	   EMAIL = new JTextField("");
	  EMAIL.setBounds(100, 210, 190, 25);
	  R.add(EMAIL);
	  
	  reg = new JButton("REGISTER");
	  reg.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				try {
                   String orde = null;
					String  incr="SELECT * FROM increment ORDER BY increment DESC LIMIT 1";
					PreparedStatement stmt=conn.prepareStatement(incr);
					ResultSet rs=stmt.executeQuery();
					while(rs.next())
					{
						orde=rs.getString("increment");
					}
					String ord="c-"+orde;
					rs.close();
					stmt.close();
					
					
					
						String  query="insert into client values(?,?,?,?,?)";
						PreparedStatement stmt11=conn.prepareStatement(query);
						
						stmt11.setString(1,ord);
						stmt11.setString(2,n.getText());
						stmt11.setString(3,lname.getText());
						stmt11.setString(4,EMAIL.getText());
						stmt11.setString(5,pht.getText());
						stmt11.execute();
						stmt11.close();
						
						String  pass="insert into login(client_id,c_password) values(?,?)";
						PreparedStatement stmt111=conn.prepareStatement(pass);
						
						stmt111.setString(1,ord);
						stmt111.setString(2,p.getText());
						JOptionPane.showMessageDialog(null,"registerd");
						JOptionPane.showMessageDialog(null,"your login_id : "+ord);
						stmt111.execute();
						
						
						stmt111.close();		
					
				
						int i=(Integer.parseInt(orde))+1;
						String  incre="insert into increment values(?)";
						PreparedStatement stmt1=conn.prepareStatement(incre);
						stmt1.setInt(1,i);
						stmt1.execute();
						stmt1.close();
					
					
					
					register obj=new register();
					obj.setVisible(true);
					dispose();
								}
				catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null,"updated problem");
					ex.printStackTrace();

				}
			}
		});
	  reg.setBounds(100,245,100,47);
	  reg.setBackground(new Color(0, 89, 100));
	  reg.setForeground(new Color(255, 255, 255));
	  R.add(reg);
	  frame.setVisible(true);
	  
	  
	}

	public static void main(String[] args) {
		new register();	  
	}
}