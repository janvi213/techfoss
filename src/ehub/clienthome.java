package ehub;

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.*;


@SuppressWarnings("serial")
public class clienthome extends JFrame {
	JFrame a;
	JPanel b, c, d;
	JLabel e, f;
	JButton order, status, profile, logout, contact, help, pay;
	Border brd;
	
	clienthome(){
		a = new JFrame("TECHFOSS");
		Image icon = Toolkit.getDefaultToolkit().getImage("D:\\applications\\eclipse\\ehub\\src\\techfoss.jpeg");  
      	a.setIconImage(icon);
      	
      	b = new JPanel();
		b.setLayout(null);
		b.setBounds(0,0,300,250);
		a.add(b);
		d = new JPanel();
		d.setLayout(null);
		d.setBounds(320,0,500,500);
		d.setBackground(new Color(0, 89, 100));
		a.add(d);
		c = new JPanel();
		c.setLayout(null);
		c.setBounds(250,0,500,500);
		a.add(c);
		
		e= new JLabel();
        ImageIcon imageIcon = new ImageIcon(new ImageIcon("D:\\applications\\eclipse\\ehub\\src\\techfoss.jpeg").getImage().getScaledInstance(100, 100, 10));
        e.setIcon(imageIcon);
		e.setBounds(100,1, 100, 200);  
		b.add(e);
		f= new JLabel("TECHFOSS");
		f.setBounds(70, 70, 200, 200);
	    f.setFont(new Font("Eras Bold ITC",Font.BOLD,30));
		b.add(f);
		
		order=new JButton("Order");
		order.addActionListener(new button());
		ImageIcon i3 = new ImageIcon(new ImageIcon("D:\\applications\\eclipse\\ehub\\src\\cart.jpg").getImage().getScaledInstance(25, 25, 5));
		order.setIcon(i3);
		order.setBackground(Color.white);
		order.setForeground(Color.black);
		order.setBounds(50, 300, 100, 25);
		c.add(order);      	
      	status=new JButton("Status");
      	status.setBackground(Color.white);
		status.setForeground(Color.black);
		status.addActionListener(new button());
		status.setBounds(200, 300, 70, 25);
      	c.add(status);
      	
      	profile=new JButton("Profile");
      	profile.setBackground(new Color(0, 89, 100));
      	profile.setForeground(Color.white);
      	profile.addActionListener(new button());
      	profile.setBounds(35, 70, 100, 25);
      	d.add(profile);
      	logout=new JButton("Logout");
      	logout.setBackground(new Color(0, 89, 100));
      	logout.setForeground(Color.white);
      	logout.addActionListener(new button());
      	logout.setBounds(35, 170, 100, 25);
        d.add(logout);
      	contact=new JButton("Contact us");
      	contact.setBackground(new Color(0, 89, 100));
      	contact.setForeground(Color.white);
      	contact.setBorder(null);
      	contact.addActionListener(new button());
      	contact.setBounds(35, 270, 100, 25);
      	d.add(contact);
      	help=new JButton("Help");
      	help.setBackground(new Color(0, 89, 100));
      	help.setForeground(Color.white);
      	help.setBorder(null);
		help.addActionListener(new button());
		help.setBounds(35, 370, 100, 25);
      	d.add(help);
      	
      	
      	a.setSize(500,500);
        a.setLocationRelativeTo(null);
        a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        a.setVisible(true);
	}
	
	public class button implements ActionListener{
   	 public void actionPerformed(ActionEvent e){
   		 String str = e.getActionCommand();
   		 if (str.equals("Order")) {
   			purschase obj3 = new purschase();
   			obj3.setVisible(true);
   			a.dispose();
   		 }
   		 else if (str.equals("Status")) {
   			status_client obj4 = new status_client();
   			obj4.setVisible(true);
   			a.dispose();
  		 }
   		else if (str.equals("Profile")) {
 			 clientprofile obj1 = new clientprofile();
 			 obj1.setVisible(true);
 			 a.dispose();
 		 }
   		else if (str.equals("Logout")) {
			register obj2 = new register();
   			obj2.setVisible(true);
   			a.dispose();
		 }
   		else if (str.equals("Contact us")) {
 			 //null;
 		 }
   		else if (str.equals("Help")) {
 			 //null;
 		 }
   		
   	 }
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new clienthome();

	}

}

