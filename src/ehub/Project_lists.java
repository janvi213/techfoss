package ehub;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

@SuppressWarnings("serial")
public class Project_lists extends JFrame {
	private static Border brd;
	java.sql.Connection conn = null;
	Project_lists(){
		conn=postconnection.dbconnector();
		JFrame f =new JFrame("Employee details");
		f.setSize(800,800);
        f.setLayout(null);
        f.setVisible(true);
        
        JTextField empid;
    	JTextField fname;
        JTextField lname;
        JTextField qual;
    	JTextField spcl;
        
    	
      //icon
      		Image icon = Toolkit.getDefaultToolkit().getImage("D:\\applications\\eclipse\\ehub\\src\\techfoss.jpeg");
      		f.setIconImage(icon);
      		
      		JButton home=new JButton("Home");
	        ImageIcon i = new ImageIcon(new ImageIcon("D:\\applications\\eclipse\\ehub\\src\\homeicon.png").getImage().getScaledInstance(25, 25, 5));
			home.setIcon(i);
			home.setBackground(new Color(239,238,239));
	      	home.setForeground(Color.black);
			home.setBounds(10, 10, 100, 25);
			home.setBorder(null);
			home.addActionListener(new ActionListener() {
	      		public void actionPerformed(ActionEvent e) {
	      			adminhome obj = new adminhome();
	      			obj.setVisible(true);
	      			f.dispose();
	      		}
	      	});
	        f.add(home);
      		
      		JLabel name= new JLabel("TECHFOSS");
    		name.setBounds(650,15,350,40);
    	    name.setFont(new Font("Eras Bold ITC",Font.BOLD,50));
    		f.add(name);
    		
    		JLabel logo= new JLabel();
            ImageIcon imageIcon = new ImageIcon(new ImageIcon("D:\\applications\\eclipse\\ehub\\src\\techfoss.jpeg").getImage().getScaledInstance(50, 50, 3));
            logo.setBorder(brd);
            logo.setIcon(imageIcon);
        	logo.setBounds(590,2,75,75);
    		f.add(logo);
    		
    		JLabel help= new JLabel("help");
    		help.setBounds(1300,15,350,40);
    	    help.setFont(new Font("Eras ITC",Font.ITALIC,20));
    		f.add(help);
    		
    		JLabel contact= new JLabel("Contact us");
    		contact.setBounds(1400,15,350,40);
    	    contact.setFont(new Font("Eras ITC",Font.ITALIC,20));
    		f.add(contact);
    		
    		JPanel panela = new JPanel();
			panela.setLayout(null);
			panela.setBounds(0,200,1600,1600);
			panela.setBackground(new Color(0, 89, 100));
			f.add(panela);
			

			/*JButton home = new JButton("HOME");
			f.add(home);
			home.setBounds(10,10,130,50);*/
			
			

			JLabel note= new JLabel("<HTML><U>PROJECTS TABLE</U></HTML>");
			  note.setBounds(150,0,500,70); 
			  note.setFont(new Font("Eras ITC",Font.ITALIC,30));
			  note.setForeground(Color.white);
			 
			  panela.add(note);
			 

			JLabel textempid= new JLabel("SOFTWARE_ID :");
			  textempid.setBounds(300, 400, 100, 30); 
			  textempid.setForeground(Color.white);
			  panela.add(textempid);

			
			empid= new JTextField();
			empid.setBounds(400, 400, 100, 25);
			panela.add(empid);
			empid.setColumns(10);
			

			JLabel textfname= new JLabel("Software Name:");
			  textfname.setBounds(600, 400, 100, 30); 
			  textfname.setForeground(Color.white);
			  panela.add(textfname);

			
			fname = new JTextField();
			fname.setBounds(700, 400, 100, 25);
			panela.add(fname);
			fname.setColumns(10);
			

			JLabel textlname= new JLabel("price :");
			  textlname.setBounds(950, 400, 100, 30); 
			  textlname.setForeground(Color.white);
			  panela.add(textlname);

			
			lname = new JTextField();
		    lname.setBounds(1000, 400, 100, 25);
			panela.add(lname);
		    lname.setColumns(5);
		    

			JLabel textqual= new JLabel("Team_Leader_ID :");
			  textqual.setBounds(390, 480, 110, 30); 
			  textqual.setForeground(Color.white);
			  panela.add(textqual);

			
			
			qual = new JTextField();
			qual.setBounds(510, 480, 100, 25);
			panela.add(qual);
			qual.setColumns(10);
			

			JLabel textspcl= new JLabel("No. of Orders:");
			  textspcl.setBounds(735, 480, 100, 30); 
			  textspcl.setForeground(Color.white);
			  panela.add(textspcl);

			

		    spcl= new JTextField();
			spcl.setBounds(830, 480, 100, 25);
			panela.add(spcl);
			spcl.setColumns(10);
			

	
		    

			JButton projbutt = new JButton("employeedet");
			panela.add(projbutt);
			projbutt.setBounds(0,140,70,150);
			projbutt.addActionListener(new ActionListener() {
	      		public void actionPerformed(ActionEvent e) {
	      			empdetails obj1 = new empdetails();
	      			obj1.setVisible(true);
	      			f.dispose();
	      		}
	      	});
            

			JButton teambutt = new JButton("Team alloc");
			panela.add(teambutt);
			teambutt.setBounds(0,300,70,150);
			teambutt.addActionListener(new ActionListener() {
	      		public void actionPerformed(ActionEvent e) {
	      			status_admin obj1 = new status_admin();
		   			 obj1.setVisible(true);
		   			 f.dispose();
	      		}
	      	});




			
			DefaultTableModel model = new DefaultTableModel(); 
		      JTable table = new JTable(model); 
		      JScrollPane scroller = new JScrollPane(table);
		      scroller.setBounds(300, 90, 800, 250);
		       String[] col= {"Software_ID","Software_Name","Price","Team_leader_ID","No_of_Orders"};
		       model.setColumnIdentifiers(col);
		       table.setModel(model);
		       panela.add(scroller);
		       /*try {
		    	   //JOptionPane.showMessageDialog(help, "d");
		    	   String s2 = "";
		    	   String s3 = "";
		    	   String s4 = "";
		    	   String s5 = "";
		    	   String s6 = "";
		    	   String s7 = "";
		       
		    	  
		    	   PreparedStatement st =((java.sql.Connection) c).prepareStatement("select * from employee_details");
		    	
		  		     	   if(conn!=null) {
		  		     		JOptionPane.showMessageDialog(help, "okk");
		    		   }else {
		    			   JOptionPane.showMessageDialog(help, "failed");
		    		   }
		    		   
		    		   
		    	   
		       }
		       catch(SQLException s1){
		    	   s1.printStackTrace();
		    	   
		       }*/

		       JButton addbtn = new JButton("ADD");
				panela.add(addbtn);
				addbtn.setBounds(1300,100,130,50);
				try {
					String  query="select * from order_details";
					PreparedStatement stmt=conn.prepareStatement(query);
					ResultSet rs=stmt.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					rs.close();
					stmt.close();	
		       }
				catch(Exception e)
				{
					JOptionPane.showMessageDialog(null,"show  problem!");
					e.printStackTrace();
				}
				addbtn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							String  query2="insert into order_details values(?,?,?,?,?)";
							PreparedStatement stmt11=conn.prepareStatement(query2);
							
							stmt11.setString(1,empid.getText());
							stmt11.setString(2,fname.getText());
							stmt11.setString(3,lname.getText());
							stmt11.setString(4,qual.getText());
							stmt11.setString(5,spcl.getText());
							stmt11.execute();
							stmt11.close();	
							
							String  query="select * from order_details";
							PreparedStatement stmt=conn.prepareStatement(query);
							ResultSet rs=stmt.executeQuery();
							table.setModel(DbUtils.resultSetToTableModel(rs));
							JOptionPane.showMessageDialog(null,"order details inserted");
							rs.close();
							stmt.close();
																				
							}
						catch(Exception e1)
						{
							JOptionPane.showMessageDialog(null,"show  problem!");
							e1.printStackTrace();
						}
	}
					});


				JButton updatebtn = new JButton("UPDATE");
				panela.add(updatebtn);
				updatebtn.setBounds(1300,180,130,50);
				

				JButton deletebtn = new JButton("DELETE");
				panela.add(deletebtn);
				deletebtn.setBounds(1300,260,130,50);
	}

	public static void main(String[] args) {
		new Project_lists();


}

	}