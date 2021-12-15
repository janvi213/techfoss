package ehub;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
@SuppressWarnings("serial")
public class welcome extends JFrame {
    JFrame frame;
	JPanel panel, other;
	JButton admin,user;
     Border brd;

	welcome(){

		frame = new JFrame();
		frame.setSize(600,600);
		frame.setLayout(null);
		frame.setVisible(true);
		
		Image icon = Toolkit.getDefaultToolkit().getImage("/Users/anjan/eclipse-workspace/PROJECT/src/LOGO.png");  
		frame.setIconImage(icon);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0,340,600,600);
		panel.setBackground(new Color(0, 89, 100));
		frame.add(panel);
		other = new JPanel();
		other.setLayout(null);
		other.setBounds(0,0,600,600);
		frame.add(other);
		
		JLabel name= new JLabel("TECHFOSS");
		name.setBounds(257,154,350,40);
	    name.setFont(new Font("Eras Bold ITC",Font.BOLD,50));
		other.add(name);
		
		JLabel logo= new JLabel();
        ImageIcon imageIcon = new ImageIcon(new ImageIcon("/Users/anjan/eclipse-workspace/PROJECT/src/LOGO.png").getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT));
        logo.setBorder(brd);
        logo.setIcon(imageIcon);
		logo.setBounds(30, 30, 200, 200);
		other.add(logo);
		
		JLabel note= new JLabel("Welcome to TechFoss,  sign up for the best software solutions! ");
		  note.setBounds(12,280,400,40); 
		  other.add(note);
	    
		 JLabel cont = new JLabel("to continue,");
		 cont.setForeground(new Color(255,255,255));
		 cont.setBounds(18,26,300,30);
		 panel.add(cont);
		 
		    user= new JButton();
	        ImageIcon image = new ImageIcon(new ImageIcon("/Users/anjan/eclipse-workspace/PROJECT/src/profile.png").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
	        user.setBorder(brd);
	        user.setIcon(image);
	        user.addActionListener( new Button());
			user.setBounds(120, 70, 110, 110);
			panel.add(user);
		 
			    admin= new JButton();
		        ImageIcon images = new ImageIcon(new ImageIcon("/Users/anjan/eclipse-workspace/PROJECT/src/profile.png").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
		        admin.setBorder(brd);
		        admin.setIcon(images);
		        admin.addActionListener(new Button());
				admin.setBounds(300, 70, 110, 110);
				panel.add(admin);
				
			JLabel CL= new JLabel("ADMIN");
			CL.setBounds(160,180,110,14);
			CL.setForeground(new Color(255,255,255));
		    panel.add(CL);
		    
		    JLabel ADM= new JLabel("CLIENT");
			ADM.setBounds(340,180,40,14);
			ADM.setForeground(new Color(255,255,255));
		    panel.add(ADM);
		    
	}
	
		public class Button implements ActionListener{
			 public void actionPerformed(ActionEvent e){
				 Object obj = e.getSource();
		  	 if (obj == user) {
		    			 login obj1 = new login();
		    			obj1.setVisible(true);
		    		frame.dispose();			
		    		 }
		  	 else if (obj == admin) {
		  		 register obj2 = new register();
		  		 obj2.setVisible (true);
		  		 frame.dispose();
		  	 }
			 }}
		
	public static void main(String[] args) {
	
		new welcome();
	}}

