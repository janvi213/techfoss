package ehub;

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//import java.sql.Connection;


@SuppressWarnings("serial")
public class clientprofile extends JFrame{
    JFrame a;
    JPanel b, c, d,f;
    JLabel  c0, c1, c2, c3, c4, i,j;
    JTextField d1, d2, d3, d0, d4;
    JButton save, editp, home;
    Border brd;
    
    java.sql.Connection conn = null;
    
    @SuppressWarnings("static-access")
	clientprofile(){
    	
    	conn=postconnection.dbconnector();
    	
    	a = new JFrame("TECHFOSS");
    	b = new JPanel();
        j = new JLabel("PROFILE");
        f = new JPanel();
        b.setLayout(new GridLayout(7,1,25,25));

        c = new JPanel();
        c.setLayout(new FlowLayout());
        c.setBackground(new Color(0, 89, 100));
        c.setBounds(0,0,600,70);
        
        d = new JPanel();
        d.setLayout(new FlowLayout());
        d.setBounds(50, 300, 70, 25);
        
        c0=new JLabel("Client id", JLabel.CENTER);//i have to connect to table
        c1=new JLabel("First Name", JLabel.CENTER);
        c2=new JLabel("Second Name", JLabel.CENTER);
        c3=new JLabel("Phone Number", JLabel.CENTER);
        c4=new JLabel("Email id", JLabel.CENTER);
        
        d1=new JTextField(30);
        d2=new JTextField(30);
        d3=new JTextField(30);
        d4=new JTextField(30);
        d0=new JTextField(30);
        
        d0.setBorder(null);
        
        d1.addActionListener(new editclient());
        d2.addActionListener(new editclient());
        d3.addActionListener(new editclient());
        d0.addActionListener(new editclient());
        d4.addActionListener(new editclient());
        try {
        	 register obj=new register();
	    	 String query="select fname,lname,email_id,phn from client where client_id='"+obj.user_id+"'";
	    	 PreparedStatement stmt=conn.prepareStatement(query);
	    	 ResultSet rs=stmt.executeQuery();
	    	 while(rs.next())
	    	 {
	    	 d0.setText(obj.user_id);
	    	 d1.setText(rs.getString("fname"));
	    	 d2.setText(rs.getString("lname"));
	    	 d3.setText(rs.getString("email_id"));
	    	 d4.setText(rs.getString("phn"));
	    	 }
	    	 rs.close();
	    	 stmt.close(); }
	    	 catch(Exception e1)
	    	 {
	    	 JOptionPane.showMessageDialog(null,"show problem!");
	    	 e1.printStackTrace();
	    	 }
        
        d1.setEditable(false);
        d2.setEditable(false);
        d3.setEditable(false);
        d0.setEditable(false);
        d4.setEditable(false);
        
        b.add(c0);
        b.add(d0);
        b.add(c1);
        b.add(d1);
        b.add(c2);
        b.add(d2);
        b.add(c3);
        b.add(d3);
        b.add(c4);
        b.add(d4);
        b.setBounds(100, 100, 300, 300);
        
        save=new JButton("save");
        save.setBounds(270, 370, 70, 25);
        save.addActionListener(new editclient());
        a.add(save);
        editp=new JButton("Edit Profile");
        editp.setBounds(400,30,120,25);
        editp.addActionListener(new editclient());
        a.add(editp);
        home=new JButton("Home");
        ImageIcon i = new ImageIcon(new ImageIcon("D:\\applications\\eclipse\\ehub\\src\\homeicon.png").getImage().getScaledInstance(25, 25, 5));
		home.setIcon(i);
		home.setBackground(new Color(0, 89, 100));
      	home.setForeground(Color.white);
		home.setBounds(10, 10, 100, 25);
		home.setBorder(null);
      	home.addActionListener(new editclient());
        a.add(home);
        
      //icon
      	Image icon = Toolkit.getDefaultToolkit().getImage("D:\\applications\\eclipse\\ehub\\src\\techfoss.jpeg");  
      	a.setIconImage(icon);
		
		a.add(c);
        a.add(b);
        a.add(d);
        a.setSize(600,500);
        a.getContentPane().setBackground(new Color(0,89,100));
        a.setLocationRelativeTo(null);
        getRootPane().setBorder(BorderFactory.createLineBorder(Color.black));
        a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        a.setVisible(true);
    }
    public class editclient implements ActionListener{
    	 @SuppressWarnings("static-access")
		public void actionPerformed(ActionEvent e){
    		 String str = e.getActionCommand();
    		 
    		 if (str.equals("Edit Profile")) {
    			 d1.setEditable(true);
    		     d2.setEditable(true);
    		     d3.setEditable(true);
    		     d4.setEditable(true);
    		     
    			 d1.getText();
    		     d2.getText();
    		     d3.getText();
    		     d4.getText();
    		     
    		 }
    		 else if(str.equals("save")) {
    			 
    		     try {
    		    	 String query="UPDATE client SET fname='"+d1.getText()+"',lname='"+d2.getText()+"',email_id='"+d4.getText()+"',phn='"+d3.getText()+"' where client_id='"+d0.getText()+"'";
    		    	 PreparedStatement stmt=conn.prepareStatement(query);
    		    	 stmt.execute();
    		    	 d1.setEditable(false);
    		    	 d2.setEditable(false);
    		    	 d3.setEditable(false);
    		    	 d4.setEditable(false);
    		    	 stmt.close(); 
    		    	 }
    		    	 catch(Exception e1){
    		    	 JOptionPane.showMessageDialog(null,"show problem!");
    		    	 e1.printStackTrace();
    		    	 }
    		 }		 
    		 
    		 else if (str.equals("Home")) {
    			 clienthome obj1 = new clienthome();
    			 obj1.setVisible(true);
    			 a.dispose();
    		 }
    		 
    		 
    		 }
    	 }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new clientprofile();
	}

}
