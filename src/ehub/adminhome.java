package ehub;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;



@SuppressWarnings("serial")
public class adminhome extends JFrame {
	JFrame f;	
	JLabel name, logo, help, contact,note;
	JPanel panel;
	JButton a, b, c;
	Border brd;
	adminhome(){
		f =new JFrame("Admin home");
        f.setSize(800,800);
        f.setLayout(null);
        f.setVisible(true);
        
        //icon
        Image icon = Toolkit.getDefaultToolkit().getImage("D:\\applications\\eclipse\\ehub\\src\\techfoss.jpeg");  
    	f.setIconImage(icon);
    	
  		name= new JLabel("TECHFOSS");
		name.setBounds(650,15,350,40);
	    name.setFont(new Font("Eras Bold ITC",Font.BOLD,50));
		f.add(name);
		
		logo= new JLabel();
        ImageIcon imageIcon = new ImageIcon(new ImageIcon("D:\\applications\\eclipse\\ehub\\src\\techfoss.jpeg").getImage().getScaledInstance(50, 50, 3));
        logo.setBorder(brd);
        logo.setIcon(imageIcon);
    	logo.setBounds(590,2,75,75);
		f.add(logo);
		

		help= new JLabel("help");
		help.setBounds(1300,15,350,40);
	    help.setFont(new Font("Eras ITC",Font.ITALIC,20));
		f.add(help);
		
		contact= new JLabel("Contact us");
		contact.setBounds(1400,15,350,40);
	    contact.setFont(new Font("Eras ITC",Font.ITALIC,20));
		f.add(contact);
		
		  note= new JLabel("Welcome Admin, select your option to continue");
		  note.setBounds(100,20,500,500); 
		  note.setFont(new Font("Eras ITC",Font.ITALIC,20));
		  f.add(note);
		  
		  panel = new JPanel();
	  panel.setLayout(null);
	  panel.setBounds(0,340,1600,1600);
	  panel.setBackground(new Color(0, 89, 100));
	  f.add(panel);
	  
		
		a=new JButton("Employee Details");
		b=new JButton("Team allocation");
		c=new JButton("Projects");
        a.setBounds(250,100,200,200);
      	a.addActionListener(new button());
      	b.setBounds(650,100,200,200);
      	b.addActionListener(new button());
        c.setBounds(1050,100,200,200);
        c.addActionListener(new button());
        panel.add(a);
        panel.add(b);
        panel.add(c);
	}
	public class button implements ActionListener{
	   	 public void actionPerformed(ActionEvent e){
	   		 String str = e.getActionCommand();
	   		 if (str.equals("Employee Details")) {
	   			 empdetails obj = new empdetails();
	   			 obj.setVisible(true);
	   			 f.dispose();
	   		 }
	   		 else if (str.equals("Team allocation")) {
	   			 status_admin obj1 = new status_admin();
	   			 obj1.setVisible(true);
	   			 f.dispose();
	   		 }
	   		if (str.equals("Projects")) {
	   			 Project_lists obj2 = new Project_lists();
	   			 obj2.setVisible(true);
	   			 f.dispose();
	   		 }
	   	 }
	}
	
		public static void main(String[] args) {
			new adminhome();
		}
}
			